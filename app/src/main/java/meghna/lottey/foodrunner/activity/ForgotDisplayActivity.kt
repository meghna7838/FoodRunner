package meghna.lottey.foodrunner.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import meghna.lottey.foodrunner.R

class ForgotDisplayActivity : AppCompatActivity() {
    lateinit var txtEmail : TextView
    lateinit var txtMobile : TextView
    lateinit var txtWelcome : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_display)

        txtEmail = findViewById(R.id.txtEmail)
        txtMobile = findViewById(R.id.txtMobile)
        txtWelcome = findViewById(R.id.txtWelcome)

        if(intent!=null)
        {
            txtEmail.text = intent.getStringExtra("email").toString()
            txtMobile.text = intent.getStringExtra("mobile").toString()
        }
    }
}