package com.calci

import android.os.Bundle
import android.util.Log
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
        binding.tv0.setOnClickListener { appendString("0", false) }
        binding.tv1.setOnClickListener { appendString("1", false) }
        binding.tv2.setOnClickListener { appendString("2", false) }
        binding.tv3.setOnClickListener { appendString("3", false) }
        binding.tv4.setOnClickListener { appendString("4", false) }
        binding.tv5.setOnClickListener { appendString("5", false) }
        binding.tv6.setOnClickListener { appendString("6", false) }
        binding.tv7.setOnClickListener { appendString("7", false) }
        binding.tv8.setOnClickListener { appendString("8", false) }
        binding.tv9.setOnClickListener { appendString("9", false) }
        binding.startBracket.setOnClickListener { appendString("(", false) }
        binding.endBracket.setOnClickListener { appendString(")", false) }
        binding.add.setOnClickListener { appendString("+", false) }
        binding.sub.setOnClickListener { appendString("-", false) }
        binding.divide.setOnClickListener {
            if(binding.calculation.text.isNotEmpty()){
                appendString("/", false)
            }
        }

        binding.multiply.setOnClickListener {
            if(binding.calculation.text.isNotEmpty()){
            appendString("*", false)
            }
        }

        binding.tvDot.setOnClickListener { appendString(".", false) }
        binding.clear.setOnClickListener { appendString("", true) }
        binding.back.setOnClickListener {
            val trim = binding.calculation.text
            if (trim.isNotEmpty()) {
                appendString("",true)
                binding.calculation.text = trim.substring(0, trim.length - 1)
            }
        }

        binding.equals.setOnClickListener {
            try {
                val exp = ExpressionBuilder(binding.calculation.text.toString()).build()
                val result = exp.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    binding.answer.text = longResult.toString()
                    Log.w("result", "if == $longResult")
                } else {
                    binding.answer.text = result.toString()
                    Log.w("result", "else == $result")
                }
            }catch(e:Exception){
                Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun appendString(text:String,isClear:Boolean) {
        if (isClear) {
            binding.calculation.text = ""
            binding.answer.text = ""
        } else{
            binding.calculation.append(text)
        }
    }
}