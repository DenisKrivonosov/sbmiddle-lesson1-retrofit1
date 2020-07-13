package ru.skillbranch.retrofit1

import android.app.Application
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//import ru.mustakimov.retrofittutorial.api.UmoriliApi

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val retrofit = Retrofit.Builder()
            //Базовая часть адреса
            .baseUrl("http://universities.hipolabs.com/")
            //Конвертер, необходимый для преобразования JSON'а в объекты
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        //Создаем объект, при помощи которого будем выполнять запросы
        umoriliApi = retrofit.create(UmoriliApi::class.java)
    }

    companion object {

        private lateinit var umoriliApi: UmoriliApi

        fun getApi() = umoriliApi
    }
}