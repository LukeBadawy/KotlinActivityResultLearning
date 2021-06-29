package com.example.activityforresultlearning

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.example.activityforresultlearning.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val logTAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val NAME = "name"
        const val EMAIL = "email"
    }

    private val getFirstActivityResult =
        registerForActivityResult(StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                binding.tvFirstActivityResult.text = "First activity result success"
            } else if (result.resultCode == Activity.RESULT_CANCELED) {
                Log.e(logTAG, "firstActivityWasCancelled")
                Toast.makeText(this@MainActivity, "First activity cancelled", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    private val getSecondActivityResult =
        registerForActivityResult(StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                if (result.data != null) {
                    val usersName = result.data!!.getStringExtra(NAME)
                    val usersEmail = result.data!!.getStringExtra(EMAIL)
                    binding.tvSecondActivityResult.text = "Name: $usersName \nEmail: $usersEmail"
                }

            } else if (result.resultCode == Activity.RESULT_CANCELED) {
                Log.e(logTAG, "secondActivityWasCancelled")
                Toast.makeText(this@MainActivity, "Second activity cancelled", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLaunchActivityFirst.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            getFirstActivityResult.launch(intent)
        }

        binding.btnLaunchActivitySecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            getSecondActivityResult.launch(intent)
        }
    }
}