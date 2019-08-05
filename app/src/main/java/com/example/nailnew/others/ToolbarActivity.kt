package com.example.nailnew.others

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.nailnew.models.IToolbar

//Implements the IToolbar interface
open class ToolbarActivity : AppCompatActivity(), IToolbar {
    //here we use the toolbar, that implements this in others activities easily

    protected var _toolbar: Toolbar? = null

    override fun toolbarToLoad(toolbar: Toolbar?) {
        _toolbar = toolbar
        _toolbar?.let{
            //With let interrogative if not null make this next
            setSupportActionBar(_toolbar)
        }
    }

    override fun enableHomeDisplay(value: Boolean) {
        //Here if we pass a value true this is show and is false not show in this case we not pass false so don't call,
        supportActionBar?.setDisplayHomeAsUpEnabled(value)
    }

}
