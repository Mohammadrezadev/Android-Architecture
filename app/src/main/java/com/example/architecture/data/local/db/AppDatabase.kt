package com.example.architecture.data.local.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// define database architecture in this class
class AppDatabase(context:Context):SQLiteOpenHelper(context , DATABASE_NAME , null , DATABASE_VERSION) {


    companion object{

        //database
        private const val DATABASE_NAME = "test.db"
// define first version of database
        private const val DATABASE_VERSION = 3

        //table one
        const val TEAM_TABLE = "teams"
        // column
const val TEAM_ID = "id"
const val TEAM_NAME = "name"
        const val TEAM_GROUND = "ground"
const val TEAM_MANAGER = "manager"

        //table two
        const val PLAYER_TABLE = "players"
        // column
        const val PLAYER_ID = "id"
        const val PLAYER_NAME = "name"
        //foreign key (connected to the teams table  , column id  )
        const val PLAYER_TEAM_ID = "team_id"

    }


// this method called when we create instance of appdatabase
    override fun onCreate(p0: SQLiteDatabase?) {
    // create table if they does not exists
 // due to write query we should use p0
//TEAM
    p0!!.execSQL("CREATE TABLE IF NOT EXISTS $TEAM_TABLE (" +
        "$TEAM_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "$TEAM_NAME TEXT, " +
        "$TEAM_GROUND TEXT, " +
            "$TEAM_MANAGER TEXT)")

    //PLAYER
    p0.execSQL("CREATE TABLE IF NOT EXISTS $PLAYER_TABLE (" +
            "$PLAYER_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$PLAYER_NAME TEXT, " +
            "$PLAYER_TEAM_ID INTEGER, " +
            "FOREIGN KEY($PLAYER_TEAM_ID) REFERENCES $TEAM_TABLE($TEAM_ID))")



}

    override fun onUpgrade(p0: SQLiteDatabase?, oldversion: Int, newversion: Int) {
if (oldversion<2){
    upgradeVersion2()
}
        else if (oldversion <3)
{
    if (p0 != null) {
        upgradeVersion3(p0)
    }
}

    }


    fun upgradeVersion2(){

    }


    fun upgradeVersion3(db : SQLiteDatabase){

        db.execSQL("ALTER TABLE $TEAM_TABLE ADD COLUMN $TEAM_MANAGER TEXT")
  //we can put deafult values for column that null

    }




}