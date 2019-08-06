package com.example.nailnew.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nailnew.R
import com.example.nailnew.app.preferences

class SharedPreferencesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        // Here we call to preferences in MyApp file class
        // This is very potential, because now we go any activity and call this preference, without open file or write instance is like a global variable
        preferences.name
    }
}
