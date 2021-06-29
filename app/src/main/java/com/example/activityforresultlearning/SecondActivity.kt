package com.example.activityforresultlearning

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityforresultlearning.databinding.ActivityMainBinding
import com.example.activityforresultlearning.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener{
            val intent = Intent()
            intent.putExtra(MainActivity.NAME, binding.etName.text.toString())
            intent.putExtra(MainActivity.EMAIL, binding.etEmail.text.toString())

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}