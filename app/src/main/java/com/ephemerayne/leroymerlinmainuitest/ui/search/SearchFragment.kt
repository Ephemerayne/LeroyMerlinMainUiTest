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
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ephemerayne.leroymerlinmainuitest.R
import com.ephemerayne.leroymerlinmainuitest.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: SearchFragmentViewModel
    private lateinit var adapter: ArrayAdapter<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentSearchBinding.inflate(inflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = ArrayAdapter<String>(binding.root.context, R.layout.search_item)

        viewModel = ViewModelProvider(this).get(SearchFragmentViewModel::class.java)

        viewModel.getCategories("").observe(viewLifecycleOwner, {
            adapter.clear()
            adapter.addAll(it)
        })

        binding.searchList.adapter = adapter

        val controller: LayoutAnimationController =
            AnimationUtils.loadLayoutAnimation(context, R.anim.list_layout_controller)
        binding.searchList.layoutAnimation = controller

        binding.toolbarLayout.search.requestFocus()
        val inputManager =
            activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        inputManager?.showSoftInput(binding.toolbarLayout.search, InputMethodManager.SHOW_IMPLICIT)


        binding.toolbarLayout.search.addTextChangedListener { input ->
            input?.let {
                viewModel.getCategories(it.toString()).observe(viewLifecycleOwner, { categories->
                    adapter.clear()
                    adapter.addAll(categories)
                })
            }
        }
    }
}


