package com.jera.apptemplate.data.util.mapper

abstract class Mapper<I, O> {
    fun transformList(items: List<I>?): List<O>? {
        return items?.map(::transform)
    }

    abstract fun transform(t: I): O
}