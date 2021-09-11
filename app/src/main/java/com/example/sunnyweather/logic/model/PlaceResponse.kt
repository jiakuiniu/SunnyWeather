package com.example.sunnyweather.logic.model

import android.location.Address
import android.location.Location
import com.google.gson.annotations.SerializedName

data class PlaceResponse(val status:String,val places:List<Place>)

data class Place(val name:String,val location:Location,@SerializedName("formatted_address") val address: String)//@SerializedName属性重命名，可以将json中的属性名转为我们自己自定义的属性名

data class Location(val lng:String,val lat:String)