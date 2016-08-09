package ml.puredark.hviewer.ui.presenters

import ml.puredark.hviewer.data.api.NHentaiCoversFetcher
import ml.puredark.hviewer.ui.views.GalleryView

class GalleryPresenter(override val view: GalleryView) : BasePresenter<GalleryView> {
    fun fetch() {
        NHentaiCoversFetcher(1) { covers ->
            view.onFetchCovers(covers ?: listOf())
        }
    }
}