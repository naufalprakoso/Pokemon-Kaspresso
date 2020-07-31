package com.naufalprakoso.pokemonkaspresso.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufalprakoso.pokemonkaspresso.databinding.ActivityMainBinding
import com.naufalprakoso.pokemonkaspresso.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        setupData()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        mainBinding.rvData.layoutManager = LinearLayoutManager(this)
        mainBinding.rvData.adapter = adapter
    }

    private fun setupData() {
        adapter = MainAdapter(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
        viewModel.getData()
        viewModel.getData().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { data ->
                            adapter.setData(data)
                            adapter.notifyDataSetChanged()
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        // Loading
                    }
                }
            }
        })
    }

}