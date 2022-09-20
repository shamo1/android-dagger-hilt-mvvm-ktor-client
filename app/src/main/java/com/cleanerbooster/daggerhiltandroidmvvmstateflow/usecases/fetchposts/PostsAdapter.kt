package com.cleanerbooster.daggerhiltandroidmvvmstateflow.usecases.fetchposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cleanerbooster.daggerhiltandroidmvvmstateflow.databinding.ItemViewPostBinding
import com.cleanerbooster.daggerhiltandroidmvvmstateflow.network.respose.PostResponseItem

class PostsAdapter(val respose: ArrayList<PostResponseItem>) :
    RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            ItemViewPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindData(respose, position)
    }

    override fun getItemCount(): Int {
        if (respose.isNotEmpty()) {
            return respose.size
        }
        return 0
    }
}

class PostViewHolder(val binding: ItemViewPostBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindData(respose: java.util.ArrayList<PostResponseItem>, position: Int) {
        binding.tvTitle.text = respose[position].title
        binding.tvBody.text = respose[position].body
    }

}
