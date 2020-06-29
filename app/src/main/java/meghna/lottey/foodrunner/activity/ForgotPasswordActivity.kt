package meghna.lottey.foodrunner.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import meghna.lottey.foodrunner.R

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var editMobile :EditText
    lateinit var editEmail :EditText
    lateinit var btnNext :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        editEmail = findViewById(R.id.editEmail)
        editMobile = findViewById(R.id.editMobile)
        btnNext = findViewById(R.id.btnNext)

        btnNext.setOnClickListener {
            var intent = Intent(this@ForgotPasswordActivity,ForgotDisplayActivity::class.java)
            intent.putExtra("mobile",editMobile.text.toString())
            intent.putExtra("email" ,editEmail.text.toString())
            startActivity(intent)
        }
    }
}