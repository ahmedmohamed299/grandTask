package com.example.grandtask.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.grandtask.data.util.Resource
import com.example.grandtask.databinding.FragmentImageDetailsBinding
import com.example.grandtask.presentation.adapter.ImagesAdapter
import com.example.grandtask.presentation.viewModel.ImagesViewModel

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentImageDetailsBinding
    private val args: SearchFragmentArgs by navArgs()
    lateinit var imagesViewModel: ImagesViewModel
    private lateinit var adapter: ImagesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImageDetailsBinding.inflate(inflater, container, false)
        val id = args.id

        Log.d("albumID", "onCreateView: $id")
        imagesViewModel = (activity as HomeActivity).imagesViewModel
        adapter = ImagesAdapter()
        binding.imageRecycler.adapter = adapter


        imagesViewModel.getImages(id).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressCircular.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    adapter.setData(it.data!!)
                    Log.d("getImages", "onCreateView: ${it.data}")
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }



        return binding.root
    }

}