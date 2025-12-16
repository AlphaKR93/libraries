package kr.alpha93.dokdo.primitives

/**
 * Returns a hash code value for the object.
 * The general contract of [hashCode]  is:
 *
 * * Whenever it is invoked on the same object more than once,
 * the [hashCode] method must consistently return the same integer,
 * provided no information used in `equals` comparisons on the object is modified.
 * * If two objects are equal according to the `equals()` method,
 * then calling the [hashCode]  method on each of the two objects must produce
 * the same integer result.
 *
 * @see hashCodeExact
 * @see Any.hashCode
 */
val Any?.hashCode: Int
    get() = this?.hashCode() ?: 0

/**
 * Returns the same hash code for the given object as would be returned by the
 * default [hashCode], whether the given object's class overrides the method.
 *
 * @see hashCode
 */
val Any?.hashCodeExact: Int
    get() = System.identityHashCode(this)

/**
 * Returns [Unit].
 *
 * @return [Unit]
 */
fun Any?.join() = Unit

/**
 * Attempts to cast the object to the specified type.
 *
 * @return The cast object.
 * @throws ClassCastException If the object cannot be cast to the specified type.
 */
@Suppress("UNCHECKED_CAST")
fun <T> Any.cast(): T = this as T

/**
 * Attempts to cast the object safely to the specified type.
 *
 * @return The cast object. `null` if the object cannot be cast to the specified type.
 */
@Suppress("UNCHECKED_CAST")
fun <T> Any?.safeCast(): T? = this as? T
