package Models

import Enums.CountryEnum

data class Country(
    val id: Int,
    val image: Int,
    val name: String,
    val continent: CountryEnum
) {}