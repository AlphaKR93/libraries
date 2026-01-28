package kr.alpha93.lyra.math

import kotlin.math.max
import kotlin.math.min


public actual inline fun clamp(value: Int, min: Int, max: Int): Int = min(max, max(min, value))
public actual inline fun clamp(value: Long, min: Long, max: Long): Long = min(max, max(min, value))
public actual inline fun clamp(value: Float, min: Float, max: Float): Float = min(max, max(min, value))
public actual inline fun clamp(value: Double, min: Double, max: Double): Double = min(max, max(min, value))
