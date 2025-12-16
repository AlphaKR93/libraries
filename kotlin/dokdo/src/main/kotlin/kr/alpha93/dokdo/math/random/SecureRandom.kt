package kr.alpha93.dokdo.math.random

import kr.alpha93.dokdo.tryExcept
import kotlin.experimental.and
import kotlin.random.Random
import java.security.NoSuchAlgorithmException as NoAlgException
import java.security.SecureRandom as CSPRNG

/**
 * A simple implementation of [java.security.SecureRandom].
 *
 * @constructor Creates a new secure random number generator.
 * @see java.security.SecureRandom
 */
open class SecureRandom(private val actual: CSPRNG, seed: Long = 0L) : Random(), ExtendedRandom {

    companion object {

        private const val FULL_BYTE: Byte = 0xFF.toByte()

        /**
         * [kr.alpha93.dokdo.math.random.SecureRandom] object that was selected
         * by using the algorithms/providers specified in the
         * `securerandom.strongAlgorithms` [java.security.Security] property.
         */
        @JvmStatic
        val STRONG: SecureRandom = SecureRandom(tryExcept(NoAlgException::class) { CSPRNG.getInstanceStrong() } ?: CSPRNG())

    }

    init {
        actual.setSeed(seed)
    }

    constructor(seed: Long = 0L) : this(tryExcept(NoAlgException::class) { CSPRNG.getInstanceStrong() } ?: CSPRNG(), seed)

    constructor(algorithm: String, seed: Long = 0L) : this(CSPRNG.getInstance(algorithm), seed)

    final override fun nextBits(bitCount: Int): Int {
        if (bitCount == 0) return 0

        val byteCount = (bitCount + 7) / 8
        val byteArray = nextBytes(byteCount)

        var next = 0
        for (i in 0 until byteCount) next = (next shl 8) + (byteArray[i] and FULL_BYTE)

        return next ushr ((byteCount * 8) - bitCount)
    }

    override fun nextInt(): Int = actual.nextInt()

    override fun nextInt(until: Int): Int = actual.nextInt(until)

    override fun nextInt(from: Int, until: Int): Int = actual.nextInt(from, until)

    override fun nextLong(): Long = actual.nextLong()

    override fun nextLong(until: Long): Long = actual.nextLong(until)

    override fun nextLong(from: Long, until: Long): Long = actual.nextLong(from, until)

    override fun nextBoolean(): Boolean = actual.nextBoolean()

    override fun nextDouble(): Double = actual.nextDouble()

    override fun nextDouble(until: Double): Double = actual.nextDouble(until)

    override fun nextDouble(from: Double, until: Double): Double = actual.nextDouble(from, until)

    override fun nextFloat(): Float = actual.nextFloat()

    override fun nextFloat(until: Float): Float = actual.nextFloat(until)

    override fun nextFloat(from: Float, until: Float): Float = actual.nextFloat(from, until)

    override fun nextGaussian(): Double = actual.nextGaussian()

    override fun nextGaussian(mean: Double, stddev: Double) = actual.nextGaussian(mean, stddev)

    override fun nextExponential(): Double = actual.nextExponential()

    override fun nextBytes(array: ByteArray, fromIndex: Int, toIndex: Int): ByteArray =
        nextBytes(array).copyOfRange(fromIndex, toIndex)

    override fun nextBytes(array: ByteArray): ByteArray = array.apply { actual.nextBytes(this) }

    override fun nextBytes(size: Int): ByteArray = nextBytes(ByteArray(size))

    override fun equals(other: Any?): Boolean = other is SecureRandom && (this === other || actual == other.actual)

    override fun hashCode(): Int = actual.hashCode()

    override fun toString(): String = actual.toString()

}
