package com.gildedrose

class Inventory {
    companion object {
        private val items:Array<Item> = arrayOf(
                Item("+5 Dexterity Vest", 10, 20),
                Item(AGED_BRIE, 2, 0),
                Item("Elixir of the Mongoose", 5, 7),
                Item(SULFURAS, 0, 80),
                Item(SULFURAS, -1, 80),
                Item(BACKSTAGE, 15, 20),
                Item(BACKSTAGE, 10, 49),
                Item(BACKSTAGE, 5, 49),
                Item(CONJURED, 3, 6)
        )

        fun findAll () :Array<Item> {
            return items
        }
    }
}
