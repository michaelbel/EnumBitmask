package org.michaelbel.enumbitmask

class BitMask(
    val value: Int
)

inline fun <reified T> BitMask.mapEnabled(): List<T> where T: Enum<T>, T: Flags {
    return enumValues<T>().filter { value: T ->
        this hasFlag value
    }
}

inline fun <reified T> BitMask.mapNotEnabled(): List<T> where T: Enum<T>, T: Flags {
    return enumValues<T>().filterNot { value: T ->
        this hasFlag value
    }
}

infix fun BitMask.or(other: Flags): BitMask {
    return BitMask(value or other.bit)
}

infix operator fun BitMask.plus(other: BitMask): BitMask {
    return BitMask(value or other.value)
}

infix operator fun BitMask.plus(other: Flags): BitMask {
    return BitMask(value or other.bit)
}

infix fun <T: Flags> BitMask.hasFlag(which: T): Boolean {
    if (value == 0 || (value > 0 && which.bit == 0)) {
        return false
    }
    return value and which.bit == which.bit
}

infix fun <T: Flags> BitMask.unset(which: T): BitMask {
    return BitMask(value xor which.bit)
}