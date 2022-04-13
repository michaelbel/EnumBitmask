package org.michaelbel.enumbitmask

interface Flags  {
    val bit: Long
    fun toBitMask(): BitMask = BitMask(bit)
}

infix fun Flags.and(other: Long): BitMask = BitMask(bit and other)

infix fun <T: Flags> Flags.or(other: T): BitMask = BitMask(bit or other.bit)

infix operator fun Flags.plus(other: Flags): BitMask = BitMask(bit or other.bit)