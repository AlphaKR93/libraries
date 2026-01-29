package kr.alpha93.lyra.primitives

/**
 * Binary representation of a number.
 */
public val Boolean.binary: Int
    get() = if (this) 1 else 0

public fun Boolean.toInt(): Int =
    this.binary

/**
 * Returns `true` if the content of this string is equal to the word "true",
 * `false` if it is equal to "false", and throws an exception otherwise.
 *
 * This is almost similar to [toBooleanStrict], but the difference is that
 * it is case-insensitive.
 *
 * @receiver The string to convert.
 * @return The boolean value of the string.
 * @throws IllegalArgumentException If the string doesn't represent a boolean value.
 * @see toBooleanStrict
 */
public fun String.toBooleanExact(): Boolean = when {
    equals("true", ignoreCase = true) -> true
    equals("false", ignoreCase = true) -> false
    else -> throw IllegalArgumentException("The string doesn't represent a boolean value: $this")
}
