package com.gameleira.projetomarvel.home.hqDetails.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gameleira.projetomarvel.R
import java.text.SimpleDateFormat

class HQDetailsFragment : Fragment() {
    companion object {
        fun newInstance(comicId: Int? = null) = HQDetailsFragment();
    }

    private var comicId: Int? = null
    private var comicThumbUrl: String? = null

    private lateinit var _myView: View
    private lateinit var _navController: NavController
    private lateinit var _viewModel: HQDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _myView =  inflater.inflate(R.layout.fragment_comic_details, container, false)

        return _myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _navController = Navigation.findNavController(_myView)

        val intent: Intent = requireActivity().intent
        val id = intent.getIntExtra(getString(R.string.intent_comic_id), 1)

        _viewModel = ViewModelProvider(
            this,
            ComicDetailsViewModel.ComicDetailsViewModelFactory(ComicDetailsRepository())
        ).get(ComicDetailsViewModel::class.java)

        _viewModel.getComicDetails(id).observe(viewLifecycleOwner, {
            loadInfo(it)
        })

        setEvents()
    }

    private fun setEvents() {
        val btnBack = _myView.findViewById<ImageView>(R.id.backButton_comicDetailsFragment)
        btnBack.setOnClickListener{
            activity?.finish()
        }

        val imgComicFolder = _myView.findViewById<ImageView>(R.id.imgComic_comicDetailsFragment)
        imgComicFolder.setOnClickListener{
            if(comicThumbUrl != null) {
                val bundle= bundleOf(getString(R.string.img_url) to comicThumbUrl)

                _navController.navigate(R.id.comicDetailsFolderFragment, bundle)
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this) {
            activity?.finish()
        }
    }

    private fun loadInfo(comic: ComicModel) {

        val txtTitle = _myView.findViewById<TextView>(R.id.txtTitle_comicDetailsFragment)
        val txtDescricao = _myView.findViewById<TextView>(R.id.txtDetails_comicDetailsFragment)
        val txtData = _myView.findViewById<TextView>(R.id.txtPublishedValue_comicDetailsFragment)
        val txtPreco = _myView.findViewById<TextView>(R.id.txtPriceValue_comicDetailsFragment)
        val txtPages = _myView.findViewById<TextView>(R.id.txtPagesValue_comicDetailsFragment)
        val imgComic = _myView.findViewById<ImageView>(R.id.imgComic_comicDetailsFragment)

        txtTitle.text = comic.titulo

        if(comic.descricao != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                txtDescricao.text = Html.fromHtml(comic.descricao , Html.FROM_HTML_MODE_COMPACT);
            } else {
                txtDescricao.text = Html.fromHtml(comic.descricao );
            }
        }



        txtData.text = comic.datas?.get(0)?.let { getDateTime(it.date) }

        val precoString = "$ ${comic.precos?.get(0)?.price.toString()}"
        txtPreco.text = precoString

        txtPages.text = comic.paginas.toString()

        comic.img?.let {
            comicThumbUrl = it.path + "." + it.extension

            Glide.with(_myView.context)
                .load(it.path + "." + it.extension)
                .transform(CenterCrop())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imgComic)
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDateTime(s: String): String? {
        return try {
            val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val formatter = SimpleDateFormat("MMMM dd, yyyy")
            formatter.format(parser.parse(s))
        } catch (e: Exception) {
            e.toString()
        }
    }
}