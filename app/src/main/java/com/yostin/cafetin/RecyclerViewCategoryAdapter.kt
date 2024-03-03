package pe.cacsire.categoria

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.yostin.cafetin.R

class RecyclerViewCategoryAdapter(
    private val getActivity: Context,
    private val categoryList: List<Category>):
    RecyclerView.Adapter<RecyclerViewCategoryAdapter.MyViewHilder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHilder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_category_list_item,parent,false)
        return MyViewHilder(view)
    }

    override fun onBindViewHolder(holder: MyViewHilder, position: Int) {
        holder.tvCategoryTtile.text = categoryList[position].title
        holder.lvCategoryImg.setImageResource(categoryList[position].image)
        holder.CardView.setOnClickListener{
            Toast.makeText(getActivity, categoryList[position].title, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class MyViewHilder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tvCategoryTtile : TextView = itemView.findViewById(R.id.tvCategoryTitle)
        val lvCategoryImg : ImageView = itemView.findViewById(R.id.ivCategoryImg)
        val CardView : CardView = itemView.findViewById(R.id.cardView)

    }

}