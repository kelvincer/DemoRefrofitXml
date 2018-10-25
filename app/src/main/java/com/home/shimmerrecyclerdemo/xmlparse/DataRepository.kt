package com.home.shimmerrecyclerdemo.xmlparse

import retrofit2.Call
import retrofit2.Retrofit
import android.util.Log
import androidx.lifecycle.LiveData
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.MutableLiveData
import com.home.shimmerrecyclerdemo.ConstantsHelper
import com.home.shimmerrecyclerdemo.Helper
import com.home.shimmerrecyclerdemo.xmlparse.entities.Result
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class DataRepository {

    val TAG = javaClass.simpleName
    var data: MutableLiveData<List<Result>> = MutableLiveData()

    fun getResults(): LiveData<List<Result>>? {

        val retrofit = Retrofit.Builder()
            .baseUrl(ConstantsHelper.BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()

        val service = retrofit.create(PlacesApiService::class.java)

        val call = service.getTextResults("restaurantes lima", ConstantsHelper.GOOGLE_PLACE_API_KEY, Helper.TOKEN)

        call.enqueue(object : Callback<PlaceSearchResponse> {
            override fun onResponse(call: Call<PlaceSearchResponse>, response: Response<PlaceSearchResponse>) {
                if (response.isSuccessful) {
                    val placeApiResponse = response.body()
                    Helper.TOKEN = placeApiResponse?.nextPageToken
                    data.value = placeApiResponse?.results
                    Log.d(TAG, "successful")
                }

                Log.d(TAG, response.raw().toString())
            }

            override fun onFailure(call: Call<PlaceSearchResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return data
    }
}