package com.kelvin.itemrequest.api

import com.kelvin.itemrequest.models.Item
import com.kelvin.itemrequest.models.Student
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiRequests {

    @GET("items")
    suspend fun getItems(): List<Item>

    @POST("students")
    suspend fun addStudents(@Body newStudent: Student): List<Student>
}