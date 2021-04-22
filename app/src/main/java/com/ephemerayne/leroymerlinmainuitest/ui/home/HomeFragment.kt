package com.ephemerayne.leroymerlinmainuitest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.ephemerayne.leroymerlinmainuitest.App
import com.ephemerayne.leroymerlinmainuitest.R
import com.ephemerayne.leroymerlinmainuitest.databinding.FragmentHomeBinding
import com.ephemerayne.leroymerlinmainuitest.domain.entity.*
import javax.inject.Inject

class HomeFragment : Fragment(), CategoryListener, ProductListener {

    @Inject
    lateinit var viewModel: HomeFragmentViewModel

    private lateinit var binding: FragmentHomeBinding

    private val limitedAdapter: ProductAdapter = ProductAdapter(this)
    private val bestPriceAdapter: ProductAdapter = ProductAdapter(this)
    private lateinit var categoriesAdapter: CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHomeBinding.inflate(inflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as App).appComponent.inject(this)

        context?.let { categoriesAdapter = CategoriesAdapter(it, this) }

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

            if (products.isNotEmpty()) {
                binding.shimmerFirst.visibility = View.GONE
                binding.shimmerSecond.visibility = View.GONE

                binding.textLimitedOffer.visibility = View.VISIBLE
                binding.textBestPrice.visibility = View.VISIBLE
            }

            limitedAdapter.setProducts(products.filter { it.isLimitedOffer })
            bestPriceAdapter.setProducts(products.filter { it.isBestPrice })
        })

        binding.toolbarLayout.search.setOnClickListener {
            Toast.makeText(context, "Search clicked!", Toast.LENGTH_SHORT).show()
            openSearchFragment()

        }

        with(binding.toolbarLayout.search) {
            isFocusableInTouchMode = false
            isCursorVisible = false
        }
    }

    private fun openSearchFragment() {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.nav_host_fragment, SearchFragment())
        transaction?.addToBackStack("main")
        transaction?.commit()
    }

    override fun onProductCategoryClick(categoryEntity: CategoryEntity) {
        Toast.makeText(
            context,
            "Product category clicked: ${categoryEntity.title}",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onCatalogCategoryClick() {
        Toast.makeText(context, "Catalog clicked!", Toast.LENGTH_SHORT).show()
    }

    override fun onAllCategoryClick() {
        Toast.makeText(context, "All Categories clicked!", Toast.LENGTH_SHORT).show()
    }

    override fun onProductClick(productEntity: ProductEntity) {
        Toast.makeText(context, "Product ${productEntity.title} clicked!", Toast.LENGTH_SHORT)
            .show()
    }
}

