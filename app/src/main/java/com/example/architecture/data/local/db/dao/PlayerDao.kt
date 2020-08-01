package com.example.architecture.data.local.db.dao

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.architecture.data.local.db.AppDatabase
import com.example.architecture.data.model.Player
import com.example.architecture.data.model.Team

class PlayerDao(appDatabase: AppDatabase):BaseDao<Player>(appDatabase) {
    override fun save(entity: Player): Boolean {
        val db:SQLiteDatabase = appDatabase.writableDatabase
        updateContentValues(entity , contentValues)
        val result = db.insert(AppDatabase.PLAYER_TABLE , null , contentValues)
        db.close()
// if result is bigger than 0 that means succesfully saved
        if (result>0) return true
        return false
    }

    override fun save(id: String, entity: Player): Boolean {
        val db:SQLiteDatabase = appDatabase.writableDatabase
        updateContentValues(entity , contentValues)
        val result =     db.update(AppDatabase.PLAYER_TABLE  , contentValues , AppDatabase.PLAYER_ID + " = ?" , arrayOf(id))
        db.close()
// if result is bigger than 0 that means succesfully saved
        if (result>0) return true
        return false
    }

    override fun findAll(): List<Player> {
        val db = appDatabase.readableDatabase
        query = "SELECT * FROM " + AppDatabase.PLAYER_TABLE
        val cursor =   db.rawQuery(query , null )
        return cursorToList(cursor , db)
    }

    override fun find(columnName: String, columnValue: String): List<Player> {
        val db = appDatabase.readableDatabase
        query = "SELECT * FROM " + AppDatabase.PLAYER_TABLE + " WHERE $columnName = ? "
        val cursor =   db.rawQuery(query , arrayOf(columnValue) )

        return cursorToList(cursor , db)
    }

    override fun delete(id: String): Boolean {
        val db = appDatabase.writableDatabase
        val result =  db.delete(AppDatabase.PLAYER_TABLE , AppDatabase.TEAM_ID + " = ?" ,  arrayOf(id))
        db.close()
        if (result>0) return true
        return false
    }

    override fun updateContentValues(entity: Player, contentValues: ContentValues) {
        contentValues.clear()
        contentValues.put(AppDatabase.PLAYER_NAME , entity.name)
        contentValues.put(AppDatabase.PLAYER_TEAM_ID , entity.team_id)
    }

    override fun cursorToList(cursor: Cursor, db: SQLiteDatabase): List<Player> {
        data.clear()
        // change cursor to data
        if (  cursor.moveToFirst()  ){
            do {
                val id =  cursor.getString(cursor.getColumnIndex(AppDatabase.PLAYER_ID))
                val name =  cursor.getString(cursor.getColumnIndex(AppDatabase.PLAYER_NAME))
                val team_id =  cursor.getString(cursor.getColumnIndex(AppDatabase.PLAYER_TEAM_ID))
                data.add(Player(id.toLong() , name , team_id.toLong()))
            }while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return data

    }
}