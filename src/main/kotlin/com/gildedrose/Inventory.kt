package com.gildedrose

import kotlin.reflect.full.primaryConstructor

const val AGED_BRIE = "Aged Brie"
const val CONJURED = "Conjured Mana Cake"
const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
const val SULFURAS = "Sulfuras, Hand of Ragnaros"

val KNOWN_ITEMS = mapOf(
    AGED_BRIE to AgedBrie::class.qualifiedName,
    CONJURED to Conjured::class.qualifiedName,
    BACKSTAGE to BackStage::class.qualifiedName,
    SULFURAS to Sulfuras::class.qualifiedName,
)

class Inventory {
    companion object {
        private val items:Array<Item> = arrayOf(
                createItem("+5 Dexterity Vest", 10, 20),
                createItem(AGED_BRIE, 2, 0),
                createItem("Elixir of the Mongoose", 5, 7),
                createItem(SULFURAS, 0, 80),
                createItem(SULFURAS, -1, 80),
                createItem(BACKSTAGE, 15, 20),
                createItem(BACKSTAGE, 10, 49),
                createItem(BACKSTAGE, 5, 49),
                createItem(CONJURED, 3, 6)
        )

        fun createItem (name:String, sellIn: Int, quality: Int): Item {
            val qn = KNOWN_ITEMS[name]
            return if (qn != null) Class.forName(qn).kotlin
                .primaryConstructor?.call(sellIn, quality) as Item
            else Item (name, sellIn, quality)
        }

        fun findAll () :Array<Item> {
            return items
        }
    }
}
