package com.example.c8103a1

// CHALLENGE 1 SESSION 1
data class BakeryItem(
    val name: String,
    val sold: Double,
    val price: Double
){
    //   CHALLENGE 2 SESSION 1
    fun revenue(): Double {
        return sold * price
    }
}