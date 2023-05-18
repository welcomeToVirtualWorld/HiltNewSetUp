package com.example.hiltnewsetup.ui.main.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltnewsetup.R
import com.example.hiltnewsetup.model.Posts
import javax.inject.Inject

class CustomAdapter() : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var mutableList:MutableList<Posts> = mutableListOf()
    fun setUpList(list:List<Posts>) {
        mutableList.addAll(list)
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mutableList[position]

        holder.textView.text = ItemsViewModel.body

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mutableList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.txt_post)
    }
}
