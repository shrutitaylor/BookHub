package com.shruti.bookhub.fragment

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.shruti.bookhub.R
import com.shruti.bookhub.adapter.FavouriteRecyclerAdapter
import com.shruti.bookhub.database.BookDataBase
import com.shruti.bookhub.database.BookEntity


class FavouritesFragment : Fragment() {
    lateinit var recyclerFavourite: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager

    lateinit var recyclerAdapter: FavouriteRecyclerAdapter
    lateinit var progressLayout: RelativeLayout
    lateinit var progressBar: ProgressBar

    var dbBookList=listOf<BookEntity>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_favourites,container,false)
        recyclerFavourite = view.findViewById(R.id.recyclerFavourite)
        progressBar=view.findViewById(R.id.progressBar)
        progressLayout=view.findViewById(R.id.progressLayout)
        layoutManager= GridLayoutManager(activity as Context,2)
        dbBookList=RetriveFavourites(activity as Context).execute().get()

        if(activity !=null){
            progressLayout.visibility=View.GONE
            recyclerAdapter=FavouriteRecyclerAdapter(activity as Context,dbBookList)
            recyclerFavourite.adapter=recyclerAdapter
            recyclerFavourite.layoutManager=layoutManager
        }

        return view
    }
    class RetriveFavourites(val context: Context):AsyncTask<Void,Void,List<BookEntity>>(){
        override fun doInBackground(vararg params: Void?): List<BookEntity> {
            val db= Room.databaseBuilder(context, BookDataBase::class.java,"books-db").build()
            return db.bookDao().getAllBooks()

        }

    }

}
