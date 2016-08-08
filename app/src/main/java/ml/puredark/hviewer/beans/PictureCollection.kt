package ml.puredark.hviewer.beans

class PictureCollection(
        cid: Int,
        title: String,
        author: String,
        cover: String,
        description: String,
        datetime: String,

        var tags: List<Tag>,
        var pictures: List<Picture>
) : Collection(cid, title, author, cover, description, datetime, Collection.TYPE_PICTURE)
