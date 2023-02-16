package com.example.ngo

import android.content.Intent
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView



class MyAdapter(val userList : ArrayList<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.mylist,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

        holder.name.text = currentitem.name
        holder.location.text = currentitem.location

        holder.btn.setOnClickListener{
         if ( holder.ll.visibility==View.GONE) {
             holder.mission.text = currentitem.mission
             holder.history.text = currentitem.history

             holder.ll.visibility = View.VISIBLE
         }
            else
             holder.ll.visibility=View.GONE

        }
        holder.type.text=currentitem.type
        holder.payment.setOnClickListener{


        }
    }

    override fun getItemCount(): Int {

        return userList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val name : TextView = itemView.findViewById(R.id.tvfirstName)
        val location : TextView = itemView.findViewById(R.id.location)
        val btn:Button=itemView.findViewById(R.id.viewNgoProfile)
        val btn2:Button=itemView.findViewById(R.id.contact)
        val mission : TextView = itemView.findViewById(R.id.mission)
        val history : TextView = itemView.findViewById(R.id.history)
        val ll:CardView=itemView.findViewById(R.id.ll)
        val type:TextView=itemView.findViewById(R.id.type)
        val payment:LottieAnimationView=itemView.findViewById(R.id.donation)
    }


}