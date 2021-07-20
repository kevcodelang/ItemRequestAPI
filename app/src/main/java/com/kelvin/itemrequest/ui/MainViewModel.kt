package com.kelvin.itemrequest.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kelvin.itemrequest.api.RequestProvider
import com.kelvin.itemrequest.models.Item
import com.kelvin.itemrequest.models.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val itemsLiveData = MutableLiveData<List<Item>>()
    val studentsLiveData = MutableLiveData<List<Student>>()

//    val studentsLiveData = liveData<List<Student>> {
//        itemsLiveData.postValue(ServiceProvider.placeHolderApi.getItems())
//    }

    fun getItems() {
        CoroutineScope(Dispatchers.IO).launch {
            itemsLiveData.postValue(RequestProvider.apiRequests.getItems())
        }
    }

    fun addStudent(newStudent: Student) {
        CoroutineScope(Dispatchers.IO).launch {
            studentsLiveData.postValue(RequestProvider.apiRequests.addStudents(newStudent))
        }
    }
}