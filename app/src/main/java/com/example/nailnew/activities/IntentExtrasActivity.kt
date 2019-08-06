package com.example.nailnew.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.nailnew.R
import com.example.nailnew.models.Student
import com.example.nailnew.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intent_extras.*

class IntentExtrasActivity : ToolbarActivity() {
//In this activity, we receive values from intents activity and show in the text view and checkbox

    //Access to layout toolbar
    //private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)

        //new toolbar
        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true) //the behaviors is a manifest file

        //toolbar = findViewById(R.id.toolbar)
        //setSupportActionBar(toolbar)

        buttonBack.setOnClickListener { startActivity(Intent(this, IntentsActivity::class.java)) }// -> Back to IntentsActivity from this Intent Extras Activity
        // When we use button back this destroy the activity that using in this moment, we don't want destroy this, only add back stack with this button back

        //toolbar
        val isExtraSet = setIntentExtrasFromPreviousActivity()
        val isParcelableSet =  setParcelableExtraFromPreviousActivity()
        // Arrow return to main, if this function is shadow is nullable, with double exclamation we know that never is it null
        //supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if(!isExtraSet && !isParcelableSet){
            //Here validate if extra and parcelable is false the checkbox is invisible
            //This show in extra and object intents but not in flags
            checkBoxDeveloper.visibility = View.INVISIBLE
        }
    }

    private fun setParcelableExtraFromPreviousActivity(): Boolean{
        val student = intent.getParcelableExtra<Student>("student") // The key is "student", this is for intent for objects
        //if(student != null){ // This conditional is same than this -> student?.let { }
        student?.let {
            textViewName.text = student.name
            textViewLastName.text = student.lastName
            textViewAge.text = student.age.toString()
            checkBoxDeveloper.text = "Developer"
            checkBoxDeveloper.isChecked = student.isDeveloper
            return true
        }
        return false
    }

    private fun setIntentExtrasFromPreviousActivity(): Boolean{
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
            return true
        }
        return false
    }

}
