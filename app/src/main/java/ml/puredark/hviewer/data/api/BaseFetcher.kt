package ml.puredark.hviewer.data.api

import ml.puredark.hviewer.data.parsers.BaseParser
import okhttp3.*
import java.io.IOException

open class BaseFetcher<TCollection>(callback: (result: TCollection?) -> Unit) {

    val client by lazy { OkHttpClient() }
    val callback by lazy { callback }
    val parser: BaseParser<TCollection>? = null

    protected fun fetch(url: String) {
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) throw IOException("Unexpected code " + response)

                parser?.body = response.body().string()
                callback(parser?.parse())
            }
            override fun onFailure(call: Call, e: IOException) = throw e
        })
    }
}