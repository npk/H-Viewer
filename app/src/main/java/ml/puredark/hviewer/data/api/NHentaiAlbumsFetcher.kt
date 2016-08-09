package ml.puredark.hviewer.data.api

import ml.puredark.hviewer.data.beans.Album

class NHentaiAlbumsFetcher(callback: (result: List<Album>?) -> Unit) : BaseFetcher<List<Album>>(callback) {
    fun fetch(page: Number) = fetch("https://nhentai.net/?page=$page")
}