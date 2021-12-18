package com.gildedrose

class GildedRose(
    private val items: Array<Item>
) {
    fun updateQuality() {
        items.forEach {
            doUpdateQuality(it)
        }
    }
}
