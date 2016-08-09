package ml.puredark.hviewer.ui.presenters

import ml.puredark.hviewer.ui.views.PresenterView

interface BasePresenter<T: PresenterView> {
    val view: T
}