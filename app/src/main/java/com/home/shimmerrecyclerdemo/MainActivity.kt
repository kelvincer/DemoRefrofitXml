package com.home.shimmerrecyclerdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.RecyclerView
import com.home.shimmerrecyclerdemo.xmlparse.entities.Result


class MainActivity : AppCompatActivity() {

    lateinit var adapter: RecyclerViewResultAdapter
    lateinit var viewModel: MainViewModel
    private var loading = true
    var pastVisiblesItems: Int = 0
    var visibleItemCount: Int = 0
    var totalItemCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getResultState()?.observe(this, Observer {
            if (it != null)
                adapter.updateData(it)
        })

        val list = arrayListOf<Result>()
        adapter = RecyclerViewResultAdapter(list)
        val mLayoutManager = LinearLayoutManager(this)
        places_recycler.layoutManager = mLayoutManager
        places_recycler.adapter = adapter

        //viewModel.getResultState()

        places_recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0)
                //check for scroll down
                {
                    visibleItemCount = mLayoutManager.getChildCount()
                    totalItemCount = mLayoutManager.getItemCount()
                    pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition()

                    if (loading) {
                        if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                            loading = false
                            Log.v("...", "Last Item Wow !")
                            //Do pagination.. i.e. fetch new data
                            viewModel.getResultState()
                        }
                    }
                }
            }
        })
    }
}
