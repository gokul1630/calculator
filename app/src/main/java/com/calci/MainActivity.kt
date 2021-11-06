package com.calci

import android.os.Bundle
import android.util.Log
import android.widget.HorizontalScrollView
import androidx.appcompat.app.AppCompatActivity
import com.calci.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            tv0.setOnClickListener { appendString("0") }
            tv1.setOnClickListener { appendString("1") }
            tv2.setOnClickListener { appendString("2") }
            tv3.setOnClickListener { appendString("3") }
            tv4.setOnClickListener { appendString("4") }
            tv5.setOnClickListener { appendString("5") }
            tv6.setOnClickListener { appendString("6") }
            tv7.setOnClickListener { appendString("7") }
            tv8.setOnClickListener { appendString("8") }
            tv9.setOnClickListener { appendString("9") }
            startBracket.setOnClickListener { appendString("(") }
            endBracket.setOnClickListener { appendOperator(")") }
            add.setOnClickListener { appendOperator("+") }
            sub.setOnClickListener { appendOperator("-") }
            tvDot.setOnClickListener { appendOperator(".") }
            clear.setOnClickListener { appendString("", true) }
            divide.setOnClickListener { appendOperator("/") }
            multiply.setOnClickListener { appendOperator("*") }
            modulus.setOnClickListener { appendOperator("%") }
            back.setOnClickListener {
                val trim = calculation.text
                if (trim.isNotEmpty()) {
                    appendString("", true)
                    calculation.text = trim.substring(0, trim.length - 1)
                }
            }

        }
    }

    private fun appendOperator(operator: String) {
        val text = binding.calculation.text
        if (text.isNotEmpty() && text.substring(text.length - 1) != operator) {
            appendString(operator)
        }
    }

    private fun appendString(text: String, isClear: Boolean = false) {
        binding.apply {
            if (isClear) {
                calculation.text = ""
                answer.text = ""
            } else {
                calculation.append(text)
                calculationScroll.postDelayed({
                    calculationScroll.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
                }, 0)
            }
            try {
                val exp = ExpressionBuilder(calculation.text.toString()).build()
                val result = exp.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    answer.text = longResult.toString()
                } else {
                    answer.text = result.toString()
                }
            } catch (error: Exception) {
                Log.d("CALCULATION_ERROR", error.message.toString())
            }
        }

    }
}