package com.anjov.trainings.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.anjov.trainings.model.TrainingActivity

/**
 * Created by anjov on 11/11/2017.
 */
@Dao
interface TrainingActivityDao {

    @Query("SELECT * FROM TrainingActivity")
    fun allTrainingActivities():LiveData<List<TrainingActivity>>

    @Insert
    fun insert(trainingActivity: TrainingActivity)

    @Insert
    fun insert(trainingActivities:List<TrainingActivity>)
}