package com.gildedrose

class Inventory {
    companion object Repo {
        private var items:Array<Item> = arrayOf(
                createItem("+5 Dexterity Vest", 10, 20),
                createItem("Aged Brie", 2, 0),
                createItem("Elixir of the Mongoose", 5, 7),
                createItem("Sulfuras, Hand of Ragnaros", -1, 80),
                createItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                createItem("Conjured Mana Cake", 3, 50)
        )

        fun findAll () :Array<Item> {
            return items
        }
    }
}
