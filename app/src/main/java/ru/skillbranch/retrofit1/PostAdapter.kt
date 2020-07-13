package ru.skillbranch.retrofit1

import android.os.Build
//import androidx.recyclerview:recyclerview:1.0.0
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.List

class PostsAdapter(
private val posts: List<PostModel>
) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent:ViewGroup , viewType:Int): ViewHolder {
        val v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.post_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts.get(position)
        holder.post.text = post.name
        holder.site.text = post.country;
    }

    override fun getItemCount() = posts?.size ?: 0

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val post = itemView.findViewById<TextView>(R.id.postitem_post)
        val site = itemView.findViewById<TextView>(R.id.postitem_site)
    }
}