package meghna.lottey.foodrunner.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import fragment.HomeFragment
import meghna.lottey.foodrunner.R

class RegistrationActivity : AppCompatActivity() {
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var txtName:EditText
    lateinit var txtEmail:EditText
    lateinit var txtMobile:EditText
    lateinit var txtAddress:EditText
    lateinit var txtPassword:EditText
    lateinit var txtConfirmPassword:EditText
    lateinit var btnRegistration: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        txtName = findViewById(R.id.txtName)
        txtEmail = findViewById(R.id.txtEmail)
        txtMobile = findViewById(R.id.txtMobile)
        txtAddress = findViewById(R.id.txtAddress)
        txtPassword = findViewById(R.id.txtPassword)
        txtConfirmPassword = findViewById(R.id.txtConfirmPassword)
        btnRegistration = findViewById(R.id.btnRegistration)
        toolbar = findViewById(R.id.toolbar)
        setUpToolbar()

        toolbar.setNavigationIcon(resources.getDrawable(R.drawable.ic_back))
        toolbar.setNavigationOnClickListener {
                val intent = Intent(this@RegistrationActivity,
                    LoginActivity::class.java)
                startActivity(intent)
        }
        btnRegistration.setOnClickListener {
            val fragment= HomeFragment()
//            val transaction = supportFragmentManager.beginTransaction()
//                transaction.replace(
//                    R.id.frame,
//                    fragment
//                ).commit()
//            val intent = Intent(this@RegistrationActivity,RegistrationDisplayActivity::class.java)
//            intent.putExtra("name",txtName.text.toString())
//            intent.putExtra("email",txtEmail.text.toString())
//            intent.putExtra("mobile",txtMobile.text.toString())
//            intent.putExtra("address",txtAddress.text.toString())
//            startActivity(intent)
        }
        }

    override fun onPause() {
        finish()
        super.onPause()
    }

    fun setUpToolbar() {

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Register Yourself"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }



}