package com.gildedrose

import org.junit.Test
import org.junit.Assert.assertEquals

class InventoryTest {
    @Test fun `Inventory should contain amount`(){
        assertEquals(6, Inventory.findAll().size)
    }
}
