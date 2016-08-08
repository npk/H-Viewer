package ml.puredark.hviewer.beans

import ml.puredark.hviewer.dataproviders.AbstractDataProvider

open class Collection(
        var cid: Int,
        var title: String,
        var author: String,
        var cover: String,
        var description: String,
        var datetime: String,
        var type: Int
) : AbstractDataProvider.Data() {

    override val id: Int
        get() = cid

    override fun equals(other: Any?): Boolean {
        if (other is Collection) {
            var result = true
            val fs = Collection::class.java!!.getDeclaredFields()
            try {
                for (f in fs) {
                    f.isAccessible = true
                    val v1 = f.get(this)
                    val v2 = f.get(other)
                    result = result and equals(v1, v2)
                }
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }

            return result
        }
        return false
    }

    fun equals(obj1: Any?, obj2: Any?): Boolean {
        if (obj1 === obj2) {
            return true
        }
        if (obj1 == null || obj2 == null) {
            return false
        }
        return obj1.equals(obj2)
    }

    companion object {
        val TYPE_PICTURE = 1
    }
}
