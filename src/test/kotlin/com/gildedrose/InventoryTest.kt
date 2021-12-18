package com.gildedrose

import org.junit.Test
import org.junit.Assert.assertEquals

class InventoryTest {
    @Test fun `Inventory should contain amount`(){
        assertEquals(9, Inventory.findAll().size)
    }
}
