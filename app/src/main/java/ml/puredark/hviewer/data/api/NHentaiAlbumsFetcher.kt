package ml.puredark.hviewer.data.api

import ml.puredark.hviewer.data.beans.Album

class NHentaiAlbumsFetcher : BaseFetcher<List<Album>>() {
    fun fetch(page: Number, callback: (result: List<Album>?) -> Unit) {
        fetch("https://nhentai.net/?page=$page", callback)
    }
}