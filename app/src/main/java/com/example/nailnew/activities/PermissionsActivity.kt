package com.example.nailnew.activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.nailnew.R
import kotlinx.android.synthetic.main.activity_permissions.*

class PermissionsActivity : AppCompatActivity() {

    private val requestCameraPermission = 100 //This value isn't important, but this should be same than receive for comparison
    private val requestCameraPicture = 200 //This value isn't important, but this should be same than receive for comparison

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)

        //buttonPicture.setOnClickListener { getPictureFromCameraAskingPermissions() } // -> Invoke take a photo with permission
        buttonPicture.setOnClickListener { getPictureFromCameraWithoutAskPermissions() } // -> Invoke take a photo without permission
    }

    //Take a photo without permission
    private fun getPictureFromCameraWithoutAskPermissions() {
        //The rest of permission is inevitable, this use the intent of camera because we pass without permission
        //Sure that aren't permissions of camera in manifest, if they exist, the app will crash
        //Create intent to take a photo
        val pictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        //Check that we can use the capture of photo (we have camera and his app)
        if(pictureIntent.resolveActivity(packageManager) != null){
            //Ok, we have camera and his app
            startActivityForResult(pictureIntent, requestCameraPicture)
        }else{
            //Ok, we not have camera and his app, so isn't activity to manager this intent
            Toast.makeText(this, "App camera isn't exist!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getPictureFromCameraAskingPermissions() {
        //Add permission to android manifest file
        //Test camera permission's
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            //Accepted or Granted -> 0 And Denied -> -1, this is Package Manager file
            //if permission is not accepted previously, (Version Android 6.0 API 23 or superior, this is for runtime permissions)
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), requestCameraPermission) // -> Here ask for permission to camera, with array of into manifest, we can add more permission in array, and finally add a relay (100)
        }
        else{
            //If permission is accepted previously and include to version previous to Android 6.0 or API 23, because this is accepted in installation time, and if is run in local this is auto accepted
            //Here put the intent and action to camera
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, requestCameraPicture) //This is a open camera app, take a picture and back our app with this pic, this need a code than relay
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        //Answer to question for permission camera, accepted or not accepted this will evaluate his answer here
        when (requestCode){ //Switch in requestCode
            requestCameraPermission -> {
                //Accept or denied with grantResult, that is array of Permissions, so we can ask so much permissions at time
                if(grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //If the array of Permission is length = 1 and this only value is granted, make next
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE) // -> Intent to access to camera (the camera is activity)
                    startActivityForResult(intent, requestCameraPicture) //This is a open camera app, take a picture and back our app with this pic, this need a code than relay
                }
                else{
                    //Denied
                    Toast.makeText(this, "You can't take a picture if you don't allow it", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode){
            requestCameraPicture ->{
                //Check result is good
                if(resultCode == Activity.RESULT_OK){
                    //This is good, get us extras of intent received by parameters, in data is picture
                    val extras = data!!.extras //data can be nullable, but in this case is Ok
                    //Armed bitmap from extras
                    val imageBitMap = extras!!.get("data") as Bitmap
                    //Load picture as bitmap in imageView
                    imageViewPicture.setImageBitmap(imageBitMap)
                }
                else{
                    //the photo was not taken successfully
                    Toast.makeText(this, "Picture has failed!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
