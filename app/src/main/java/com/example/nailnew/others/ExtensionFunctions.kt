package com.example.nailnew.others

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.example.nailnew.R
import com.squareup.picasso.Picasso

fun Int.isNatural() = this >= 0 //-> Natural numbers, condition return true or false, "this" is reference of context


fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, duration).show() // -> Toast that receive msg and duration, if duration isn't take duration by default that is length short,
                                                                                                    // "this" is reference into context of activity

fun Activity.toast(resourceId: Int, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, resourceId, duration).show() //-> This is for use string of string file's in values folder's, that is int for id of string


fun Activity.snackBar(message: CharSequence, view: View? = findViewById(R.id.container), duration: Int = Snackbar.LENGTH_SHORT, action: String? = null, actionEvt: (v: View) -> Unit = {}){
    if(view != null){
        val snackBar = Snackbar.make(view, message, duration) //if check with view != null isn't, we should put view with !! to didn't run this -> view!!
        if(!action.isNullOrEmpty()){
            snackBar.setAction(action, actionEvt)
        }
        snackBar.show()
    }
}


fun ViewGroup.inflate(layoutId: Int) = LayoutInflater.from(context).inflate(layoutId,this,false)!!


fun ImageView.loadByUrl(url: String) = Picasso.with(context).load(url).into(this)


inline fun <reified T:Activity> Activity.goToActivity(noinline init: Intent.() -> Unit = {}){ //Callback of intent restricted, by default this empty intent
    val intent = Intent(this, T::class.java) //for use this function we should put reified in T for use generic
    //inline -> don't create a function, so compile code and render
    intent.init()
    startActivity(intent)
}

//Go activity with result
fun Activity.goToActivityResult(action: String, requestCode: Int, init: Intent.() -> Unit = {}){
    //val intent(MediaStore.ACTION_IMAGE_CAMERA)
    val intent = Intent(action)
    intent.init()
    startActivityForResult(intent, requestCode)
}

