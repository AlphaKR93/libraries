package kr.alpha93.dokdo

import kotlin.reflect.KClass

/**
 * Attempts to run [block], return [orElse] if [T] was thrown
 *
 * @param T The throwable which is ignored
 * @param R The type of return
 * @param throwable The throwable [KClass]. This is only for type-casting, defaults to `null`.
 * @param orElse The fallback value.
 * @param block Actual code to run.
 */
inline fun <reified T : Throwable, R> tryExcept(
    @Suppress("Unused") throwable: KClass<T>? = null,
    orElse: R? = null,
    block: () -> R
): R? {
    try {
        return block()
    } catch (t: Throwable) {
        if (t !is T) throw t
        return orElse
    }
}

/**
 * Attempts to run [block], return [orElse] if [T] was thrown
 *
 * @receiver The object to run
 * @param T The throwable which is ignored
 * @param R The type of return
 * @param V The type of receiver
 * @param throwable The throwable [KClass]. This is only for type-casting, defaults to `null`.
 * @param orElse The fallback value.
 * @param block Actual code to run.
 */
inline fun <reified T : Throwable, R, V> V.attempt(
    @Suppress("Unused") throwable: KClass<T>? = null,
    orElse: R? = null,
    block: V.() -> R
) = tryExcept<T, R>(orElse = orElse) { this.block() }
