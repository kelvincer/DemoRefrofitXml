package com.home.shimmerrecyclerdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.home.shimmerrecyclerdemo.xmlparse.DataRepository
import com.home.shimmerrecyclerdemo.xmlparse.entities.Result

class MainViewModel : ViewModel() {

    //var repository: DataRepository = DataRepository()
    var repository: DataRepository = DataRepository()

    fun getResultState(): LiveData<List<Result>>? {
        return repository.getResults()
    }

    /* fun getData() {
         data.value = repository.getResults()
     }*/
}