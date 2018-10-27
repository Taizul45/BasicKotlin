package com.example.dday.firstkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.button2)
        btn.setOnClickListener {
            countMe()
        }


    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        val textBox=findViewById<TextView>(R.id.textView)
        val texts=textBox.text
        outState?.putCharSequence("saveText",texts);
        //Log.i(TAG, "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        val textBox=findViewById<TextView>(R.id.textView)
        val texts= savedInstanceState?.getCharSequence("saveText")
        textBox.text=texts.toString()

        //Log.i(TAG, "onRestoreInstanceState")
    }

    fun showMessage(v: View)
    {
        Toast.makeText(this@MainActivity,"This is a Toast message",Toast.LENGTH_SHORT).show()
    }

    private fun countMe()
    {
        val showCountTextView = findViewById<TextView>(R.id.textView)
        val countString = showCountTextView.text.toString()
        var count: Int = Integer.parseInt(countString)
        count++
        showCountTextView.text = count.toString()
    }

    fun showRandom(v:View)
    {
        val showCountTextView = findViewById<TextView>(R.id.textView)
        val randomDouble = Math.random()
        showCountTextView.text=randomDouble.toString();

    }
}
