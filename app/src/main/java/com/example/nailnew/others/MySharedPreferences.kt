package com.example.nailnew.others

import android.content.Context

class MySharedPreferences (context: Context){
    //Using Shared Preferences with Kotlin

    //file's name of shared preferences
    private val fileName = "my_preferences"

    //instance to file
    private val prefs = context.getSharedPreferences(fileName, Context.MODE_PRIVATE) // -> mode private to only our app can read this

    //foreach variable that save in our file "shared preferences"
    var name: String? // -> When we called our Shared Preferences, this last call name variable's and access to name get and set
        // -> With this over write set and get we reduce risk to fail, because we use name in get and set and call the variable name, (in get and set, we put name like string (hardcoding this, is risk))
        get() = prefs.getString("name", "") //Over write get, save with value "name" and value by default than empty string
        set(value) = prefs.edit().putString("name", value).apply() //Override set and configure, with name and apply, also have commit, but we use always apply

    //Now add a integer variable's in our shared preferences, and for each variable that we need in our shared preferences file, we over write here with this method (get and set)
    var age: Int
        get() = prefs.getInt("age", -1)
        set(value) = prefs.edit().putInt("age", value).apply()
}