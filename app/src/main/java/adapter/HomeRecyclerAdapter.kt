package adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_home_single_row.view.*
import meghna.lottey.foodrunner.R
import model.Restaurant

class HomeRecyclerAdapter(val context: Context, val itemList: ArrayList<Restaurant>)  :
    RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeRecyclerAdapter.HomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_home_single_row,parent,false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int =itemList.size

    override fun onBindViewHolder(holder: HomeRecyclerAdapter.HomeViewHolder, position: Int) {

        val restaurant =itemList[position]
        holder.txtRestaurantName.text = restaurant.restaurantName
        holder.txtPrice.text = restaurant.pricePerPerson
        holder.txtRating.text = restaurant.restaurantRating
        holder.imgRestaurantImage.setImageResource(restaurant.restaurantImage)
      //  Picasso.get().load(restaurant.restaurantImage).error(R.drawable.header2).into(holder.imgRestaurantImage)

        holder.llContent.setOnClickListener{
           //   val intent = Intent(context,DescriptionActivity::class.java)
//            intent.putExtra("book_id",book.bookId)
//            context.startActivity(intent)

        }
        holder.txtFavorite.setOnClickListener {

            holder.txtFavorite.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_favred2,0)
        }

    }



    class HomeViewHolder(view:View) :RecyclerView.ViewHolder(view) {
        val txtRestaurantName:TextView = view.findViewById(R.id.txtRestaurantName)
        val txtPrice:TextView = view.findViewById(R.id.txtPrice)
        val txtFavorite:TextView =view.findViewById(R.id.txtFavourite)
        val txtRating :TextView =view.findViewById(R.id.txtRating)
        val imgRestaurantImage:ImageView = view.findViewById(R.id.imgRestaurantImage)
        val llContent : LinearLayout = view.findViewById(R.id.llContent)

    }
}
