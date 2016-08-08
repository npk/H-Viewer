package ml.puredark.hviewer


import android.annotation.TargetApi
import android.app.Application
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.os.Build
import android.support.v7.app.AppCompatDelegate
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.google.gson.Gson

import java.util.ArrayList

import ml.puredark.hviewer.utils.SharedPreferencesUtil

class HViewerApplication : Application() {

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressWarnings("unused")
    override fun onCreate() {
        super.onCreate()
        mContext = this
    }

    companion object {
        var mContext: Context? = null
        // 全局变量，用于跨Activity传输复杂对象
        var temp: Any? = null

        //服务器地址
        var serverHost = ""

        var histories: MutableList<Collection<Any>>? = null
        var favourites: MutableList<Collection<Any>>? = null

        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }


        val versionName: String?
            @Throws(Exception::class)
            get() {
                val packageManager = mContext?.packageManager
                val packInfo = packageManager?.getPackageInfo(mContext?.packageName, 0)
                val version = packInfo?.versionName
                return version
            }

        /**
         * 检测网络是否连接

         * @return
         */
        // 得到网络连接信息
        // 去进行判断网络是否连接
        val isNetworkAvailable: Boolean
            get() {
                val manager = mContext?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                return manager.activeNetworkInfo.isAvailable;
            }

        fun loadImageFromUrl(imageView: ImageView, url: String?) {
            imageView.setImageBitmap(null)
            Glide.with(mContext).load(url)?.into(imageView)
        }


        fun saveHistory() {
            SharedPreferencesUtil.saveData(mContext, "History", Gson().toJson(histories))
        }

        fun addHistory(item: Collection<Any>?) {
            if (item == null) return
            deleteHistory(item)
            histories!!.add(0, item)
            trimHistory()
            saveHistory()
        }

        fun deleteHistory(item: Collection<Any>) {
            var i = 0
            var size = histories!!.size
            while (i < size) {
                if (histories!![i] == item) {
                    histories!!.removeAt(i)
                    size--
                    i--
                }
                i++
            }
            saveHistory()
        }

        val history: List<Collection<Any>>?
            get() = histories ?: ArrayList()

        fun trimHistory() {
            while (histories!!.size > 20)
                histories!!.removeAt(20)
        }

        fun saveFavourite() {
            SharedPreferencesUtil.saveData(mContext, "Favourite", Gson().toJson(favourites))
        }

        fun addFavourite(item: Collection<Any>?) {
            if (item == null) return
            deleteFavourite(item)
            favourites!!.add(0, item)
            saveFavourite()
        }

        fun deleteFavourite(item: Collection<Any>) {
            var i = 0
            var size = favourites!!.size
            while (i < size) {
                if (favourites!![i] == item) {
                    favourites!!.removeAt(i)
                    size--
                    i--
                }
                i++
            }
            saveFavourite()
        }

        val favourite: List<Collection<Any>>?
            get() = favourites ?: ArrayList()

        fun isFavourite(item: Collection<Any>): Boolean {
            var i = 0
            val size = favourites!!.size
            while (i < size) {
                if (favourites!![i] == item)
                    return true
                i++
            }
            return false
        }
    }

}
