package kr.alpha93.lyra.jvm.reflect

import kr.alpha93.lyra.internal.InlineOnly
import kr.alpha93.lyra.primitives.cast
import kotlin.reflect.KAnnotatedElement
import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KMutableProperty2
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1
import kotlin.reflect.KProperty2
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible


/**
 * (Forcibly) Sets the accessibility of the callable object to mutable public.
 *
 * @return The [KCallable] object itself which is accessible.
 */
public val <T> KCallable<T>.public: KCallable<T>
    inline get() = this.also { it.isAccessible = true }

/**
 * (Forcibly) Sets the accessibility of the object to mutable public.
 *
 * @return The [KMutableProperty] object itself which is accessible.
 */
@InlineOnly
@Suppress("NOTHING_TO_INLINE")
public inline fun <V> KProperty<V>.asMutableProperty(): KMutableProperty<V> = this.public.cast()

/**
 * (Forcibly) Sets the accessibility of the object to mutable public.
 *
 * @return The [KMutableProperty0] object itself which is accessible.
 */
@InlineOnly
@Suppress("NOTHING_TO_INLINE")
public inline fun <V> KProperty0<V>.asMutableProperty(): KMutableProperty0<V> = this.public.cast()

/**
 * (Forcibly) Sets the accessibility of the object to mutable public.
 *
 * @return The [KMutableProperty1] object itself which is accessible.
 */
@InlineOnly
@Suppress("NOTHING_TO_INLINE")
public inline fun <K, V> KProperty1<K, V>.asMutableProperty(): KMutableProperty1<K, V> = this.public.cast()

/**
 * (Forcibly) Sets the accessibility of the object to mutable public.
 *
 * @return The [KMutableProperty2] object itself which is accessible.
 */
@InlineOnly
@Suppress("NOTHING_TO_INLINE")
public inline fun <D, E, V> KProperty2<D, E, V>.asMutableProperty(): KMutableProperty2<D, E, V> = this.public.cast()

/**
 * Gets or creates the instance of the object class.
 */
public fun <T : Any> KClass<T>.getOrCreateInstance(): T =
    this.objectInstance ?: primaryConstructor?.public() ?: error("Unable to retrieve the instance of $simpleName")

/**
 * Calls this callable with the specified list of arguments and returns the result.
 *
 * @see KCallable.call
 */
@InlineOnly
@Suppress("NOTHING_TO_INLINE")
public inline operator fun <T> KCallable<T>.invoke(vararg args: Any?): T =
    call(*args)

/**
 * @return true if this element is annotated with an annotation of type [T].
 */
public inline operator fun <reified T : Annotation> KAnnotatedElement.contains(annotation: KClass<T>): Boolean =
    hasAnnotation<T>()

/**
 * Gets the member property with the specified name.
 *
 * @return The member [KFunction].
 */
public operator fun Collection<KFunction<*>>.get(name: String): KFunction<*> =
    this.first { it.name == name }

/**
 * Gets the member property with the specified name.
 *
 * @return The member [KFunction].
 */
public operator fun <T> Collection<KFunction<*>>.get(name: String): KFunction<T> =
    this[name].cast()

/**
 * Gets the member property with the specified name.
 *
 * @return The member [KProperty].
 */
public operator fun Collection<KProperty<*>>.get(name: String): KProperty<*> =
    this.first { it.name == name }

/**
 * Gets the member property with the specified name.
 *
 * @return The member [KProperty].
 */
public operator fun <T> Collection<KProperty<*>>.get(name: String): KProperty<T> =
    this[name].cast()

/**
 * Gets the member property with the specified name.
 *
 * @return The member [KProperty0].
 */
public operator fun Collection<KProperty0<*>>.get(name: String): KProperty0<*> =
    this.first { it.name == name }

/**
 * Gets the member property with the specified name.
 *
 * @return The member [KProperty0].
 */
public operator fun <T> Collection<KProperty0<*>>.get(name: String): KProperty0<T> =
    this[name].cast()

/**
 * Gets the member property with the specified name.
 *
 * @return The member [KProperty1].
 */
public operator fun Collection<KProperty1<*, *>>.get(name: String): KProperty1<*, *> =
    this.first { it.name == name }

/**
 * Gets the member property with the specified name.
 *
 * @return The member [KProperty1].
 */
public operator fun <K, V> Collection<KProperty1<*, *>>.get(name: String): KProperty1<K, V> =
    this[name].cast()

/**
 * Gets the member property with the specified name.
 *
 * @return The member [KProperty2].
 */
public operator fun Collection<KProperty2<*, *, *>>.get(name: String): KProperty2<*, *, *> =
    this.first { it.name == name }

/**
 * Gets the member property with the specified name.
 *
 * @return The member [KProperty2].
 */
public operator fun <D, E, V> Collection<KProperty2<*, *, *>>.get(name: String): KProperty2<D, E, V> =
    this[name].cast()
