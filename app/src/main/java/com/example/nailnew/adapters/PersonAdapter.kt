package com.example.nailnew.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.nailnew.models.Person
import kotlinx.android.synthetic.main.list_view_person.view.*

class PersonAdapter (val context: Context, val layout: Int, val list: List<Person>) : BaseAdapter(){

    //NOTE FOR THIS
    //The work of adapter is catch the set of person list, the "list view person" layout and implement in "activity list view" layout
    //for each item in "activity list view" layout, take person of "list view person" layout

    private val mInflator: LayoutInflater = LayoutInflater.from(context) // -> Take horizontal "list view person" layout and inflate, use with data


    override fun getItem(position: Int): Any {
        return list[position] // -> Item from position parameter
    }

    override fun getItemId(position: Int): Long {
        return position.toLong() // -> position int to long
    }

    override fun getCount(): Int {
        return list.size // -> Numbers of items there exist in this list, how many row create
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val vh: PersonViewHolder

        if(convertView == null){
            //convertView represent one by one of items from "activity list view" layout
            //the first time that try load the list in the layout this is null so convertView is null too
            //in this case when convertView is null, we use "person view holder"
            view = mInflator.inflate(layout, parent, false) // -> View inflate with "activity list view" layout
            vh = PersonViewHolder(view) // -> Instance Person View Holder
            view.tag = vh // -> View holder with inflate layout and textView references
        }
        else{
            view = convertView
            vh = view.tag as PersonViewHolder
        }

        val fullName = "${list[position].firstName}, ${list[position].lastName}"
        vh.fullName.text = fullName
        vh.age.text = "${list[position].age}" // -> only simple note, the age is integer type, so text need this than string type
        //vh.age.text = list[position].age.toString()

        return view
    }

}

private class PersonViewHolder(view: View){
    val fullName: TextView = view.textViewName
    val age: TextView = view.textViewAge
}