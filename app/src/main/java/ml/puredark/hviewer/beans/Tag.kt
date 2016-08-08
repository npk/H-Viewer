package ml.puredark.hviewer.beans

import ml.puredark.hviewer.dataproviders.AbstractDataProvider

class Tag(
        var tid: Int,
        var title: String)
: AbstractDataProvider.Data() {
    override fun getId(): Int = tid
}
