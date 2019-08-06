package com.example.nailnew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.nailnew.activities.*
import com.example.nailnew.others.ToolbarActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolbarActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toast
//        fun showToast() {
//            Toast.makeText(this, "Hello from the Toast!", Toast.LENGTH_LONG).show()
//        }

        //SnackBar (2 examples)
//        val layout = findViewById<ConstraintLayout>(R.id.constraint)
//        fun showSnackBar1() {
//            Snackbar.make(layout, "Hello from the SnackBar!", Snackbar.LENGTH_LONG).show()
//        }
//
//        fun showSnackBar2() {
//            Snackbar.make(layout, "Hello from the SnackBar!", Snackbar.LENGTH_LONG).setAction("Undo Changes!") {
//                Log.w(" -> SnackBar", "Add Function / Action here! for Click Undo Changes!")
//                Snackbar.make(layout, "Action has been restored!", Snackbar.LENGTH_LONG).show()
//            }.show()
//        }

        // Add toolbar in top app menu
        toolbarToLoad(toolbar as androidx.appcompat.widget.Toolbar)

        //Variables to buttons
        val btnLifeCycle = findViewById<Button>(R.id.button_to_cycle)
        val btnClickEvents = findViewById<Button>(R.id.button_to_click)
        val btnAndroidExtension = findViewById<Button>(R.id.button_to_android_extensions)
        val btnPicasso = findViewById<Button>(R.id.button_to_picasso)
        val btnListView = findViewById<Button>(R.id.button_to_list_view)
        val btnIntents = findViewById<Button>(R.id.button_to_intents)
        val btnPermission = findViewById<Button>(R.id.button_to_permissions)
        val btnSharedPreferences = findViewById<Button>(R.id.button_to_shared_preferences)
        val btnExtensionFunctions = findViewById<Button>(R.id.button_to_extension_functions)

        btnLifeCycle.setOnClickListener { goToLifeCycleActivity() }
        btnClickEvents.setOnClickListener { goToClickEventsActivity() }
        btnAndroidExtension.setOnClickListener { goToKotlinAndroidExtensionActivity() }
        btnPicasso.setOnClickListener { goToPicassoActivity() }
        btnListView.setOnClickListener { goToListViewActivity() }
        btnIntents.setOnClickListener { goToIntentsActivity() }
        btnPermission.setOnClickListener { goToPermissionsActivity() }
        btnSharedPreferences.setOnClickListener { goToSharedPreferencesActivity() }
        btnExtensionFunctions.setOnClickListener { goToExtensionFunctionsActivity() }
    }

    //functions to buttons with structure complete
    private fun goToLifeCycleActivityStructure() {
        val intent = Intent(this, LifeCycleActivity::class.java)
        startActivity(intent)
    }

    ////Functions Online
    private fun goToLifeCycleActivity() = startActivity(Intent(this, LifeCycleActivity::class.java))

    private fun goToClickEventsActivity() = startActivity(Intent(this, ClickEventsActivity::class.java))

    private fun goToKotlinAndroidExtensionActivity() = startActivity(Intent(this, KotlinAndroidExtensionActivity::class.java))

    private fun goToPicassoActivity() = startActivity(Intent(this, PicassoActivity::class.java))

    private fun goToListViewActivity() = startActivity(Intent(this, ListViewActivity::class.java))

    private fun goToIntentsActivity() = startActivity(Intent(this, IntentsActivity::class.java))

    private fun goToPermissionsActivity() = startActivity(Intent(this, PermissionsActivity::class.java))

    private fun goToSharedPreferencesActivity() = startActivity(Intent(this, SharedPreferencesActivity::class.java))

    private fun goToExtensionFunctionsActivity() = startActivity(Intent(this, ExtensionFunctionsActivity::class.java))

}
