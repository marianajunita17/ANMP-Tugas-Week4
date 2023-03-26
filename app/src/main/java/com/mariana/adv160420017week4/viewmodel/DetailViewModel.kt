package com.mariana.adv160420017week4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mariana.adv160420017week4.model.Student

class DetailViewModel:ViewModel() {
    val studentLD = MutableLiveData<Student>()
}