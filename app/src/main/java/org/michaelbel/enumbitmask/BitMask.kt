package org.michaelbel.enumbitmask

class BitMask(
    val value: Long
)

inline fun <reified T> BitMask.mapEnabled(): List<T> where T: Enum<T>, T: Flags {
    return enumValues<T>().filter {
        this hasFlag it
    }
}

inline fun <reified T> BitMask.mapNotEnabled(): List<T> where T: Enum<T>, T: Flags {
    return enumValues<T>().filterNot {
        this hasFlag it
    }
}

infix fun BitMask.or(other: Flags): BitMask = BitMask(value or other.bit)

infix operator fun BitMask.plus(other: BitMask): BitMask = BitMask(value or other.value)

infix operator fun BitMask.plus(other: Flags): BitMask = BitMask(value or other.bit)

infix fun <T: Flags> BitMask.hasFlag(which: T): Boolean {
    if (value == 0L || (value > 0L && which.bit == 0L)) {
        return false
    }
    return value and which.bit == which.bit
}

infix fun <T: Flags> BitMask.unset(which: T): BitMask = BitMask(value xor which.bit)