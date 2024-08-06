@file:Suppress("unused")

package org.michaelbel.enumbitmask

inline fun <reified T> Int.mapEnabled(): List<T> where T: Enum<T>, T: Flags {
    return enumValues<T>().filter { value: T ->
        this hasFlag value
    }
}

inline fun <reified T> Int.mapNotEnabled(): List<T> where T: Enum<T>, T: Flags {
    return enumValues<T>().filterNot { value: T ->
        this hasFlag value
    }
}

infix fun <T: Flags> Int.hasFlag(which: T): Boolean {
    if (this == 0 || (this > 0 && which.bit == 0)) {
        return false
    }
    return this and which.bit == which.bit
}