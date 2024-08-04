package org.michaelbel.enumbitmask

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.michaelbel.enumbitmask.sample.domain.BadgeEnum
import org.michaelbel.enumbitmask.sample.domain.isNew
import org.michaelbel.enumbitmask.sample.domain.isOld

/**
 * [BitMask] Unit tests.
 */
class BitMaskUnitTest {

    @Test
    fun testMapList() {
        val mask: BitMask = BadgeEnum.BADGE_CROWN + BadgeEnum.BADGE_HEART + BadgeEnum.BADGE_RICH
        val maskEnabledList: List<BadgeEnum> = mask.mapEnabled()
        val maskNotEnabledList: List<BadgeEnum> = mask.mapNotEnabled()

        assertEquals(mask.value, 112)
        assertEquals(maskEnabledList, listOf(BadgeEnum.BADGE_CROWN, BadgeEnum.BADGE_HEART, BadgeEnum.BADGE_RICH))
        assertEquals(
            maskNotEnabledList,
            listOf(
                BadgeEnum.BADGE_EMPTY,
                BadgeEnum.BADGE_VERIFIED,
                BadgeEnum.BADGE_OLD,
                BadgeEnum.BADGE_NEW,
                BadgeEnum.BADGE_STAR
            )
        )
    }

    @Test
    fun testMapValues() {
        val mask: Int = BadgeEnum.BADGE_CROWN.bit + BadgeEnum.BADGE_HEART.bit + BadgeEnum.BADGE_RICH.bit
        val maskEnabledList: List<BadgeEnum> = mask.mapEnabled()
        val maskNotEnabledList: List<BadgeEnum> = mask.mapNotEnabled()

        assertEquals(mask, 112)
        assertEquals(maskEnabledList, listOf(BadgeEnum.BADGE_CROWN, BadgeEnum.BADGE_HEART, BadgeEnum.BADGE_RICH))
        assertEquals(
            maskNotEnabledList,
            listOf(
                BadgeEnum.BADGE_EMPTY,
                BadgeEnum.BADGE_VERIFIED,
                BadgeEnum.BADGE_OLD,
                BadgeEnum.BADGE_NEW,
                BadgeEnum.BADGE_STAR
            )
        )
    }

    @Test
    fun testHasFlag() {
        val mask: BitMask = BadgeEnum.BADGE_CROWN + BadgeEnum.BADGE_HEART + BadgeEnum.BADGE_RICH

        assertTrue(mask hasFlag BadgeEnum.BADGE_CROWN)
        assertTrue(mask hasFlag BadgeEnum.BADGE_HEART)
        assertTrue(mask hasFlag BadgeEnum.BADGE_RICH)

        assertFalse(mask hasFlag BadgeEnum.BADGE_EMPTY)
        assertFalse(mask hasFlag BadgeEnum.BADGE_VERIFIED)
        assertFalse(mask hasFlag BadgeEnum.BADGE_OLD)
        assertFalse(mask hasFlag BadgeEnum.BADGE_NEW)
        assertFalse(mask hasFlag BadgeEnum.BADGE_STAR)
    }

    @Test
    fun testHasFlagBit() {
        val mask: Int = BadgeEnum.BADGE_CROWN.bit + BadgeEnum.BADGE_HEART.bit + BadgeEnum.BADGE_RICH.bit

        assertTrue(mask hasFlag BadgeEnum.BADGE_CROWN)
        assertTrue(mask hasFlag BadgeEnum.BADGE_HEART)
        assertTrue(mask hasFlag BadgeEnum.BADGE_RICH)

        assertFalse(mask hasFlag BadgeEnum.BADGE_EMPTY)
        assertFalse(mask hasFlag BadgeEnum.BADGE_VERIFIED)
        assertFalse(mask hasFlag BadgeEnum.BADGE_OLD)
        assertFalse(mask hasFlag BadgeEnum.BADGE_NEW)
        assertFalse(mask hasFlag BadgeEnum.BADGE_STAR)
    }

    @Test
    fun testUnset() {
        val mask: BitMask = BadgeEnum.BADGE_STAR + BadgeEnum.BADGE_CROWN + BadgeEnum.BADGE_HEART
        assertEquals(mask.unset(BadgeEnum.BADGE_HEART).value, (BadgeEnum.BADGE_STAR + BadgeEnum.BADGE_CROWN).value)
    }

    @Test
    fun testOr() {
        val mask: BitMask = BadgeEnum.BADGE_STAR or BadgeEnum.BADGE_CROWN or BadgeEnum.BADGE_HEART
        assertEquals(mask.value, 56)
    }

    @Test
    fun testAnd() {
        val mask: BitMask = BadgeEnum.BADGE_HEART and 32
        assertEquals(mask.value, 32)
    }

    @Test
    fun testBitToValue() {
        val bit: Int = BadgeEnum.BADGE_RICH.bit
        assertEquals(BadgeEnum.find(bit), BadgeEnum.BADGE_RICH)
    }

    @Test
    fun testInlineProperties() {
        val oldBit: Int = BadgeEnum.BADGE_OLD.bit
        val newBit: Int = BadgeEnum.BADGE_NEW.bit
        assertTrue(oldBit.isOld)
        assertTrue(newBit.isNew)
    }
}