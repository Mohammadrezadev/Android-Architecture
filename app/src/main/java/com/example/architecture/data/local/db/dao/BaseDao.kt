package com.example.architecture.data.local.db.dao

import android.content.ContentValues
import com.example.architecture.data.local.db.AppDatabase
import com.example.architecture.data.local.db.ContentValuesUpdater
import com.example.architecture.data.local.db.cursorConvertor
import com.example.architecture.data.model.Team

// we need app database parameters due to achive controlling method beacuse this class extends Sqliteopenhelper
//and we need the method of sqlite open helper
abstract class BaseDao<T>(val appDatabase: AppDatabase) : ContentValuesUpdater<T> , cursorConvertor<T>{

    val contentValues = ContentValues()
    val data : MutableList<T> = ArrayList()
    var query = ""


  // for inserting
    // this return boolean to know if we save or not
    abstract fun save(entity: T) : Boolean

    // for updating
    // any parameters you defined should be string
    abstract  fun save(id:String , entity: T) :Boolean


    // fetch all data
    abstract fun findAll():List<T>

//find by column value to get row
    abstract fun find (columnName : String , columnValue: String) : List<T>

// delete
    abstract fun delete(id:String) : Boolean

}