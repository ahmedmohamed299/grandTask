package com.example.grandtask.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.grandtask.R
import com.example.grandtask.data.model.user.Users
import com.example.grandtask.data.util.Resource
import com.example.grandtask.databinding.FragmentUserBinding
import com.example.grandtask.presentation.OnAlbumListener
import com.example.grandtask.presentation.adapter.AlbumAdapter
import com.example.grandtask.presentation.viewModel.HomeViewModel


class UserFragment : Fragment(), OnAlbumListener {

    private lateinit var userViewModel: HomeViewModel
    private lateinit var binding: FragmentUserBinding
    private lateinit var adapter : AlbumAdapter
    private lateinit var navController: NavController




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentUserBinding.inflate(inflater,container,false)

        userViewModel= (activity as HomeActivity).homeViewModel

        adapter= AlbumAdapter()
        binding.albumRecycler.adapter= adapter
        val navHostFragment = requireActivity().supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        getUserData()

        return binding.root
    }



    private fun getUserData() {
        userViewModel.getUser().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressCircular.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    Log.d("userdata", "onCreate: ${it.data}")
                    binding.userName.text= it.data!!.username
                    binding.userAddress.text= it.data.address.street
                    getAlbumsData(it.data)

                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }


            }
        }

    }


    private fun getAlbumsData(userId: Users) {

        userViewModel.getAlbum(userId).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressCircular.visibility = View.VISIBLE

                }
                is Resource.Success -> {
                    Log.d("albumdata", "onCreate: ${it.data}")
                    adapter.setData(it.data!!,this,userId)

                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    override fun onAlbumClicked(albumId: Users) {
        val action =UserFragmentDirections.actionUserFragmentToSearchFragment(albumId.id)
        navController.navigate(action)
    }


}