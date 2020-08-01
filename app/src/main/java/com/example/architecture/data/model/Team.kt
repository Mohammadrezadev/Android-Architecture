package com.example.architecture.data.model

data class Team( val id :Long  , val name:String , val ground:String , val manager : String?) {
// in this case o is not important beacuse id is auto increment
    constructor(name:String , ground: String , manager: String):this(0, name , ground , manager)
}