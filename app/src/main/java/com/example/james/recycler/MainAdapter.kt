package com.example.james.recycler

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row.view.*

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    // get number of items in view
    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // how to create review
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val itemTitle = homeFeed.videos.get(position)
        holder?.view?.textView_item_title?.text = itemTitle.name

        holder?.view?.textView_channel_name?.text = itemTitle.channel.name

        val thumbnailImageHView = holder?.view?.imageView_video_thumbnail
        Picasso.get().load(itemTitle.imageUrl).into(thumbnailImageHView)

        val channelProfileImageView = holder?.view?.ImageView_channel_profile
        Picasso.get().load(itemTitle.channel.profileImageUrl).into(channelProfileImageView)

    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    init {
        view.setOnClickListener {
            println("test")

            val intent = Intent(view.context, CourseDetailActivity::class.java)

            view.context.startActivity(intent)
        }

    }


}