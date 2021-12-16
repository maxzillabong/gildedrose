package com.gildedrose

class GildedRose(
    private val items: Array<Item>
) {

    fun updateQuality() {
        items.forEach {
            when  {
                it.name.contains("Aged Brie", true) -> handleAgedBrie(it)
                it.name.contains("Conjured",true) -> handleConjured(it)
                it.name.contains("Backstage",true) -> handleBackStage(it)
                it.name.contains("Sulfuras",true) -> {} //does nothing
                else -> handleGeneric(it)
            }
        }
    }

    private fun handleGeneric(item:Item) {
        item.sellIn -= 1
        if (item.sellIn < 0) item.quality -= 2 else item.quality -= 1 //once sellin drop below 0, quality decrease 2x
        if (item.quality < 0) item.quality = 0 // quality cannot drop below 0
        assert(item)
    }

    private fun handleAgedBrie(item: Item) {
        if (item.sellIn > 0) item.quality += 1 else item.quality += 2
        item.sellIn -= 1
        assert(item)
    }

    private fun handleConjured(item: Item) {
        item.quality -= 2
        item.sellIn -= 1
        assert(item)
    }

    private fun handleBackStage(item:Item){
        when {
            item.sellIn <= 0 -> item.quality = 0
            item.sellIn in 1..5 -> item.quality += 3
            item.sellIn in 6..10 -> item.quality += 2
            else -> item.quality += 1
        }
        item.sellIn -= 1
        assert(item)
    }

    private fun assert (item: Item) {
        if (item.quality < 0) {
            item.quality = 0
        }
        if (item.quality > 50) {
            item.quality = 50
        }
    }

}
