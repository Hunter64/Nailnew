package com.example.nailnew.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nailnew.MainActivity
import com.example.nailnew.R
import com.example.nailnew.others.*
import kotlinx.android.synthetic.main.activity_extension_functions.*

class ExtensionFunctionsActivity : AppCompatActivity() {
    //The extensions function is very powerful, only check this next exercises

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_functions)

        var numberRandom = (-10..10).random()

        buttonToast.setOnClickListener { if(numberRandom.isNatural()) toast("$numberRandom is Natural Number!!") else toast("$numberRandom isn't Natural Number!!") } //-> //Test boolean is natural extension function with extension toast function
                                                // -> Test toast extension function, here pass a simple string (quote marks) also pass string from string file's
                                                //toast(getString(R.string.extensions_toast)) || buttonToast.setOnClickListener { toast(R.string.extensions_toast) }  //, this because in library receive string or id to string of resource


        buttonSnackBar.setOnClickListener { snackBar("I love extension function!", action = "Undo") { toast("Undo!!!") } }
        buttonLoadByUrl.setOnClickListener { imageViewLoadedByUrl.loadByUrl("https://udemy-images.udemy.com/course/480x270/1325930_f5f6_3.jpg") }
        //buttonGoToActivity.setOnClickListener { goToActivity<MainActivity> { putExtra("id", 1)} } // -> This is intent with extras
        buttonGoToActivity.setOnClickListener { goToActivity<MainActivity> { }} // -> This is intent without extras
    }
}
