package com.gildedrose

import java.util.*

fun main() {
    println ("Type the number of days and the Goblin will update the quality")
    val scanner = Scanner(System.`in`)
    val days= scanner.nextInt()
    try {
        val gildedRose = GildedRose(Inventory.findAll())
        for (i in 1..days) {
            println("----------day $i")
            gildedRose.updateQuality()
            Inventory.findAll().forEach {
                println(it.toString())
            }
        }
    }catch (e:IllegalStateException) {
        println("ERROR:!! ${e.message}")
    }
}
