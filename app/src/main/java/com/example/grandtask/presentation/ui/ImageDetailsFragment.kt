package com.example.grandtask.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.grandtask.data.model.images.Image
import com.example.grandtask.data.util.Resource
import com.example.grandtask.databinding.FragmentImageDetailsBinding
import com.example.grandtask.presentation.adapter.ImagesAdapter
import com.example.grandtask.presentation.viewModel.ImagesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentImageDetailsBinding
    private val args: SearchFragmentArgs by navArgs()
    private val adapter: ImagesAdapter by lazy { ImagesAdapter() }
    val albumId by lazy { args.albumId }

    private val imagesViewModel: ImagesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImageDetailsBinding.inflate(inflater, container, false)



        binding.imageRecycler.adapter = adapter

        getAllData()





        return binding.root
    }

    private fun search(images: List<Image>) {
        val image = ArrayList<Image>()
        val imageFinal = ArrayList<Image>()
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {


            override fun onQueryTextSubmit(p0: String?): Boolean {

                images.forEach {
                    if (it.title.contains(p0!!) ) {
                        imageFinal.add(it)

                    }
                }

                adapter.differ.submitList(imageFinal)
                return false
            }


            override fun onQueryTextChange(p0: String?): Boolean {

                images.forEach {
                    if (it.title.contains(p0!!)) {
                        image.add(it)
                    }
                }

                adapter.differ.submitList(image)
                adapter.notifyDataSetChanged()
                image.clear()
                return false
            }

        })

    }

    private fun getAllData() {
        imagesViewModel.getImages(albumId).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressCircular.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressCircular.visibility = View.GONE
                    search(it.data!!)
                    adapter.differ.submitList(it.data)
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

}