package org.michaelbel.enumbitmask

enum class ColorEnum(
    override val bit: Int
): Flags {
    TRANSPARENT(0),   // 0
    WHITE(1 shl 0),   // 1
    BLACK(1 shl 1),   // 2
    RED(1 shl 2),     // 4
    GREEN(1 shl 3),   // 8
    BLUE(1 shl 4),    // 16
    YELLOW(1 shl 5),  // 32
    PINK(1 shl 6),    // 64
    ORANGE(1 shl 7),  // 128
    BROWN(1 shl 8),   // 256
    GRAY(1 shl 9),    // 512
    PURPLE(1 shl 10); // 1024

    companion object {
        fun find(bit: Int): ColorEnum {
            return requireNotNull(entries.find { colorEnum: ColorEnum -> colorEnum.bit == bit })
        }
    }
}

val Int.isWhite: Boolean
    get() = BitMask(this) hasFlag ColorEnum.WHITE

val Int.isBlack: Boolean
    get() = BitMask(this) hasFlag ColorEnum.BLACK