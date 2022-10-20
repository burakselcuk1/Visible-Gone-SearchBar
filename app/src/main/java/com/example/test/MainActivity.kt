package com.example.test

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickHandler()

    }

    private fun clickHandler() {

        with(binding){
            search.setOnClickListener {
                burakToolbar.visibility = View.GONE
                editText.visibility = View.VISIBLE
                editText.showSoftInputOnFocus = true
                search.visibility = View.GONE
                cancel.visibility = View.VISIBLE
            }
            cancel.setOnClickListener {
                burakToolbar.visibility = View.VISIBLE
                editText.visibility = View.GONE
                editText.showSoftInputOnFocus = true
                search.visibility = View.VISIBLE
                cancel.visibility = View.GONE
                cancel.hideKeyboard()
            }
        }
    }

    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}