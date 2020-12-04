package com.gameleira.projetomarvel.home.hq.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gameleira.projetomarvel.R
import com.gameleira.projetomarvel.home.hq.model.HQ

class HQViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val imgComic = view.findViewById<ImageView>(R.id.imgComic_itemComicCard)
    private val txtEdition = view.findViewById<TextView>(R.id.txtNumber_itemComicCard)
    private val context = view.context

    fun bind(hq: HQ) {
        hq.thumbnail?.let {
            Glide.with(context)
                .load(it.path + "." + it.extension)
                .transform(CenterCrop())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imgComic)
        }


        val issueNumberString = "#" + hq.issueNumber
        txtEdition.text = issueNumberString

    }
}
