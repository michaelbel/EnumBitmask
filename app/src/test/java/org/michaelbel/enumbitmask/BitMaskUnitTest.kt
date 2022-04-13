package org.michaelbel.enumbitmask

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * [BitMask] Unit tests.
 */
class BitMaskUnitTest {

    @Test
    fun testMapList() {
        val mask: BitMask = ColorEnum.RED + ColorEnum.GREEN + ColorEnum.BLUE
        val maskEnabledList: List<ColorEnum> = mask.mapEnabled()
        val maskNotEnabledList: List<ColorEnum> = mask.mapNotEnabled()

        assertEquals(mask.value, 28)
        assertEquals(maskEnabledList, listOf(ColorEnum.RED, ColorEnum.GREEN, ColorEnum.BLUE))
        assertEquals(
            maskNotEnabledList,
            listOf(
                ColorEnum.TRANSPARENT,
                ColorEnum.WHITE,
                ColorEnum.BLACK,
                ColorEnum.YELLOW,
                ColorEnum.PINK,
                ColorEnum.ORANGE,
                ColorEnum.BROWN,
                ColorEnum.GRAY,
                ColorEnum.PURPLE
            )
        )
    }

    @Test
    fun testHasFlag() {
        val mask: BitMask = ColorEnum.RED + ColorEnum.GREEN + ColorEnum.BLUE

        assertTrue(mask hasFlag ColorEnum.RED)
        assertTrue(mask hasFlag ColorEnum.GREEN)
        assertTrue(mask hasFlag ColorEnum.BLUE)

        assertFalse(mask hasFlag ColorEnum.TRANSPARENT)
        assertFalse(mask hasFlag ColorEnum.WHITE)
        assertFalse(mask hasFlag ColorEnum.BLACK)
        assertFalse(mask hasFlag ColorEnum.YELLOW)
        assertFalse(mask hasFlag ColorEnum.PINK)
        assertFalse(mask hasFlag ColorEnum.ORANGE)
        assertFalse(mask hasFlag ColorEnum.BROWN)
        assertFalse(mask hasFlag ColorEnum.GRAY)
        assertFalse(mask hasFlag ColorEnum.PURPLE)
    }

    @Test
    fun testUnset() {
        val mask: BitMask = ColorEnum.RED + ColorEnum.GREEN + ColorEnum.BLUE
        assertEquals(mask.unset(ColorEnum.BLUE).value, (ColorEnum.RED + ColorEnum.GREEN).value)
    }

    @Test
    fun testOr() {
        val mask: BitMask = ColorEnum.RED or ColorEnum.GREEN or ColorEnum.BLUE
        assertEquals(mask.value, 28)
    }

    @Test
    fun testAnd() {
        val mask: BitMask = ColorEnum.PURPLE and 1024
        assertEquals(mask.value, 1024)
    }
}