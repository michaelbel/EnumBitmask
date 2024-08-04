@file:Suppress("unused")

package org.michaelbel.enumbitmask.sample.domain

import org.michaelbel.enumbitmask.Flags
import org.michaelbel.enumbitmask.hasFlag

enum class BadgeEnum(
    override val bit: Int
): Flags {
    BADGE_EMPTY(0),          // 0
    BADGE_VERIFIED(1 shl 0), // 1
    BADGE_OLD(1 shl 1),      // 2
    BADGE_NEW(1 shl 2),      // 4
    BADGE_STAR(1 shl 3),     // 8
    BADGE_CROWN(1 shl 4),    // 16
    BADGE_HEART(1 shl 5),    // 32
    BADGE_RICH(1 shl 6);     // 64

    companion object {
        fun find(bit: Int): BadgeEnum {
            return requireNotNull(entries.find { badgeEnum -> badgeEnum.bit == bit })
        }
    }
}

val Int.isVerified: Boolean
    get() = this hasFlag BadgeEnum.BADGE_VERIFIED

val Int.isOld: Boolean
    get() = this hasFlag BadgeEnum.BADGE_OLD

val Int.isNew: Boolean
    get() = this hasFlag BadgeEnum.BADGE_NEW

val Int.isStar: Boolean
    get() = this hasFlag BadgeEnum.BADGE_STAR

val Int.isCrown: Boolean
    get() = this hasFlag BadgeEnum.BADGE_CROWN

val Int.isHeart: Boolean
    get() = this hasFlag BadgeEnum.BADGE_HEART

val Int.isRich: Boolean
    get() = this hasFlag BadgeEnum.BADGE_RICH