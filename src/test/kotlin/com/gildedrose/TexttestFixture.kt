package com.gildedrose

fun main(args: Array<String>) {

    println("OMGHAI!")

    val items = Inventory.findAll()

    val app = GildedRose(items)

    var days = 2
    if (args.isNotEmpty()) {
        days = Integer.parseInt(args[0]) + 1
    }

    for (i in 0 until days) {
        println("-------- day $i --------")
        println("name, sellIn, quality")
        for (item in items) {
            println(item)
        }
        println()
        app.updateQuality()
    }


}