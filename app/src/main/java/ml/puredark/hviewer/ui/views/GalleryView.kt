package ml.puredark.hviewer.ui.views

import ml.puredark.hviewer.data.beans.AlbumCover

interface GalleryView : PresenterView {
    fun onFetchCovers(covers: List<AlbumCover>)
}