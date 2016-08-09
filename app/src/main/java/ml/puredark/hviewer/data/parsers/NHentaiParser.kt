package ml.puredark.hviewer.data.parsers

import ml.puredark.hviewer.data.beans.AlbumCover

class NHentaiParser : BaseParser<List<AlbumCover>>() {
    override fun parse(): List<AlbumCover> {
        val galleryList = mutableListOf<AlbumCover>()
        val galleries = document.select(".gallery");
        galleries.forEach { gallery ->
            val title = gallery.select(".caption").text()
            val cover = gallery.select("img").attr("src")
            galleryList.add(AlbumCover(title, cover))
        }
        return galleryList;
    }
}