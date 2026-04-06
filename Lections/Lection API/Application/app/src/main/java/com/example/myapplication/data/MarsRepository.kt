package com.example.myapplication.data

class MarsRepository {
    val api: MarsApi = RetrofitHelper.getInstance().create(MarsApi::class.java)

    suspend fun getMarsPhotos(): List<MarsPhoto> {
        return api.getPhotos()
    }
}