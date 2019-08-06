package com.example.nailnew.models

import android.os.Parcelable
import android.os.Parcel


// Add parcelable implementation with lamp small helper. The parcelable is a interface for serialize the object, to after deserialize and create this object in another activity
// This don't influences in the class file

// Parcel is a content to message, this can used to send serialized object between intent
// Parcel is better in performance than Serializer (used for serialization a long time, now parcelable is recommended)
data class Student(var name: String?, var lastName: String?, var age: Int, var isDeveloper: Boolean = true) : Parcelable {
    //Read in same orders in properties is declared

    //This secondary constructor than first constructor about parameters in order and same types
    // -> Parcelable don't understand to booleans types, also use byte, when 0 to byte back value boolean that is true if the readByte is different to 0 to byte, then is false
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte())

    override fun writeToParcel(parcel: Parcel, flags: Int){
        // Write values in same orders than read in constructor

        //This function is called, when we have our object constructed with properties and values,
        // and we want converter to parcel, for to write in parcel, and after this send and create other time to deserializable for get values

        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeInt(age)
        parcel.writeByte(if(isDeveloper) 1 else 0) // -> To boolean
    }

    //Describe content type of parcelable object, o always use, the other value is 1 or called file descriptor, for object types that implement a file descriptor
    //if don't implement file descriptor back is 0 always
    override fun describeContents() = 0

    companion object CREATOR: Parcelable.Creator<Student>{
        // This will create  the object from parcel calling to secondary constructor
        override fun createFromParcel(parcel: Parcel) = Student(parcel)

        //This will help, to serialize object array's to same type to class (Student)
        //Example if we have a students array<5> more, this array created of nulls, and after this send to create from parcel function
        override fun newArray(size: Int) = arrayOfNulls<Student?>(size)

    }

}