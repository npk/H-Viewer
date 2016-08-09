package ml.puredark.hviewer.data.parser

import org.jsoup.Jsoup

abstract class BaseParser<T> {
    var body: String? = null
    val document by lazy { Jsoup.parse(body) }
    abstract fun parse(): T
}