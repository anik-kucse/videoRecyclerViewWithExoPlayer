package com.example.videolistwithrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.videolistwithrecyclerview.models.MediaObject


class VideoPlayerRecyclerAdapter(
    private val mediaObjects: List<MediaObject>,
    private val requestManager: RequestManager
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  VideoPlayerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_video_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return mediaObjects.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as VideoPlayerViewHolder).bind(mediaObjects[position], requestManager)
    }
}