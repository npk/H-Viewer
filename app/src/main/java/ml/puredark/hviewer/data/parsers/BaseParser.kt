package ml.puredark.hviewer.data.parsers

import org.jsoup.Jsoup

abstract class BaseParser<TCollection> {
    var body: String? = null
    val document by lazy { Jsoup.parse(body) }

    abstract fun parse(): TCollection
}