package com.example.nailnew.app

import android.app.Application
import com.example.nailnew.others.MySharedPreferences

val preferences: MySharedPreferences by lazy { MyApp.prefs!! } // this variable is created out of class, this is global access, in any activity we can access to this variable, use "by lazy" if not use this preferences,
    // the code between brackets never is run, lazy load, when preferences variable is run, the code into brackets is run only time
    // if we put !! in prefs is because we sure that isn't null

class MyApp : Application(){
    //Application is android class extends Context wrapper, so all apps android, pass first by this application file and after launch the first activity
    //If we over write this application, We can put logic before the app is launched and the first activity is showed, so this is here
    //Only need for this is write in manifest, implements of this MyApp class than extends Application

    companion object{
        var prefs: MySharedPreferences? = null
    }

    override fun onCreate() {
        super.onCreate()
        prefs = MySharedPreferences(applicationContext)
    }

}