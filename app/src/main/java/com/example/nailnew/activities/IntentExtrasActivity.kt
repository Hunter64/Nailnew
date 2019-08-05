package com.example.nailnew.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.nailnew.R
import kotlinx.android.synthetic.main.activity_intent_extras.*

class IntentExtrasActivity : AppCompatActivity() {
//In this activity, we receive values from intents activity and show in the text view and checkbox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)

        buttonBack.setOnClickListener { startActivity(Intent(this, IntentsActivity::class.java)) }// -> Back to IntentsActivity from this Intent Extras Activity
        // When we use button back this destroy the activity that using in this moment, we don't want destroy this, only add back stack with this button back

        getIntentExtrasFromPreviousActivity()
    }

    private fun getIntentExtrasFromPreviousActivity(){
        //Here receive values from intents activity
        val name = intent.getStringExtra("name") // -> name from getStringExtra is nullable, so is String? type
        val lastName = intent.getStringExtra("lastName") // -> lastName from getStringExtra is nullable, so is String? type, same case than name
        val age = intent.getIntExtra("age", 0) // -> age is not null, because is getIntExtra, maybe the key age is not found, so we should pass a default value to back this
        val developer = intent.getBooleanExtra("developer", false) // -> same case than age value but in boolean

        if(name != null && lastName != null && age >= 0){
            //Pass vale to objects values in layout
            textViewName.text = name
            textViewLastName.text = lastName
            //textViewAge.text = age.toString()
            textViewAge.text = "$age"
            checkBoxDeveloper.text = "Developer"
            checkBoxDeveloper.isChecked = developer
        }else{
            checkBoxDeveloper.visibility = View.INVISIBLE

        }
    }

}
