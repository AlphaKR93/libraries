package kr.alpha93.dokdo.math.random

interface ExtendedRandom {

    fun nextFloat(until: Float): Float = this.nextFloat(0F, until)

    fun nextFloat(from: Float, until: Float): Float

    fun nextGaussian(): Double

    fun nextGaussian(mean: Double, stddev: Double): Double

    fun nextExponential(): Double

}
