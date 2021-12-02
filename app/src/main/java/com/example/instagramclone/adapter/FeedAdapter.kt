package com.example.instagramclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.databinding.ActivityFeedBinding
import com.example.instagramclone.databinding.RecyclerRowBinding
import com.example.instagramclone.model.Post
import com.squareup.picasso.Picasso

class FeedAdapter(val postList : ArrayList<Post>) : RecyclerView.Adapter<FeedAdapter.FeedView>() {

    class FeedView(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedView {

        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  FeedView(binding)
    }

    override fun onBindViewHolder(holder: FeedView, position: Int) {
        holder.binding.txtUserEmail.text = postList.get(position).email
        holder.binding.txtUserComment.text = postList.get(position).comment
        Picasso.get().load(postList.get(position).downloadUrl).into(holder.binding.rcImageView);
    }

    override fun getItemCount(): Int {

        return  postList.size
    }
}