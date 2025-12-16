package kr.alpha93.dokdo.reflect

import kotlin.reflect.KAnnotatedElement
import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible

val <T> KCallable<T>.public: KCallable<T>
    get() = this.also { it.isAccessible = true }

operator fun <T> KCallable<T>.invoke(vararg args: Any?): T =
    call(*args)

inline operator fun <reified T : Annotation> KAnnotatedElement.contains(annotation: KClass<T>): Boolean =
    hasAnnotation<T>()

fun <T : Any> KClass<T>.getOrCreateInstance(): T =
    this.objectInstance ?: primaryConstructor?.public() ?: error("Unable to retrieve the instance of $simpleName")
