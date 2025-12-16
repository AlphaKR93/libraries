package kr.alpha93.dokdo.math

import kotlin.math.PI
import kotlin.math.max
import kotlin.math.min

/**
 * Ratio of the circumference of a circle to its radius, approximately 6.283185307179586.
 *
 * @see PI
 */
const val TAU: Double = 2.0 * PI

/**
 * Returns a signed string representation of a number.
 *
 * @receiver The number to convert.
 * @return A signed string representation of the number.
 */
fun Int.toStringSigned(): String =
    if (this > 0) "+$this" else this.toString()

/**
 * Returns a signed string representation of a number.
 *
 * @receiver The number to convert.
 * @return A signed string representation of the number.
 */
fun Long.toStringSigned(): String =
    if (this > 0L) "+$this" else this.toString()

/**
 * Returns a signed string representation of a number.
 *
 * @receiver The number to convert.
 * @return A signed string representation of the number.
 */
fun Float.toStringSigned(): String =
    if (this > 0F) "+$this" else this.toString()

/**
 * Returns a signed string representation of a number.
 *
 * @receiver The number to convert.
 * @return A signed string representation of the number.
 */
fun Double.toStringSigned(): String =
    if (this > 0.0) "+$this" else this.toString()

/**
 * Clamps the value to fit between min and max. If the value is less than `min`,
 * then `min` is returned. If the value is greater than `max`, then `max` is
 * returned. Otherwise, the original value is returned.
 *
 * @param value Value to clamp
 * @param min Minimal allowed value
 * @param max Maximal allowed value
 * @return A clamped value that fits into `min..max` interval
 * @throws IllegalArgumentException If `min > max`
 * @see Math.clamp
 */
fun clamp(value: Int, min: Int, max: Int): Int =
    min(max, max(min, value))

/**
 * Clamps the value to fit between min and max. If the value is less than `min`,
 * then `min` is returned. If the value is greater than `max`, then `max` is
 * returned. Otherwise, the original value is returned.
 *
 * @param value Value to clamp
 * @param min Minimal allowed value
 * @param max Maximal allowed value
 * @return A clamped value that fits into `min..max` interval
 * @throws IllegalArgumentException If `min > max`
 * @see Math.clamp
 */
fun clamp(value: Long, min: Long, max: Long): Long =
    min(max, max(min, value))

/**
 * Clamps the value to fit between min and max. If the value is less than `min`,
 * then `min` is returned. If the value is greater than `max`, then `max` is
 * returned. Otherwise, the original value is returned.
 *
 * @param value Value to clamp
 * @param min Minimal allowed value
 * @param max Maximal allowed value
 * @return A clamped value that fits into `min..max` interval
 * @throws IllegalArgumentException If `min > max`
 * @see Math.clamp
 */
fun clamp(value: Float, min: Float, max: Float): Float =
    min(max, max(min, value))

/**
 * Clamps the value to fit between min and max. If the value is less than `min`,
 * then `min` is returned. If the value is greater than `max`, then `max` is
 * returned. Otherwise, the original value is returned.
 *
 * @param value Value to clamp
 * @param min Minimal allowed value
 * @param max Maximal allowed value
 * @return A clamped value that fits into `min..max` interval
 * @throws IllegalArgumentException If `min > max`
 * @see Math.clamp
 */
fun clamp(value: Double, min: Double, max: Double): Double =
    min(max, max(min, value))
