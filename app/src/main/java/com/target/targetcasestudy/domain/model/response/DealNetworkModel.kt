package com.target.targetcasestudy.domain.model.response

data class DealListNetworkContainer(
    val products: List<DealNetworkModel>?
)

data class DealNetworkModel(
    var id: Int? = 0,
    var title: String? = "",
    var description: String? = "",
    var aisle: String? = "",
    var regular_price: AmountDetails,
    val image_url: String?
)

data class AmountDetails(
    val amount_in_cents: String? = "",
    val currency_symbol: String? = "",
    val display_string: String? = ""
)

//"regular_price":{"amount_in_cents":18406,"currency_symbol":"$","display_string":"$184.06"}}

fun List<DealNetworkModel>.asDomainModel(): List<DealDomainModel> {
    return map{
        DealDomainModel(
            id = it.id,
            title = it.title,
            description = it.description,
            aisle = it.aisle,
            displayPrice = it.regular_price.display_string,
            image_url = it.image_url
        )
    }
}

fun List<DealNetworkModel>.asDatabaseModel(): Array<DealDatabaseModel> {
    return map{
        DealDatabaseModel(
            id = it.id,
            title = it.title,
            description = it.description,
            aisle = it.aisle,
            displayPrice = it.regular_price.display_string,
            image_url = it.image_url
        )
    }.toTypedArray()
}
