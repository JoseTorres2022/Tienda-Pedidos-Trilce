package com.yostin.cafetin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.cacsire.categoria.Category
import pe.cacsire.categoria.RecyclerViewCategoryAdapter

class CategoryF : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var recyclerViewCategoryAdapter: RecyclerViewCategoryAdapter? = null
    private var categoryList = mutableListOf<Category>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        recyclerView = view.findViewById(R.id.rvCategoryLists)
        recyclerViewCategoryAdapter = RecyclerViewCategoryAdapter(requireContext(), categoryList)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = recyclerViewCategoryAdapter

        prepareCategoryListData()

        return view
    }

    private fun prepareCategoryListData() {
        categoryList.apply {
            add(Category("Bebidas", R.drawable.refresco))
            add(Category("Combos", R.drawable.combo))
            add(Category("Postres", R.drawable.pos))
            add(Category("Hamburguesas", R.drawable.ham))
        }
        recyclerViewCategoryAdapter?.notifyDataSetChanged()
    }
}
