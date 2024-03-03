    package pe.cacsire.categoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yostin.cafetin.R
    class MainCategory : AppCompatActivity() {
    private  var recyclerView : RecyclerView? = null
    private var recyclerViewCategoryAdapter : RecyclerViewCategoryAdapter? = null
    private var categoryList = mutableListOf<Category>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_category)

        categoryList = ArrayList()

        recyclerView = findViewById<View>(R.id.rvCategoryLists) as RecyclerView
        recyclerViewCategoryAdapter = RecyclerViewCategoryAdapter(this@MainCategory, categoryList)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this,2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewCategoryAdapter

        prepareCategoryListData()
    }

    private fun prepareCategoryListData() {
        var category = Category("Bebidas",R.drawable.refresco)
        categoryList.add(category)
        category = Category("Combos",R.drawable.combo)
        categoryList.add(category)
        category = Category("Postres",R.drawable.pos)
        categoryList.add(category)
        category = Category("Hamburguesas",R.drawable.ham)
        categoryList.add(category)

        recyclerViewCategoryAdapter!!.notifyDataSetChanged()
    }
}