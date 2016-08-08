package ml.puredark.hviewer.beans

import ml.puredark.hviewer.dataproviders.AbstractDataProvider

class Picture(
        var pid: Int,
        var url: String
) : AbstractDataProvider.Data() {
    override fun getId(): Int = pid
}
