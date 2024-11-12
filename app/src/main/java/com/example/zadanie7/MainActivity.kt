package com.example.zadanie7

import android.content.Intent
import android.widget.Toast
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zadanie7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declare binding as lateinit
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up button to open second activity
        binding.btnOpenSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Set up button to create an email
        binding.btnCreateEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SEND).apply {
                type = "message/rfc822" // Restrict to email apps only
                putExtra(Intent.EXTRA_EMAIL, arrayOf("your-email@example.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Nowa wiadomość e-mail")
                putExtra(Intent.EXTRA_TEXT, "To jest kontent nowej wiadomości e-mail")
            }
            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(emailIntent)
            } else {
                Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
