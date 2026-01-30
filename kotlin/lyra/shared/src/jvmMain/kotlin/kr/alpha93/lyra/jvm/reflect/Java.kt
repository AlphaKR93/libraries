package kr.alpha93.lyra.jvm.reflect

import kr.alpha93.lyra.tryExcept
import java.lang.reflect.Field


/**
 * (Forcibly) Sets the accessibility of the field to mutable public.
 *
 * @return The [Field] object itself which is accessible.
 */
public val Field.public: Field
    get() = this.also { it.isAccessible = true }

/**
 * Checks if the field exists.
 *
 * @param name The name of the field.
 * @return Whether the field exists.
 */
public operator fun Class<*>.contains(name: String): Boolean =
    tryExcept(NoSuchFieldException::class) { this.getDeclaredField(name) } != null

/**
 * Gets the field.
 *
 * @param name The name of the field.
 * @return The field object.
 * @throws NoSuchFieldException The field does not exist.
 */
public operator fun Class<*>.get(name: String): Field = this.getDeclaredField(name)
