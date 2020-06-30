package meghna.lottey.foodrunner.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import meghna.lottey.foodrunner.R

class LoginActivity : AppCompatActivity() {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView

    lateinit var sharedPreferences: SharedPreferences

    val validMobileNumber = "0123456789"
    val validPassword="bruce"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        title = "Log In"

        sharedPreferences =
            getSharedPreferences("Restraunt preferences",Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)

        if(isLoggedIn){
         val intent = Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
           finish()
  }

        title = "Log in"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)

        btnLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()

            if(validMobileNumber ==etMobileNumber.text.toString() && validPassword == etPassword.text.toString()) {
                  val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.putExtra("mobile", etMobileNumber.text.toString())
                    startActivity(intent)
                   var mobile =etMobileNumber.text.toString()
                   savePreferences(mobile)
                }

            else
            {
                Toast.makeText(this@LoginActivity,"Wrong credentials",Toast.LENGTH_SHORT).show()
            }

        }

        txtForgotPassword.setOnClickListener {
            var intent = Intent(this@LoginActivity,ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        txtRegister.setOnClickListener {
            val intent = Intent(this@LoginActivity,
                RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(mobile:String) {

        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("mobile",mobile).apply()

    }
}