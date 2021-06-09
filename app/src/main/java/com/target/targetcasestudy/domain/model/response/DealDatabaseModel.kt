package com.target.targetcasestudy.domain.model.response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DealDatabaseModel(
    @PrimaryKey
    val id: Int?,
    val title: String?,
    val description: String?,
    val aisle: String?,
    val displayPrice: String?,
    val image_url: String?
)

fun List<DealDatabaseModel>.asDomainModel(): List<DealDomainModel> {
    return map{
        DealDomainModel(
            id = it.id,
            title = it.title,
            description = it.description,
            aisle = it.aisle,
            displayPrice = it.displayPrice,
            image_url = it.image_url
        )
    }
}
