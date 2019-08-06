package com.example.nailnew.activities

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.nailnew.R
import kotlinx.android.synthetic.main.activity_permissions.*

class PermissionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)

        buttonPicture.setOnClickListener { getPictureFromCameraAskingPermissions() }
    }

    private fun getPictureFromCameraAskingPermissions() {
        //Add permission to android manifest file
        //Test camera permission's
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            //Accepted or Granted -> 0 And Denied -> -1, this is Package Manager file
            //if permission is not accepted previously, (Version Android 6.0 API 23 or superior, this is for runtime permissions)
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 100) // -> Here ask for permission to camera, with array of into manifest, we can add more permission in array, and finally add a relay (100)
        }
        else{
            //If permission is accepted previously and include to version previous to Android 6.0 or API 23, because this is accepted in installation time, and if is run in local this is auto accepted
            //Here put the intent and action to camera
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        //Answer to question for permission camera, accepted or not accepted this will evaluate his answer here
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
