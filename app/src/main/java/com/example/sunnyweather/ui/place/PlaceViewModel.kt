package com.example.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sunnyweather.logic.Repository
import com.example.sunnyweather.logic.model.Place

/**
 * ViewModel层
 */
class PlaceViewModel : ViewModel() {

    private val searchLiveData=MutableLiveData<String>()

    val placeList=ArrayList<Place>() //用于对界面上显示的城市数据进行缓存

    val placeLiveData=Transformations.switchMap(searchLiveData){
        query -> Repository.searchPlaces(query)
    }

    /**
     * 现在每当searchPlace()函数被调用时，switchMap()方法所对应的转换函数就会执行
     * 在转换函数中，只需要调用仓库层中定义的searchPlaces()方法就可以发起网络请求
     * 同时将仓库层返回的liveData对象转换成一个可供Activity观察的LiveData对象
     */
    fun searchPlaces(query:String){
        searchLiveData.value=query
    }

    fun savePlace(place: Place)=Repository.savePlace(place)

    fun getSavedPlace()=Repository.getSavePlace()

    fun isPlaceSaved()=Repository.isOlaceSaved()
}