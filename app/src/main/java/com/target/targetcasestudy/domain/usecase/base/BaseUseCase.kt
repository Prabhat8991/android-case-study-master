package com.target.targetcasestudy.domain.usecase.base

import com.target.targetcasestudy.data.mapper.ApiErrorMapper
import com.target.targetcasestudy.domain.model.response.ErrorModel
import com.target.targetcasestudy.domain.usecase.DefaultDispatcherProvider
import com.target.targetcasestudy.domain.usecase.DispatcherProvider
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

typealias CompletionBlock<T> = BaseUseCase.Request<T>.() -> Unit

abstract class BaseUseCase<T>(val apiErrorMapper: ApiErrorMapper? = null, private val dispatchers: DispatcherProvider = DefaultDispatcherProvider()) {
    private var parentJob: Job = Job()
    var backgroundContext: CoroutineContext = dispatchers.io()
    var foregroundContext: CoroutineContext = dispatchers.main()

    protected abstract suspend fun executionOnBackGround(): T

    fun execute(block: CompletionBlock<T>) {
        val response = Request<T>().apply { block() }
        unsubscribe()
        parentJob = Job()
        CoroutineScope(foregroundContext + parentJob).launch {
            try {
                val result = withContext(backgroundContext) {
                    executionOnBackGround()
                }
                response(result)
            } catch (cancellationException: CancellationException) {
                response(cancellationException)
            } catch (e: Exception) {
                val error = apiErrorMapper?.mapToDomainErrorException(e)
                response(error)
            }
        }
    }


    fun unsubscribe() {
        parentJob.apply {
            cancelChildren()
            cancel()
        }
    }

    class Request<T> {
        private var onComplete: ((T) -> Unit)? = null
        private var onError: ((ErrorModel) -> Unit)? = null
        private var onCancel: ((CancellationException) -> Unit)? = null

        fun onComplete(block: (T) -> Unit) {
            onComplete = block
        }

        fun onError(block: (ErrorModel) -> Unit) {
            onError = block
        }

        fun onCancel(block: (CancellationException)-> Unit) {
            onCancel = block
        }

        operator fun invoke(result: T) {
            onComplete?.let {
                it.invoke(result)
            }
        }

        operator fun invoke(error: ErrorModel?) {
            onError?.let {onError ->
                error?.let {
                   onError.invoke(it)
                }
            }
        }

        operator fun invoke(error: CancellationException) {
            onCancel?.let {
                it.invoke(error)
            }
        }
    }

}
