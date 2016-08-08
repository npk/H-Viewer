package ml.puredark.hviewer.dataproviders

abstract class AbstractDataProvider {

    abstract class Data {
        abstract val id: Int
    }

    abstract val count: Int

    abstract val items: List<Any>

    abstract fun getItem(index: Int): Data

    abstract fun removeItem(position: Int)

    abstract fun clear()

    abstract fun addItem(item: Data)

    abstract fun addItem(position: Int, item: Data)

    abstract fun addAll(items: Collection<Any>)
}
