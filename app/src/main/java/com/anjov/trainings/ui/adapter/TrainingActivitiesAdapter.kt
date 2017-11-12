package com.anjov.trainings.ui.adapter

import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import android.view.ViewGroup
import com.anjov.trainings.model.TrainingActivity
import android.widget.TextView
import com.anjov.trainings.R
import com.anjov.trainings.ui.inflate
import kotlinx.android.synthetic.main.training_activity_item.view.*


/**
 * Created by anjov on 12/11/2017.
 */
class TrainingActivitiesAdapter(private var items:List<TrainingActivity>, private val listener: (TrainingActivity) -> Unit):RecyclerView.Adapter<TrainingActivitiesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(parent.inflate(R.layout.training_activity_item))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item:TrainingActivity, listener: (TrainingActivity) -> Unit) = with(itemView){
            tSport.text = item.sport
            tDesc.text = Html.fromHtml(item.description)
            setOnClickListener { listener(item) }
        }
    }

    fun addItems(moreItems:List<TrainingActivity>){
        this.items = moreItems
        notifyDataSetChanged()
    }
}