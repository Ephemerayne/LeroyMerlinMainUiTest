package com.ephemerayne.leroymerlinmainuitest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.leroymerlinmainuitest.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeFragmentViewModel

    private val limitedAdapter: ProductAdapter = ProductAdapter()
    private val bestPriceAdapter: ProductAdapter = ProductAdapter()
    private val categoriesAdapter: CategoriesAdapter = CategoriesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHomeBinding.inflate(inflater).also { binding = it }.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        binding.recyclerViewCategories.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = categoriesAdapter
            LinearSnapHelper().attachToRecyclerView(this)
            setScrollingTouchSlop(RecyclerView.TOUCH_SLOP_PAGING)
        }

        viewModel.categories.observe(viewLifecycleOwner, { categories ->
            categoriesAdapter.setCategories(categories)
        })

        with(binding.recyclerViewLimitedOffer) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = limitedAdapter
        }

        with(binding.recyclerViewOfBestPrice) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = bestPriceAdapter

        }

        viewModel.products.observe(viewLifecycleOwner, { products ->
            limitedAdapter.setProducts(products.filter { it.isLimitedOffer })
            bestPriceAdapter.setProducts(products.filter { it.isBestPrice })
        })


    }
}