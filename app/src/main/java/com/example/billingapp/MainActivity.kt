package com.example.billingapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.billingapp.databinding.ActivityMainBinding
import java.math.RoundingMode
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRest.setOnClickListener {
            binding.inputResult.text = "0"
            binding.outputResult.text = "0"
        }
        binding.btnClear.setOnClickListener {
            binding.inputResult.text = ""
        }
//        getting the buttons to display
        binding.btn7.setOnClickListener {
            binding.inputResult.text = addInput("7")
            binding.outputResult.text = getResult().toString()
        }
        binding.btn8.setOnClickListener {
            binding.inputResult.text = addInput("8")
            binding.outputResult.text = getResult().toString()
        }
        binding.btn9.setOnClickListener {
            binding.inputResult.text = addInput("9")
            binding.outputResult.text = getResult().toString()
        }
        binding.btn4.setOnClickListener {
            binding.inputResult.text = addInput("4")
            binding.outputResult.text = getResult().toString()
        }
        binding.btn5.setOnClickListener {
            binding.inputResult.text = addInput("5")
            binding.outputResult.text = getResult().toString()
        }
        binding.btn6.setOnClickListener {
            binding.inputResult.text = addInput("6")
            binding.outputResult.text = getResult().toString()
        }
        binding.btn1.setOnClickListener {
            binding.inputResult.text = addInput("1")
            binding.outputResult.text = getResult().toString()
        }
        binding.btn2.setOnClickListener {
            binding.inputResult.text = addInput("2")
            binding.outputResult.text = getResult().toString()
        }
        binding.btn3.setOnClickListener {
            binding.inputResult.text = addInput("3")
            binding.outputResult.text = getResult().toString()
        }
        binding.zero0.setOnClickListener {
            binding.inputResult.text = addInput("00")
            binding.outputResult.text = getResult().toString()
        }
        binding.btn0.setOnClickListener {
            binding.inputResult.text = addInput("0")
            binding.outputResult.text = getResult().toString()
        }
        binding.btnDot.setOnClickListener {
            binding.inputResult.text = addInput(".")
        }

        binding.btnEqual.setOnClickListener {
            val inputtext = binding.inputResult.text
            if (inputtext.isNotEmpty()) {
                inputtext.toString().dropLast(inputtext.lastIndex)
            }

        }

    }

    private fun addInput(buttonValue: String): String {
        return "${binding.inputResult.text}$buttonValue"
    }

    private fun getResult(): Double {
        val inputText = binding.inputResult.text.toString().toDouble()
        return if (inputText == null || inputText == 0.0) {

            roundOffDecimal(0.0)
        } else {
            var result = inputText * 3.28084
            roundOffDecimal(result)
        }
    }

    private fun roundOffDecimal(number: Double): Double {
        val df = DecimalFormat("#.###")
        df.roundingMode = RoundingMode.CEILING
        return df.format(number).toDouble()
    }
}




