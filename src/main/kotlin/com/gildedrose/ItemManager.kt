package com.gildedrose

import kotlin.reflect.full.primaryConstructor

val MANAGER_MAP = mapOf(
    AGED_BRIE to AgedBrieManager::class.qualifiedName,
    CONJURED to ConjuredManager::class.qualifiedName,
    BACKSTAGE to BackstagePassManager::class.qualifiedName,
    SULFURAS to SulfurasManager::class.qualifiedName,
)

open class ItemManager (open var item: Item) {
    open fun updateQuality() {
        item.sellIn -= 1
        item.quality -= if (item.sellIn < 0) 2 else 1 //once sellin drop below 0, quality decrease 2x
        correct()
    }
    fun correct () {
        if (item.quality < 0) {
            item.quality = 0
        }
        if (item.quality > 50) {
            item.quality = 50
        }
    }
}

class AgedBrieManager (override var item: Item): ItemManager(item) {
    override fun updateQuality() {
        item.quality += if (item.sellIn > 0) 1 else 2
        item.sellIn -= 1
        correct()
    }
}

class BackstagePassManager (override var item: Item): ItemManager(item) {
    override fun updateQuality() {
        when {
            item.sellIn <= 0 -> item.quality = 0
            item.sellIn in 1..5 -> item.quality += 3
            item.sellIn in 6..10 -> item.quality += 2
            else -> item.quality += 1
        }
        item.sellIn -= 1
        correct()
    }
}

class SulfurasManager (override var item: Item): ItemManager(item) {
    override fun updateQuality() {
    }
}

class ConjuredManager (override var item: Item): ItemManager(item) {
    override fun updateQuality() {
        item.quality -= if (item.sellIn > 0) 2 else 4
        item.sellIn -= 1
        correct()
    }
}

fun getManager(item: Item): ItemManager {
    val qn = MANAGER_MAP[item.name]
    return if (qn != null) Class.forName(qn).kotlin
        .primaryConstructor?.call(item) as ItemManager
    else ItemManager(item)
}

