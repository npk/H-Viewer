package ml.puredark.hviewer.beans

import ml.puredark.hviewer.dataproviders.AbstractDataProvider

class Picture(
        var pid: Int,
        var url: String
) : AbstractDataProvider.Data() {

    override val id: Int
        get() = pid

}
