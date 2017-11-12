package com.anjov.trainings.data

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.anjov.trainings.data.dao.TrainingActivityDao
import com.anjov.trainings.model.TrainingActivity
import com.anjov.trainings.model.UserTrainee
import com.anjov.trainings.model.ioThread
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by anjov on 11/11/2017.
 */

@Database(entities = arrayOf(TrainingActivity::class), version = 1)
abstract class TrainingsDatabase : RoomDatabase() {
    abstract fun trainingsDao(): TrainingActivityDao

    companion object {
        private var instance: TrainingsDatabase? = null
        @Synchronized
        fun get(context: Context): TrainingsDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                        TrainingsDatabase::class.java, "TrainingsDatabase")
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                fillInDb(context.applicationContext)
                            }
                        }).allowMainThreadQueries().build()
            }
            return instance!!
        }

        private fun fillInDb(context: Context) {
            // inserts in Room are executed on the current thread, so we insert in the background
            ioThread {
                val gson = Gson()
                val trainingsType = object : TypeToken<List<TrainingActivity>>() {}.type
                val trainingActivities = gson.fromJson<List<TrainingActivity>>(
                        trainingsJSON,
                        trainingsType
                )
                get(context).trainingsDao().insert(trainingActivities)
            }
        }
    }
}

private val trainingsJSON = """[
        {
            "id": "600340",
            "sport": "cycling",
            "level": "3",
            "title": "L4",
            "description": "hahakjfdjkdakja<b>hhh<i>gg</i></b>",
            "measurement": "30000",
            "measurement_unit": "m",
            "day": "2017-01-01 00:00:00",
            "position": "0",
            "completed": "false",
            "pupil_id": "3",
            "trainer_id": "8"
        },
        {
            "id": "600341",
            "sport": "cycling",
            "level": "3",
            "title": "Cuestas",
            "description": "1h calentar<br>5x15 min cuesta sostenida Ae2, denscanso en la bajada<br>soltar 35 min",
            "measurement": "200",
            "measurement_unit": "min",
            "day": "2017-01-01 00:00:00",
            "position": "0",
            "completed": "true",
            "pupil_id": "3",
            "trainer_id": "8"
        },
        {
            "id": "618531",
            "sport": "gym",
            "level": "0",
            "title": "Gimnasio",
            "description": "d",
            "measurement": "60",
            "measurement_unit": "min",
            "day": "2017-01-04 00:00:00",
            "position": "0",
            "completed": "bypupil",
            "pupil_id": "3",
            "trainer_id": "8"
        },
        {
            "id": "618534",
            "sport": "gym",
            "level": "0",
            "title": "Gimnasio",
            "description": "d",
            "measurement": "60",
            "measurement_unit": "min",
            "day": "2017-01-04 00:00:00",
            "position": "0",
            "completed": "bypupil",
            "pupil_id": "3",
            "trainer_id": "8"
        }
        ]"""