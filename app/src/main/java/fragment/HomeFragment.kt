package fragment

import adapter.HomeRecyclerAdapter
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import meghna.lottey.foodrunner.R
import model.Restaurant
import util.ConnectionManager

class HomeFragment : Fragment() {
    lateinit var recyclerHome: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var recyclerAdapter: HomeRecyclerAdapter
    lateinit var btnCheckInternet: Button

    var restaurantInfoList = arrayListOf<Restaurant>()
//
//    var restaurantInfoList = arrayListOf<Restaurant>(
//        Restaurant("Abc", "rs.200/person", "4.3", R.drawable.header),
//        Restaurant("mnc", "250", "4.3", R.drawable.header2),
//        Restaurant("Abcsh x", "rs.207/person", "4.3", R.drawable.header),
//        Restaurant("mnnn jzxkc", "290", "4.3", R.drawable.header2),
//        Restaurant("Abc knl", "rs.200/person", "4.3", R.drawable.header),
//        Restaurant("mnc c cc", "250", "4.3", R.drawable.header2),
//        Restaurant("Abncjvncsh x", "rs.207/person", "4.3", R.drawable.header),
//        Restaurant("mcjndnnn jzxkc", "290", "4.3", R.drawable.header2)
//    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerHome = view.findViewById(R.id.recyclerHome)
        layoutManager = LinearLayoutManager(activity)



        recyclerAdapter = HomeRecyclerAdapter(activity as Context, restaurantInfoList)
        recyclerHome.adapter = recyclerAdapter
        recyclerHome.layoutManager = layoutManager

        val queue = Volley.newRequestQueue(activity as Context)
        val url = "http://13.235.250.119/v2/restaurants/fetch_result/"

        if (ConnectionManager().connectivityManager(activity as Context)) {//Internet is Available
            val jsonObjectRequest =
                object : JsonObjectRequest(Request.Method.GET,url,null, Response.Listener {
                    //handle response
                    println("Response is  ${it}")
                },Response.ErrorListener {
                    //Handle error
                    println("Error is $it")
                }){
                    override fun getHeaders(): MutableMap<String, String> {
                        val headers = HashMap<String ,String>()
                        headers["Context-Type"] = "application/json"
                        headers["token"] = "f38d650ba4002e"
                        return headers

                    }
                }
            queue.add(jsonObjectRequest)


        } else {
            //internet is not available
            val dialog = AlertDialog.Builder(activity as Context)
            dialog.setTitle("Error")
            dialog.setMessage("Internet Connection is not Found")
            dialog.setPositiveButton("Ok") { text, listener -> }
            dialog.setNegativeButton("Cancel") { text, listener -> }
            dialog.create()
            dialog.show()
        }
        return view
    }

}