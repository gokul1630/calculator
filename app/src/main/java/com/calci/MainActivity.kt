package com.calci

import android.os.Bundle
import android.util.Log
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.calci.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
        tv0.setOnClickListener { appendString("0", false) }
        tv1.setOnClickListener { appendString("1", false) }
        tv2.setOnClickListener { appendString("2", false) }
        tv3.setOnClickListener { appendString("3", false) }
        tv4.setOnClickListener { appendString("4", false) }
        tv5.setOnClickListener { appendString("5", false) }
        tv6.setOnClickListener { appendString("6", false) }
        tv7.setOnClickListener { appendString("7", false) }
        tv8.setOnClickListener { appendString("8", false) }
        tv9.setOnClickListener { appendString("9", false) }
        startBracket.setOnClickListener { appendOperator("(") }
        endBracket.setOnClickListener { appendOperator(")") }
        add.setOnClickListener { appendOperator("+") }
        sub.setOnClickListener { appendOperator("-") }
        tvDot.setOnClickListener { appendOperator(".") }
        clear.setOnClickListener { appendString("", true) }
        divide.setOnClickListener {
            if(calculation.text.isNotEmpty()){
                appendString("/", false)
            }
        }

        multiply.setOnClickListener {
            if(calculation.text.isNotEmpty()){
            appendString("*", false)
            }
        }


        back.setOnClickListener {
            val trim = calculation.text
            if (trim.isNotEmpty()) {
                appendString("",true)
                calculation.text = trim.substring(0, trim.length - 1)
            }
        }

        equals.setOnClickListener {
            try {
                val exp = ExpressionBuilder(calculation.text.toString()).build()
                val result = exp.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    answer.text = longResult.toString()
                    Log.w("result", "if == $longResult")
                } else {
                    answer.text = result.toString()
                    Log.w("result", "else == $result")
                }
            }catch(e:Exception){
                Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_SHORT).show()
            }
        }
    }
    }
    private fun appendOperator(operator:String){
        val text=binding.calculation.text
        if(text.isNotEmpty() && text.substring(text.length-1)!=operator){
            appendString(operator,false)
        }
    }
    private fun appendString(text:String,isClear:Boolean) {
        binding.apply {
            if (isClear) {
                calculation.text = ""
                answer.text = ""
            } else{
                calculation.append(text)
                calculationScroll.postDelayed({
                    calculationScroll.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
                },10)
            }
        }

    }
}