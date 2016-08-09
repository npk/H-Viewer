package ml.puredark.hviewer.data.api

import ml.puredark.hviewer.data.beans.AlbumCover

class NHentaiCoversFetcher(page: Number, callback: (result: List<AlbumCover>?) -> Unit)
    : BaseFetcher<List<AlbumCover>>("https://nhentai.net/?page=$page", callback)