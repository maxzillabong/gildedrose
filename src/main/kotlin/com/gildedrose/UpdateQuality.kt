package com.gildedrose

private val updateQualityItem = { item: Item ->
    item.sellIn -= 1
    item.quality -= if (item.sellIn < 0) 2 else 1 //once sellin drop below 0, quality decrease 2x
    correct(item)
}

private val updateQualityAgedBrie = { item:Item ->
    item.quality += if (item.sellIn > 0) 1 else 2
    item.sellIn -= 1
    correct(item)
}

private val updateQualityBackstagePass = { item:Item ->
    when {
        item.sellIn <= 0 -> item.quality = 0
        item.sellIn in 1..5 -> item.quality += 3
        item.sellIn in 6..10 -> item.quality += 2
        else -> item.quality += 1
    }
    item.sellIn -= 1
    correct(item)
}

private val updateQualityConjured = {item:Item ->
    item.quality -= if (item.sellIn > 0) 2 else 4
    item.sellIn -= 1
    correct(item)
}

private fun correct (item: Item) {
    if (item.quality < 0) {
        item.quality = 0
    }
    if (item.quality > 50) {
        item.quality = 50
    }
}

private val UPDATER_MAP = mapOf(
    AGED_BRIE to updateQualityAgedBrie,
    CONJURED to updateQualityConjured,
    BACKSTAGE to updateQualityBackstagePass,
    SULFURAS to { } // does nothing
)

fun doUpdateQuality(item: Item) {
    val handler = UPDATER_MAP[item.name]
    if ( handler!= null ) {
        handler(item)
    } else {
        //defaults to item updater
        updateQualityItem(item)
    }
}

