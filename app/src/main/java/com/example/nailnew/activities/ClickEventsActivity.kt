package com.example.nailnew.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.nailnew.R

class ClickEventsActivity : AppCompatActivity(), View.OnLongClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_events)

        //Call here the function ClickInLine to register this
        clickInLine()


        //Multiline, we need import View.OnLongClickListener and override onLongClick function
        //Call here the functions Multiline to register this
        val btn1 = findViewById<Button>(R.id.buttonClickMulti1)
        val btn2 = findViewById<Button>(R.id.buttonClickMulti2)
        val btn3 = findViewById<Button>(R.id.buttonClickMulti3)

        //This functions use with long click (hold)
        btn1.setOnLongClickListener(this)
        btn2.setOnLongClickListener(this)
        btn3.setOnLongClickListener(this)
    }

    //Click XML
    //Obligatory rule to click in xml
    //The function should be public, the names should be same than file class and xml file and this receive only one parameter (View)
//    fun xmlClick(view: View){
//        Toast.makeText(this, "Click by XML!", Toast.LENGTH_SHORT).show()
//    }

    //Click InLine
    private fun clickInLine(){
        val btn = findViewById<Button>(R.id.buttonClickInLine)
        btn.setOnClickListener { Toast.makeText(this, "Click In Line!", Toast.LENGTH_SHORT).show() } //-> Expression lambda without access to view, this is configured there
        //btn.setOnClickListener { Toast.makeText(this, "Click In Line! $it", Toast.LENGTH_SHORT).show() } //-> With "it" property, we can have access to view
        //btn.setOnClickListener { View -> Toast.makeText(this, "Click In Line!", Toast.LENGTH_SHORT).show() } //-> Another form to we can have access to view is with View and expression lambda before Toast
        //btn.setOnClickListener { _ ->Toast.makeText(this, "Click In Line!", Toast.LENGTH_SHORT).show() } //-> Remember that with expression previous, we can change "View" to "_" if this is not use
    }

    //Click by Id's in When for multiline
    override fun onLongClick(view: View): Boolean {
        when(view.id) { //This is switch instruction, down is his options
            R.id.buttonClickMulti1 -> Toast.makeText(this, "Click Multi 1!", Toast.LENGTH_SHORT).show()
            R.id.buttonClickMulti2 -> Toast.makeText(this, "Click Multi 2!", Toast.LENGTH_SHORT).show()
            R.id.buttonClickMulti3 -> Toast.makeText(this, "Click Multi 3!", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
