package com.example.grandtask.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.grandtask.R
import com.example.grandtask.data.model.album.Album
import com.example.grandtask.data.model.user.Users
import com.example.grandtask.databinding.AlbumItemBinding
import com.example.grandtask.presentation.OnAlbumListener

class AlbumAdapter : RecyclerView.Adapter<AlbumAdapter.AlbumHolder>() {
    lateinit var binding: AlbumItemBinding
    var albumList = ArrayList<Album>()
    lateinit var users: Users
    lateinit var onAlbumListener: OnAlbumListener
    fun setData(albumsList: List<Album>,onAlbumListener: OnAlbumListener,user:Users){
        this.users=user
        this.albumList.addAll(albumsList)
        this.onAlbumListener=onAlbumListener
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {
        val layoutInflater = LayoutInflater.from(parent.context)


        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.album_item,
            parent,
            false
        )

        return AlbumHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {
        Log.d("onBindViewHolder", "onBindViewHolder:$albumList ")
        holder.bind(albumList[position],onAlbumListener,users)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }


    class AlbumHolder(private val binding: AlbumItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Album, onAlbumListener: OnAlbumListener, users: Users) {
            binding.name.text= album.title
            binding.cardView.setOnClickListener {
                onAlbumListener.onAlbumClicked(users)
            }
        }
    }

}