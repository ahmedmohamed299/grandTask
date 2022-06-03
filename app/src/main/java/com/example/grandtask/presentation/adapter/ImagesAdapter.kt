package com.example.grandtask.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.grandtask.R
import com.example.grandtask.data.model.images.Image
import com.example.grandtask.databinding.PhotoItemBinding
import com.squareup.picasso.Picasso

class ImagesAdapter : RecyclerView.Adapter<ImagesAdapter.PhotoHolder>() {
    lateinit var binding: PhotoItemBinding
    var imageList = ArrayList<Image>()

    fun setData(imageList: List<Image>){
        this.imageList.addAll(imageList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val layoutInflater = LayoutInflater.from(parent.context)


        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.photo_item,
            parent,
            false
        )

        return PhotoHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.bind(imageList[position])
        Log.d("EnterToAdapter", "setData:${imageList.size} ")

    }

    override fun getItemCount(): Int {
        return imageList.size
    }


    class PhotoHolder(private val binding: PhotoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Image) {
            Picasso.get().load(album.url).into(binding.photo)



        }
    }

}