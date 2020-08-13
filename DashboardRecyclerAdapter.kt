package com.shruti.bookhub.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.shruti.bookhub.R

import java.util.*
import androidx.recyclerview.widget.RecyclerView
import com.shruti.bookhub.activity.DescriptionActivity
import com.shruti.bookhub.model.Book
import com.squareup.picasso.Picasso

class DashboardRecyclerAdapter(val context: Context, val itemList:ArrayList<Book>): RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_dashboard_single_row,parent,false)
        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }




    class DashboardViewHolder(view:View):RecyclerView.ViewHolder(view){
        val txtBookName:TextView=view.findViewById(R.id.txtBookName)
        val txtAuthor:TextView=view.findViewById(R.id.txtBookAuthor)
        val txtCost:TextView=view.findViewById(R.id.txtBookPrice)
        val txtRating:TextView=view.findViewById(R.id.txtBookRating)
        val imgBookImage:ImageView=view.findViewById(R.id.imgBookImage)

        val llContext:LinearLayout=view.findViewById(R.id.llContext)



    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val book =itemList[position]
        holder.txtBookName.text=book.bookName
        holder.txtAuthor.text=book.bookAuthor
        holder.txtCost.text=book.bookPrice
        holder.txtRating.text=book.bookRating
        //holder.imgBookImage.text(book.bookImage)
        Picasso.get().load(book.bookImage).error(R.drawable.default_book_cover).into(holder.imgBookImage);

        holder.llContext.setOnClickListener{
            val intent= Intent(context,DescriptionActivity::class.java)
            intent.putExtra("book_id",book.bookId)
            context.startActivity(intent)
        }


    }
}