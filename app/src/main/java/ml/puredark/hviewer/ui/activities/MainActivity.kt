package ml.puredark.hviewer.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import ml.puredark.hviewer.R
import ml.puredark.hviewer.data.beans.AlbumCover
import ml.puredark.hviewer.ui.presenters.GalleryPresenter
import ml.puredark.hviewer.ui.views.GalleryView

class MainActivity : AppCompatActivity(), GalleryView {
    val presenter by lazy { GalleryPresenter(this) }

    override fun onFetchCovers(covers: List<AlbumCover>) {
        runOnUiThread {
            var label = findViewById(R.id.label1) as TextView;
            label.text = covers.count().toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.fetch();
    }

}
