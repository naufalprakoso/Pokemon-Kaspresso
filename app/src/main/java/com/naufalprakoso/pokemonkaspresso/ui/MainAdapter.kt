package com.naufalprakoso.pokemonkaspresso.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naufalprakoso.pokemonkaspresso.databinding.ItemDataBinding
import com.naufalprakoso.pokemonkaspresso.network.response.SpeciesResponse

class MainAdapter(
    context: Context,
    private val clickListener: (String) -> Unit
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    private lateinit var binding: ItemDataBinding

    private val data = arrayListOf<SpeciesResponse>()

    fun setData(data: List<SpeciesResponse>) {
        this.data.clear()
        this.data.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemDataBinding.inflate(inflater, parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(binding, data[position], clickListener)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(
            binding: ItemDataBinding,
            data: SpeciesResponse,
            clickListener: (String) -> Unit
        ) {
            binding.tvName.text = data.name
            binding.tvName.setOnClickListener {
                clickListener(data.name)
            }
        }
    }
}