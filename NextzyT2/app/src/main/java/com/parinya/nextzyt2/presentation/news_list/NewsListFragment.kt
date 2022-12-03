package com.parinya.nextzyt2.presentation.news_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.parinya.nextzyt2.R
import com.parinya.nextzyt2.databinding.FragmentNewsListBinding
import com.parinya.nextzyt2.util.RecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsListFragment: Fragment(R.layout.fragment_news_list) {

    private val viewModel by viewModel<NewsListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentNewsListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_list, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView(view)
    }

    private fun initRecyclerView(view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.newsRecycleView)
        recyclerView.adapter = RecyclerViewAdapter()
        val adapter = recyclerView.adapter as RecyclerViewAdapter

        adapter.setOnItemClickListener {
            val action = NewsListFragmentDirections.actionNewsListFragmentToArticleDetailFragment(it)
            findNavController().navigate(action)
        }
    }
}