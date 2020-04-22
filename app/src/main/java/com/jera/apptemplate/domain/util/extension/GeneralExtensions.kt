package com.jera.apptemplate.domain.util.extension

import com.jera.apptemplate.domain.util.DateMasks
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun consume(f: () -> Unit): Boolean {
    f()
    return true
}

fun <T> List<T>.forEachBetween(start: Int, end: Int, callback: (value: T) -> Unit) {
    if (start >= end) return
    for (i in start + 1 until end) callback(get(i))
}

fun <E> List<E>.indexOrZero(e: E): Int {
    val index = indexOf(e)
    return if (index == -1) 0 else index
}

fun <E> List<E>.indexOrNull(e: E): Int? {
    val index = indexOf(e)
    return if (index == -1) null else index
}

fun <E> MutableList<E>.updateElements(operator: (E) -> E): MutableList<E> {
    val newList = mutableListOf<E>()
    forEachIndexed { index, originalElement ->
        val newElement = operator(originalElement)
        newList.add(index, newElement)
    }
    return newList
}

fun <E> MutableList<E>.replaceOrAdd(element: E, index: Int?) {
    if (index == null || index == -1) {
        add(element)
    } else {
        removeAt(index)
        add(index, element)
    }
}

fun <E> MutableList<E>.addIfNotNull(element: E?) {
    element?.let { add(element) }
}

fun <K, V> Map<K, V?>.toNotNullValues(): Map<K, V> {
    val mutableMap = mutableMapOf<K, V>()
    forEach {
        if (it.value != null)
            mutableMap[it.key] = it.value!!
    }
    return mutableMap
}

fun String.resolveTimeZone(
    pattern: String = com.jera.apptemplate.domain.util.DateMasks.DATE_MASK_BR
): Calendar {
    val formatter = getSimpleDateFormatter(pattern, TimeZone.getDefault())
    val dateConverted: Date = formatter.parse(this)
    val data = Calendar.getInstance()
    data.time = dateConverted
    return data
}

fun String.toDate(pattern: String = com.jera.apptemplate.domain.util.DateMasks.DATE_MASK_BR): Date {
    val formatter = getSimpleDateFormatter(pattern)
    return formatter.parse(this)
}

fun String.toCurrentTimezoneDate(
    pattern: String = com.jera.apptemplate.domain.util.DateMasks.DATE_MASK_BR
): Date {
    val formatter = getSimpleDateFormatter(pattern, TimeZone.getDefault())
    return formatter.parse(this)
}

fun Calendar.toText(): String {
    return this.time.format()
}

fun Date.format(pattern: String = com.jera.apptemplate.domain.util.DateMasks.DATE_MASK_BR): String {
    return getSimpleDateFormatter(pattern).format(this)
}

fun Date.formatCurrentTimezone(
    pattern: String = com.jera.apptemplate.domain.util.DateMasks.DATE_MASK_BR
): String {
    return getSimpleDateFormatter(pattern, TimeZone.getDefault()).format(this)
}

fun getHoursDiffInMinutes(oldDate: Date, newDate: Date): Float {
    val hourInMinutes = 60F
    return try {
        TimeUnit.MINUTES.convert(newDate.time - oldDate.time, TimeUnit.MILLISECONDS).toFloat() / hourInMinutes
    } catch (e: Exception) {
        0F
    }
}

fun getSimpleDateFormatter(
    pattern: String = com.jera.apptemplate.domain.util.DateMasks.DATE_MASK_BR,
    timeZone: TimeZone = TimeZone.getTimeZone("UTC")
): SimpleDateFormat {
    return SimpleDateFormat(pattern, Locale.getDefault()).also {
        it.timeZone = timeZone
    }
}

fun unless(predicate: Boolean?, handler: () -> Unit): Boolean? {
    if (predicate != true) {
        handler.invoke()
    }
    return predicate
}

fun Boolean?.toInt(): Int {
    return if (this == true) 1 else 0
}

fun Int?.toBoolean(): Boolean {
    return !(this == null || this == 0)
}

fun StringBuilder.appendLn(value: String) {
    this.append(value)
    this.append("\n")
}

fun StringBuilder.appendOnStart(value: String) {
    val current = toString()
    this.clear()
    append(value)
    append(" ")
    append(current)
}

fun _if(condition: Boolean?, handler: () -> Unit): Boolean? {
    if (condition == true) {
        handler.invoke()
        return true
    }
    return condition
}

infix fun Boolean?._else(handler: () -> Unit) {
    if (this != true) {
        handler.invoke()
    }
}

fun <T1, T2, R> safeLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}

fun <T1, T2, T3, R> safeLet(p1: T1?, p2: T2?, p3: T3?, block: (T1, T2, T3) -> R?): R? {
    return if (p1 != null && p2 != null && p3 != null) block(p1, p2, p3) else null
}