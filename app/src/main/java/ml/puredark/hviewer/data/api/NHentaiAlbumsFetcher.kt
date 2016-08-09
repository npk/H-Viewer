package ml.puredark.hviewer.data.api

import ml.puredark.hviewer.data.beans.AlbumCover

class NHentaiAlbumsFetcher : BaseFetcher<List<AlbumCover>>() {
    fun fetch(page: Number, callback: (result: List<AlbumCover>?) -> Unit) {
        fetch("https://nhentai.net/?page=$page", callback)
    }
}