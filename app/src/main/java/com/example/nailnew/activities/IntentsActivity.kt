package com.example.nailnew.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nailnew.R
import kotlinx.android.synthetic.main.activity_intents.*

class IntentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)

        buttonIntentExtras.setOnClickListener { goIntentExtras() }
        buttonIntentFlags.setOnClickListener { goIntentFlags() }
        buttonIntentObject.setOnClickListener { goIntentObject() }
    }

    //Extras
    private fun goIntentExtras(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        intent.putExtra("name", "Victor")
        intent.putExtra("lastName", "Abc")
        intent.putExtra("age", 45)
        intent.putExtra("developer", true)
        startActivity(intent)
    }

    //Flags
    private fun goIntentFlags(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        startActivity(intent)
    }

    //Objects
    private fun goIntentObject(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        startActivity(intent)
    }
}
