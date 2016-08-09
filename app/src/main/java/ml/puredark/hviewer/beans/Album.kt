package ml.puredark.hviewer.beans

data class Album(
        var id: Int,
        var title: String,
        var author: String,
        var cover: String,
        var description: String,
        var datetime: String,

        var tags: List<Tag>,
        var pictures: List<Picture>
)

