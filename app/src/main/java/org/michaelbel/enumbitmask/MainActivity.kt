package org.michaelbel.enumbitmask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.properties.Delegates
import kotlin.properties.Delegates.notNull
import org.michaelbel.enumbitmask.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity(R.layout.activity_main) {

    private var binding: ActivityMainBinding by notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // See BitMaskUnitTest class
    }
}