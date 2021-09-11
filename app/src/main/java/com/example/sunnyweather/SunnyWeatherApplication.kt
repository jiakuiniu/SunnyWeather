package com.example.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * 给SunnyWeather项目提供一种全局获取Context的方式
 */
class SunnyWeatherApplication : Application() {

    companion object{
        @SuppressLint("StaticFieldLeak") //忽略警告
        lateinit var context:Context

        const val TOKEN="" //填入你申请到的令牌值
    }

    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }
}