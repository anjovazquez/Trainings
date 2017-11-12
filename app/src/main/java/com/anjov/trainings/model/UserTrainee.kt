package com.anjov.trainings.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by anjov on 11/11/2017.
 */
@Entity
data class UserTrainee (@PrimaryKey val id:Int, val email:String, val password:String, val status:String, val bornDate:String, val weight:String, val height:String, val gender:String)