package com.shruti.bookhub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shruti.bookhub.R
import com.shruti.bookhub.database.BookEntity
import com.squareup.picasso.Picasso

class FavouriteRecyclerAdapter(val context: Context, val bookList: List<BookEntity> ):RecyclerView.Adapter<FavouriteRecyclerAdapter.favouriteViewHolder>(){

    class favouriteViewHolder(view: View):RecyclerView.ViewHolder(view){
        val txtBookName:TextView = view.findViewById(R.id.txtFavBookTitle)
        val txtBookAuthor:TextView = view.findViewById(R.id.txtFavBookAuthor)
        val txtBookPrice:TextView = view.findViewById(R.id.txtFavBookPrice)
        val txtBookRating:TextView = view.findViewById(R.id.txtFavBookRating)
        val imgBookImage:ImageView = view.findViewById(R.id.imgFavBookImage)
        val llContext:LinearLayout=view.findViewById(R.id.llFavContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): favouriteViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_favourite_single_row,parent,false)
        return favouriteViewHolder(view)

    }

    override fun getItemCount(): Int {
        return bookList.size

    }

    override fun onBindViewHolder(
        holder: FavouriteRecyclerAdapter.favouriteViewHolder,
        position: Int
    ) {

        val book =bookList[position]
        holder.txtBookName.text=book.bookName
        holder.txtBookAuthor.text=book.bookAuthor
        holder.txtBookPrice.text=book.bookPrice
        holder.txtBookRating.text=book.bookRating
        //holder.imgBookImage.text(book.bookImage)
        Picasso.get().load(book.bookImage).error(R.drawable.default_book_cover).into(holder.imgBookImage);


    }


}