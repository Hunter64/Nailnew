package com.example.nailnew.activities

import android.os.Bundle
import com.example.nailnew.R

class LifeCycleActivity : LifeCycleEventsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }

}
