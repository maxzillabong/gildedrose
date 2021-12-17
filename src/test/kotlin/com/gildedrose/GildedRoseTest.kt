package com.gildedrose
import org.approvaltests.combinations.CombinationApprovals
import org.junit.Test

class GildedRoseTest {
    @Test fun updateQuality () {
        CombinationApprovals.verifyAllCombinations(fun (name:String, sellin:Int, quality:Int): String {
            val items = arrayOf(Inventory.createItem(name,sellin, quality))
            GildedRose(items).updateQuality()
            val (item) = items
            return item.toString()
        }, arrayOf(
            "foo",
            "Aged Brie",
            "Backstage passes to a TAFKAL80ETC concert",
            "Sulfuras, Hand of Ragnaros",
            "Conjured Mana Cake",
        ), arrayOf(-1, 0, 2, 6, 11), arrayOf(0, 1, 49, 50))
    }
}


