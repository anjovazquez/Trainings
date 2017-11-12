package com.anjov.trainings.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.anjov.trainings.data.TrainingsDatabase
import com.anjov.trainings.model.TrainingActivity
import java.util.*

/**
 * Created by anjov on 11/11/2017.
 */
class TrainingsModelView :AndroidViewModel{

    private val trainingsDb: TrainingsDatabase = TrainingsDatabase.get(this.getApplication())
    var trainings : LiveData<List<TrainingActivity>>

    constructor(application:Application):super(application){
        trainings = trainingsDb.trainingsDao().allTrainingActivities()
    }

}