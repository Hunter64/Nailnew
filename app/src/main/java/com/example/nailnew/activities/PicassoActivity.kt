package com.example.nailnew.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.nailnew.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picasso.*

class PicassoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)

        //NOTE FOR THIS

        //1.- To see where is load this file in picasso.with() function is next
        //Menu -> View -> Tool Windows -> Device File Explorer -> in folders and file search data folder -> data folder ->
        //In this location, we could search our package android's of project for example "com.example.nail new", after run this activity and could synchronized the cache folder
        //we should see a picasso-cache folder and a journal file created by defect

        //2.- With the image there aren't anything created, because we intent access to path of internet and our app don´t have permissions
        // for can this we should give permissions to app, in manifest android xml file, we add his permissions with next line
        //<uses-permission android:name="android.permission.INTERNET"></uses-permission>

        //Call private function loadImages()
        buttonLoader.setOnClickListener { loadImages() }

        //Examples how receive images to url internet
        //With fetch, this help us to make pre catch of images previous render this
        Picasso.with(this).load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg").fetch()

        Log.w("---------> Title w", "arrive to here! after Picasso!!! ")
    }

    //Examples how receive images to url internet, using cache, thread and memory
    private fun loadImages(){
        Log.w("---------> Title w", "Loading first image!!! ")
        Picasso
            .with(this)
            .load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg")
            //.fit() // -> take all box of Image View
            .resize(300,300) // -> Render image (modified resolution) not use fit()
            //.centerInside() // -> Only align center, we can't use this combined to centerCrop, is one to time
            .centerCrop() // -> Align center a crop image to side
            .into(imageViewTop) // -> ImageView to use

//        Log.w("---------> Title w", "Loading second image!!! ")
//        Picasso
//            .with(this)
//            .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
//            .fit()
//            .into(imageViewBottom)


        //Render image in circle
//        Picasso
//            .with(this)
//            .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
//            .fit()
//            .transform(CircleTransform()) // -> Render image to circle form, this with help Circle Transform java class file
//            .into(imageViewBottom)


        //Add animation fade to image
        val context: Context = this
        Picasso
            .with(this)
            .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
            .fetch(object: Callback{ // -> This is callback function Picasso's
                override fun onSuccess() {
                    imageViewBottom.alpha = 0f // -> Make transparent or invisible
                    Picasso.with(context) // -> Load in ImageView
                        .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
                        .fit()
                        .into(imageViewBottom)
                    imageViewBottom.animate() //-> Animate
                        .setDuration(300) // -> Time to back visible
                        .alpha(1f) // -> Back visible
                        .start()
                }

                override fun onError() {
                    //For error case
                }

            })

    }
}
