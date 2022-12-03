package com.parinya.nextzyt2.presentation.article_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.parinya.nextzyt2.R
import com.parinya.nextzyt2.databinding.FragmentArticleDetailBinding
import com.parinya.nextzyt2.domain.model.Source

class ArticleDetailFragment: Fragment(R.layout.fragment_article_detail) {

    private val args: ArticleDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentArticleDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_article_detail, container, false)
        binding.article = args.article
        binding.lifecycleOwner = this
        return binding.root
    }

}