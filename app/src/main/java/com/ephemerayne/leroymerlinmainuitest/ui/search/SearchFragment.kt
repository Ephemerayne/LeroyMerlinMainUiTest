package com.ephemerayne.leroymerlinmainuitest.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.ephemerayne.leroymerlinmainuitest.R
import com.ephemerayne.leroymerlinmainuitest.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentSearchBinding.inflate(inflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchCategories = arrayOf(
            "Обои", "Ковер", "Люстры", "Стеллаж", "Шторы", "Зеркало", "Ламинат",
            "Столы", "Линолеум", "Плинтус"
        )

        val adapter = ArrayAdapter(binding.root.context, R.layout.search_item, searchCategories)
        binding.searchList.adapter = adapter

        val controller: LayoutAnimationController =
            AnimationUtils.loadLayoutAnimation(context, R.anim.list_layout_controller)
        binding.searchList.layoutAnimation = controller

        binding.toolbarLayout.search.requestFocus()
        val inputManager =
            activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        inputManager?.showSoftInput(binding.toolbarLayout.search, InputMethodManager.SHOW_IMPLICIT)
    }
}


