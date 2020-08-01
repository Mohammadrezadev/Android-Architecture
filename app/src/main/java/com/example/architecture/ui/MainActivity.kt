package com.example.architecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.architecture.AppConstants
import com.example.architecture.R
import com.example.architecture.data.repository.RemoteAppRepository
import ir.arcademy.noteproject.util.NetworkUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
if(NetworkUtil.isInternetAvailable(this)) {
    RemoteAppRepository.getinstanced().getNotes()
}else{
    Log.i(AppConstants.NETWORK_TEST , "no internet")
}




    //database
//   val barcelona  = Team("Barcelona" , "Camp noew" , "man")
////        val realMadrid  = Team("Real Madrid" , "Santiago")
////        val juventus  = Team("Juventus" , "Alianz")
//
////     val messi = Player("Messi" , 1)
////        val suarez = Player("Suarez" , 1)
////        val ronaldo = Player("Ronaldo" , 3)
//
//
//        val appDatabase = AppDatabase(this)
//        val teamDao = TeamDao(appDatabase)
//        val playerDao = PlayerDao(appDatabase)
//        val appRepository = AppRepository(teamDao , playerDao)
//   //  appRepository.saveTeam(barcelona)
////        appRepository.saveTeam(realMadrid)
////        appRepository.saveTeam(juventus)
//
////        appRepository.savePlayer(messi)
////        appRepository.savePlayer(suarez)
////        appRepository.savePlayer(ronaldo)
//
////appRepository.findTeamsByName("Real Madrid").forEach { Log.i("TESSST" , it.toString()) }
////Log.i("TESST" ,  appRepository.findTeamById("5").toString())
//
//       // val result = appRepository.deleteTeam("3")
//        //Log.i("TESST" , result.toString())
//   // val esteghlal  = Team("esteghlal" , "azadi")
//     //   appRepository.updateTeam("1" , esteghlal)
//        appRepository.findAllTeams().forEach { Log.i("TESSST" , it.toString()) }
//        appRepository.findAllPlayers().forEach { Log.i("TESSST" , it.toString()) }
//        Log.i("TESSST" ,appRepository.findPlayersByTeam(barcelona).toString())




    }
}
