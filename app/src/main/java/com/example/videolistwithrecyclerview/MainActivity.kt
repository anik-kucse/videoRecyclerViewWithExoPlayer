package com.example.videolistwithrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.videolistwithrecyclerview.util.Resources

class MainActivity : AppCompatActivity() {

    private lateinit var mRecyclerView: VideoPlayerRecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.recycler_view)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = layoutManager
        val itemDecorator = VerticalSpacingItemDecorator(10)
        mRecyclerView.addItemDecoration(itemDecorator)

        val mediaObjects = Resources.MEDIA_OBJECTS
        mRecyclerView.setMediaObjects(mediaObjects.toList())
        val adapter = VideoPlayerRecyclerAdapter(mediaObjects.toList(), initGlide())
        mRecyclerView.adapter = adapter
    }

    private fun initGlide(): RequestManager {
        val options: RequestOptions = RequestOptions()
            .placeholder(R.drawable.white_background)
            .error(R.drawable.white_background)
        return Glide.with(this)
            .setDefaultRequestOptions(options)
    }

    override fun onDestroy() {
        mRecyclerView.releasePlayer();
        super.onDestroy()
    }
}
