package com.example.nailnew.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.nailnew.R
import com.example.nailnew.app.preferences
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        // Here we call to preferences in MyApp file class
        // This is very potential, because now we go any activity and call this preference, without open file or write instance is like a global variable
        //preferences.name

        //When we use many functions in a line, we can use ; for separate functions
        buttonSave.setOnClickListener { setValuesSharedPreferences(); cleanEditTexts(); getValuesSharedPreferences(); } // -> When click to button save, saved and clean this
        //When start this activity, we take values to shared preferences
        getValuesSharedPreferences()
    }

    private fun getValuesSharedPreferences() {
        //Catch data from Shared Preferences
        if(preferences.name!!.isNotEmpty() && preferences.age >= 0) //Remember that defect value for age is -1
            textViewSharedPreferences.text = "Welcome ${preferences.name}, your age is ${preferences.age}"

        else
            textViewSharedPreferences.text = "Hi. Please save your name and your age!"

    }

    private fun setValuesSharedPreferences() {
        //Take and save valid data in Shared Preferences
        if(editTextName.text.toString().isNotEmpty() && editTextAge.text.toString().isNotEmpty()){
            preferences.name = editTextName.text.toString()
            preferences.age = editTextAge.text.toString().toInt()
            Toast.makeText(this, "Value have been saved successfully", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Please fill the name and the age before saving!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun cleanEditTexts() {
        //Clean once is saved, it his 2 methods

        editTextName.text.clear()
        editTextAge.text.clear()

        //editTextName.setText("")
        //editTextAge.setText("")
    }

}
