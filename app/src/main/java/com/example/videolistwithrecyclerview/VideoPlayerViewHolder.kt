package com.example.videolistwithrecyclerview

import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.videolistwithrecyclerview.models.MediaObject

class VideoPlayerViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val media_container = view.findViewById<FrameLayout>(R.id.media_container)
    private val title = view.findViewById<TextView>(R.id.title)
    val thumbnail = view.findViewById<ImageView>(R.id.thumbnail)
    val volumeControl = view.findViewById<ImageView>(R.id.volume_control)
    val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
    private var parent = view.findViewById<View>(R.id.parent)
    var requestManager: RequestManager? = null

    init {
        parent = itemView
    }

    fun bind(mediadObject: MediaObject, requestManager: RequestManager) {
        this.requestManager = requestManager
        parent.tag = this
        title.text = mediadObject.title
        this.requestManager?.load(mediadObject.thumbnail)?.into(thumbnail)
    }
}