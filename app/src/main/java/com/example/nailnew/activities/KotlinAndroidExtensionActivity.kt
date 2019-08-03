package com.example.nailnew.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.nailnew.R
import kotlinx.android.synthetic.main.activity_kotlin_android_extension.* //Load all have in layout "activity kotlin android extension",
// when import this, we no need use findById any more, because we call the buttons directly with his name, that is same name by Id, without need cast this is very cool :D... I like this!!

class KotlinAndroidExtensionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_android_extension)


        //This form is using find view by id
        val btn = findViewById<Button>(R.id.buttonById)
        btn.setOnClickListener { Toast.makeText(this, "Click by Id", Toast.LENGTH_SHORT).show() }


        //This form we can access to buttons, layouts, and any element that stay with a id in activity kotlin android extension file xml, thanks to the "kotlin android extensions", putting the same name to Id,
        //with this form don't need the "find by Id" any more
        buttonById.setOnClickListener { Toast.makeText(this, "Click by Id!", Toast.LENGTH_SHORT).show() }  //-> ButtonById from activity_kotlin_android_extension.xml
        buttonByKAT.setOnClickListener { Toast.makeText(this, "Click by KAT", Toast.LENGTH_SHORT).show() } //-> ButtonBy KAT from activity_kotlin_android_extension.xml
    }
}
