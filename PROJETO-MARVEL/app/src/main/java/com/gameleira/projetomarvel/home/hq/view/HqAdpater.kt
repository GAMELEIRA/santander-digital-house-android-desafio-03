package com.gameleira.projetomarvel.home.hq.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gameleira.projetomarvel.R
import com.gameleira.projetomarvel.home.hq.model.HQ


class jiraComicAdapter(
    private val dataSet: List<HQ>,
    private val clickListener: (HQ) -> Unit
): RecyclerView.Adapter<HQViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HQViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_comic_card, parent, false)

        return HQViewHolder(view);
    }

    override fun onBindViewHolder(holder: HQViewHolder, position: Int) {
        holder.bind(dataSet[position])
        holder.itemView.setOnClickListener{clickListener(dataSet[position])}    }

    override fun getItemCount() = dataSet.size

}