package com.example.grandtask.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.grandtask.R
import com.example.grandtask.data.model.images.Image
import com.example.grandtask.databinding.PhotoItemBinding
import com.squareup.picasso.Picasso

class ImagesAdapter : RecyclerView.Adapter<ImagesAdapter.PhotoHolder>() {
    lateinit var binding: PhotoItemBinding
    private var imageList = ArrayList<Image>()

    fun setData(imageList: List<Image>){
        this.imageList.clear()
        this.imageList.addAll(imageList)
        notifyDataSetChanged()
    }

    private val callback = object : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val layoutInflater = LayoutInflater.from(parent.context)


        binding =  PhotoItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return PhotoHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val image =differ.currentList[position]
        holder.bind(image)
        Log.d("EnterToAdapter", "setData:${imageList.size} ++ $image ")

    }

    override fun getItemCount(): Int = differ.currentList.size



    class PhotoHolder(private val binding: PhotoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Image) {
            Picasso.get().load(album.url).into(binding.photo)



        }
    }

}