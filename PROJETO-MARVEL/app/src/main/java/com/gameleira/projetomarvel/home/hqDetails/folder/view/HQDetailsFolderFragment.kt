package com.gameleira.projetomarvel.home.hqDetails.folder.view

import com.gameleira.projetomarvel.R
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class HQDetailsFolderFragment : Fragment() {

    companion object {
        fun newInstance() = HQDetailsFolderFragment();
    }

    private lateinit var viewModel: ComicDetailsFolderViewModel
    private lateinit var _myView: View
    private lateinit var _navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _myView =  inflater.inflate(R.layout.fragment_comic_details_folder, container, false)
        return _myView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(ComicDetailsFolderViewModel::class.java)
        _navController = Navigation.findNavController(_myView)

        val btnClose = _myView.findViewById<ImageView>(R.id.closeButton_comicDetailsFolderFragment)
        btnClose.setOnClickListener{
            _navController.navigate(R.id.comicDetailsFragment)
        }

        val imgUrl: String? = arguments?.getString(getString(R.string.img_url))
        if(imgUrl != null) {
            val imgView = _myView.findViewById<ImageView>(R.id.imgComic_comicDetailsFolderFragment)
            Glide.with(_myView.context)
                .load(imgUrl)
                .transform(CenterCrop())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imgView)
        }

    }

}