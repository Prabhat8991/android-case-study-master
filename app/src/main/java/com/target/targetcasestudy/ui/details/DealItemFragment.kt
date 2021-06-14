package com.target.targetcasestudy.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.target.targetcasestudy.databinding.FragmentDealItemBinding
import com.target.targetcasestudy.ui.dealslist.DealsViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class DealItemFragment : DaggerFragment() {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    // Inflate the layout for this fragment
    val binding = FragmentDealItemBinding.inflate(inflater)
    val viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(DealsViewModel::class.java)
    binding.dealItem = viewModel.selectedDealModel.value
    binding.executePendingBindings()
    return binding.root
  }
}
