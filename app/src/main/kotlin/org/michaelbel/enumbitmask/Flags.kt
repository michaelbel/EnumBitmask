@file:Suppress("unused")

package org.michaelbel.enumbitmask

interface Flags  {
    val bit: Int
    fun toBitMask(): BitMask = BitMask(bit)
}

infix fun Flags.and(other: Int): BitMask {
    return BitMask(bit and other)
}

infix fun <T: Flags> Flags.or(other: T): BitMask {
    return BitMask(bit or other.bit)
}

infix operator fun Flags.plus(other: Flags): BitMask {
    return BitMask(bit or other.bit)
}