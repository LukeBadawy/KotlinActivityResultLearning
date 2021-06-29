package com.example.activityforresultlearning

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityforresultlearning.databinding.ActivityFirstBinding
import com.example.activityforresultlearning.databinding.ActivityMainBinding

class FirstActivity : AppCompatActivity() {
    private val logTAG = "FirstActivity"
    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFinish.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}