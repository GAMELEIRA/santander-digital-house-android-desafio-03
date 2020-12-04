package com.gameleira.projetomarvel.home.hq.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gameleira.projetomarvel.R
import com.gameleira.projetomarvel.home.hq.repository.HQRepository

class HQFragment  : Fragment() {

    companion object {
        fun newInstance() = HQFragment()
    }

    private lateinit var _viewModel: HQViewHolder
    private lateinit var _myView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _myView = inflater.inflate(R.layout.fragment_comic, container, false)
        return _myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _viewModel = ViewModelProvider(
            this,
            ComicViewModel.ComicViewModelFactory(HQRepository())
        ).get(ComicViewModel::class.java)

        _viewModel.getComics().observe(viewLifecycleOwner, {
            createList(it)
        })
    }

    private fun createList(comics: List<ComicModel>) {
        val viewManager = GridLayoutManager(_myView.context, 3)
        val recyclerView = _myView.findViewById<RecyclerView>(R.id.recyclerView_comicFragment)
        val viewAdapter = HqA(comics) {
            val intent = Intent(activity, ComicDetailsActivity::class.java)
            intent.putExtra(getString(R.string.intent_comic_id), it.id)
            startActivity(intent)
        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}