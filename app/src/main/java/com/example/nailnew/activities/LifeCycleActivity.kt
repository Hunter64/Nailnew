package com.example.nailnew.activities

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.nailnew.R
import com.example.nailnew.others.LifeCycleEventsActivity

class LifeCycleActivity : LifeCycleEventsActivity() {

    private var exitEnabled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }

    override fun onBackPressed() {
        //This is the button back arrow... Here call to father
        //super.onBackPressed() //If we delete this line, the back button is disabled

        if(exitEnabled)
            super.onBackPressed()

        exitEnabled = true
        Toast.makeText(this, "Click again to exit this screen!", Toast.LENGTH_LONG).show()
        Handler().postDelayed(Runnable { exitEnabled = false }, 2000)
    }

}