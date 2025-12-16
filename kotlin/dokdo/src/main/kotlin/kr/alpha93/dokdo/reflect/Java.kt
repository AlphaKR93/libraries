package kr.alpha93.dokdo.reflect

import java.lang.reflect.Field

val Field.public: Field
    get() = this.also { it.isAccessible = true }

operator fun Class<*>.contains(name: String): Boolean = try {
    this.getDeclaredField(name)
    true
} catch (_: NoSuchFieldException) {
    false
}

operator fun Class<*>.get(name: String): Field =
    this.getDeclaredField(name)
