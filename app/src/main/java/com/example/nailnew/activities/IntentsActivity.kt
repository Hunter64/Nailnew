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
        //intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY // -> Don't save the activity's history into stack
        //intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION // -> Without animation
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Delete next activity or delete all activity stack with this last when we click back button we out app
        startActivity(intent)
        //finish() // - > Destroy this intent activity and not add to stack history
    }

    //Objects
    private fun goIntentObject(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        startActivity(intent)
    }
}
