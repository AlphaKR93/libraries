package kr.alpha93.dokdo.collections.inaccessible

object EmptyIterator : Iterator<Nothing> {
    override fun next() = throw NoSuchElementException()
    override fun hasNext() = false
}

object EmptyMutableIterator : MutableIterator<Nothing> {
    override fun next() = throw NoSuchElementException()
    override fun hasNext() = false
    override fun remove() = throw NoSuchElementException()
}
