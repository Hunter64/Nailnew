package com.example.nailnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toast
        fun showToast(){
            Toast.makeText(this, "Hello from the Toast!", Toast.LENGTH_LONG).show()
        }

        //SnackBar (2 examples)
        val layout = findViewById<ConstraintLayout>(R.id.constraint)
        fun showSnackBar1(){
            Snackbar.make(layout, "Hello from the SnackBar!", Snackbar.LENGTH_LONG).show()
        }

        fun showSnackBar2(){
            Snackbar.make(layout, "Hello from the SnackBar!", Snackbar.LENGTH_LONG).setAction("Undo Changes!"){
                Log.w(" -> SnackBar", "Add Function / Action here! for Click Undo Changes!")
                Snackbar.make(layout, "Action has been restored!", Snackbar.LENGTH_LONG).show()
            }.show()
        }

    }
}
