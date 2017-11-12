package com.anjov.trainings.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.anjov.trainings.R
import com.anjov.trainings.model.TrainingActivity
import com.anjov.trainings.ui.adapter.TrainingActivitiesAdapter

/**
 * Created by anjov on 11/11/2017.
 */
class TrainingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.training_activities)

        var rtAdapter = TrainingActivitiesAdapter(ArrayList<TrainingActivity>()){

        }

        val rTrainings:RecyclerView = findViewById(R.id.rTrainings)
        rTrainings.layoutManager = LinearLayoutManager(this)
        rTrainings.adapter = rtAdapter

        val mViewModel = ViewModelProviders.of(this).get(TrainingsModelView::class.java)

        mViewModel.trainings.observe(this, TrainingActivityObserver(rtAdapter))
    }

}

class TrainingActivityObserver:Observer<List<TrainingActivity>>{

    private var mAdapter:TrainingActivitiesAdapter

    constructor(adapter: TrainingActivitiesAdapter){
        mAdapter = adapter
    }
    override fun onChanged(trainingsActivity: List<TrainingActivity>?) {
        mAdapter.addItems(trainingsActivity!!)
    }
}