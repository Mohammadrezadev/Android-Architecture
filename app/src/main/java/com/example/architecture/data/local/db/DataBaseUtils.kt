package com.example.architecture.data.local.db

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.CalendarContract

interface ContentValuesUpdater <T>{
    fun updateContentValues(entity: T , contentValues :ContentValues)
}

interface  cursorConvertor <T> {
    fun cursorToList(cursor: Cursor , db:SQLiteDatabase):List<T>
}
