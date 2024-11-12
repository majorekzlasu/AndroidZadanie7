package com.example.zadanie7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zadanie7.databinding.Activity2Binding

class SecondActivity : AppCompatActivity() {

    // Declare binding as lateinit
    private lateinit var binding: Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
