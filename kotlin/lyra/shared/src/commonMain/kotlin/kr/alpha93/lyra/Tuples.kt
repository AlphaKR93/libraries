package kr.alpha93.lyra


/**
 * Creates a tuple of type [Triple] from [first][Pair.first], [second][Pair.second], and [third].
 */
public infix fun <A, B, C> Pair<A, B>.to(third: C): Triple<A, B, C> =
    Triple(this.first, this.second, third)
