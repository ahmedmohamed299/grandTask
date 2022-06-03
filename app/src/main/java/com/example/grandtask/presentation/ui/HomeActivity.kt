package com.example.grandtask.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.grandtask.R
import com.example.grandtask.data.util.Resource
import com.example.grandtask.databinding.ActivityHomeBinding
import com.example.grandtask.presentation.viewModel.HomeViewModel
import com.example.grandtask.presentation.viewModel.HomeViewModelFactory
import com.example.grandtask.presentation.viewModel.ImagesViewModel
import com.example.grandtask.presentation.viewModel.ImagesViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory
    lateinit var homeViewModel: HomeViewModel
    @Inject
    lateinit var imagesViewModelFactory: ImagesViewModelFactory
    lateinit var imagesViewModel: ImagesViewModel
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        homeViewModel = ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]
        imagesViewModel = ViewModelProvider(this, imagesViewModelFactory)[ImagesViewModel::class.java]

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

    }


}