package meghna.lottey.foodrunner.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import fragment.FaqsFragment
import fragment.FavouriteFragment
import fragment.HomeFragment
import fragment.MyProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import meghna.lottey.foodrunner.R

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView
    lateinit var sharedPreferences: SharedPreferences

    var previousMenuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        frameLayout = findViewById(R.id.frame)
        toolbar = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.navigationView)

        sharedPreferences =
            getSharedPreferences("Restraunt preferences", Context.MODE_PRIVATE)

        setUpToolbar()
        openHome()
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {

            if (previousMenuItem != null) {
                previousMenuItem?.isChecked = false
            }

            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it


        when (it.itemId) {
            R.id.home -> {
                openHome()
                drawerLayout.closeDrawers()
            }

            R.id.favourites -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.frame,
                        FavouriteFragment()
                    )
                    .commit()

                supportActionBar?.title = "Favourites"
                drawerLayout.closeDrawers()
            }

            R.id.profile -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.frame,
                        MyProfileFragment()
                    )
                    .commit()

                supportActionBar?.title = "Profile"
                drawerLayout.closeDrawers()
            }

            R.id.faq -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.frame,
                        FaqsFragment()
                    )
                    .commit()

                supportActionBar?.title = "Faqs"
                drawerLayout.closeDrawers()

            }
            R.id.logout->{
                sharedPreferences.edit().clear().apply()
                val intent = Intent(this@MainActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()

            }

        }
        return@setNavigationItemSelectedListener true
    }
}
        fun setUpToolbar() {
            setSupportActionBar(toolbar)
            supportActionBar?.title = "Toolbar Title"
            supportActionBar?.setHomeButtonEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

        }
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            val id = item.itemId

            if (id == android.R.id.home) {
                drawerLayout.openDrawer(GravityCompat.START)
            }

            return super.onOptionsItemSelected(item)
        }

        fun openHome() {
            val fragment = HomeFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(
                R.id.frame,
                HomeFragment()
            )
            transaction.commit()
            supportActionBar?.title = "Home"

            navigationView.setCheckedItem(R.id.home)


        }

        override fun onBackPressed() {
            val frag = supportFragmentManager.findFragmentById(R.id.frame)

            when(frag)
            {
                !is HomeFragment -> openHome()
                else -> super.onBackPressed()
            }
        }
}