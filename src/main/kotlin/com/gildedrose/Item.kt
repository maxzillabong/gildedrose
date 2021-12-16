package com.gildedrose

open class Item(var name: String, open var sellIn: Int, open var quality: Int) {
    open fun updateQuality() {
        sellIn -= 1
        if (sellIn < 0) quality -= 2 else quality -= 1 //once sellin drop below 0, quality decrease 2x
        if (quality < 0) quality = 0 // quality cannot drop below 0
        validate()
    }
    fun validate () {
        if (quality < 0) {
            quality = 0
        }
        if (quality > 50) {
            quality = 50
        }
    }
    override fun toString(): String {
        return "$name, $sellIn, $quality"
    }
}

class AgedBrie(override var sellIn:Int, override var quality:Int):
    Item("Aged Brie", sellIn, quality) {
    override fun updateQuality() {
        if (sellIn > 0) quality += 1 else quality += 2
        sellIn -= 1
        validate()
    }
}

class Conjured(override var sellIn:Int, override var quality:Int):
    Item("Conjured Mana Cake", sellIn, quality) {
    override fun updateQuality() {
        quality -= 2
        sellIn -= 1
        validate()
    }
}

class BackStage(override var sellIn:Int, override var quality:Int):
    Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) {
    override fun updateQuality() {
        when {
            sellIn <= 0 -> quality = 0
            sellIn in 1..5 -> quality += 3
            sellIn in 6..10 -> quality += 2
            else -> quality += 1
        }
        sellIn -= 1
        validate()
    }
}

class Sulfuras(override var sellIn:Int, override var quality:Int):
    Item("Sulfuras, Hand of Ragnaros", sellIn, quality) {
    override fun updateQuality() {
        // does nothing
    }
}

fun createItem (name:String, sellIn: Int, quality: Int): Item {
    return when  {
        name.contains("Aged Brie", true) -> AgedBrie(sellIn,quality)
        name.contains("Conjured",true) -> Conjured(sellIn, quality)
        name.contains("Backstage",true) -> BackStage(sellIn, quality)
        name.contains("Sulfuras",true) -> Sulfuras(sellIn, quality)
        else -> Item(name, sellIn, quality)
    }
}

