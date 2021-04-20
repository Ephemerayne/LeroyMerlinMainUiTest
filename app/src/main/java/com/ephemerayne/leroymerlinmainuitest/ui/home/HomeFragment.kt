package com.ephemerayne.leroymerlinmainuitest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.leroymerlinmainuitest.App
import com.ephemerayne.leroymerlinmainuitest.databinding.FragmentHomeBinding
import com.ephemerayne.leroymerlinmainuitest.domain.entity.AllCategory
import com.ephemerayne.leroymerlinmainuitest.domain.entity.CatalogCategory
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Category
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModel: HomeFragmentViewModel

    private lateinit var binding: FragmentHomeBinding

    private val limitedAdapter: ProductAdapter = ProductAdapter()
    private val bestPriceAdapter: ProductAdapter = ProductAdapter()
    private lateinit var categoriesAdapter: CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHomeBinding.inflate(inflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as App).appComponent.inject(this)

        context?.let { categoriesAdapter = CategoriesAdapter(it) }

        binding.recyclerViewCategories.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = categoriesAdapter
            LinearSnapHelper().attachToRecyclerView(this)
            setScrollingTouchSlop(RecyclerView.TOUCH_SLOP_PAGING)
        }

        viewModel.getCategories().observe(viewLifecycleOwner, { categories ->
            val listCategories: ArrayList<Category> = ArrayList<Category>().apply {
                add(CatalogCategory())
                addAll(categories)
                add(AllCategory())
            }

            categoriesAdapter.setCategories(listCategories)
        })

        with(binding.recyclerViewLimitedOffer) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = limitedAdapter
        }

        with(binding.recyclerViewOfBestPrice) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = bestPriceAdapter

        }

        viewModel.getProducts().observe(viewLifecycleOwner, { products ->
            limitedAdapter.setProducts(products.filter { it.isLimitedOffer })
            bestPriceAdapter.setProducts(products.filter { it.isBestPrice })
        })


    }
}