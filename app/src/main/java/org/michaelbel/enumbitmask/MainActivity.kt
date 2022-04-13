package org.michaelbel.enumbitmask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.michaelbel.enumbitmask.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // See BitMaskUnitTest class
    }
}