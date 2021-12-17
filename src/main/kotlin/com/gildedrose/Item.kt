package com.gildedrose

open class Item(private var name: String, open var sellIn: Int, open var quality: Int) {
    open fun updateQuality() {
        sellIn -= 1
        quality -= if (sellIn < 0) 2 else 1 //once sellin drop below 0, quality decrease 2x
        if (quality < 0) quality = 0 // quality cannot drop below 0
        correct()
    }
    fun correct () {
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
    Item(AGED_BRIE, sellIn, quality) {
    override fun updateQuality() {
        quality += if (sellIn > 0) 1 else 2
        sellIn -= 1
        correct()
    }
}

class Conjured(override var sellIn:Int, override var quality:Int):
    Item(CONJURED, sellIn, quality) {
    override fun updateQuality() {
        quality -= 2
        sellIn -= 1
        correct()
    }
}

class BackStage(override var sellIn:Int, override var quality:Int):
    Item(BACKSTAGE, sellIn, quality) {
    override fun updateQuality() {
        when {
            sellIn <= 0 -> quality = 0
            sellIn in 1..5 -> quality += 3
            sellIn in 6..10 -> quality += 2
            else -> quality += 1
        }
        sellIn -= 1
        correct()
    }
}

class Sulfuras(override var sellIn:Int, override var quality:Int):
    Item(SULFURAS, sellIn, quality) {
    override fun updateQuality() {
        // does nothing
    }
}

