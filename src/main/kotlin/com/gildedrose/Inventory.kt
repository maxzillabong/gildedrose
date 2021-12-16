package com.gildedrose

class Inventory {
    companion object Repo {
        private var items:Array<Item> = arrayOf(
                Item("+5 Dexterity Vest", 10, 20),
                Item("Aged Brie", 2, 0),
                Item("Elixir of the Mongoose", 5, 7),
                Item("Sulfuras, Hand of Ragnaros", -1, 80),
                Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                Item("Conjured Mana Cake", 3, 50)
        )

        fun findAll () :Array<Item> {
            return items
        }
    }
}
