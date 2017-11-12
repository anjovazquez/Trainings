package com.anjov.trainings.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by anjov on 11/11/2017.
 */
@Entity
data class TrainingActivity(@PrimaryKey val id:Int, val sport:String, val level:String, val title:String, val description:String, val measurement:String, val measurement_unit:String, val day:String, val position:String, val completed:String, val pupil_id:String, val trainer_id:String)