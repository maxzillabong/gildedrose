package com.gildedrose

class Inventory {
    companion object Repo {
        private var items:Array<Item> = arrayOf(
                createItem("+5 Dexterity Vest", 10, 20),
                createItem(AGED_BRIE, 2, 0),
                createItem("Elixir of the Mongoose", 5, 7),
                createItem(SULFURAS, -1, 80),
                createItem(BACKSTAGE, 15, 20),
                createItem(CONJURED, 3, 50)
        )

        fun findAll () :Array<Item> {
            return items
        }
    }
}
