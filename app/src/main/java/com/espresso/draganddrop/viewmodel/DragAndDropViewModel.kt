package com.espresso.draganddrop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DragAndDropViewModel : ViewModel() {

    private val _isDragging: MutableLiveData<Boolean> = MutableLiveData()
    val isDragging: LiveData<Boolean> = _isDragging

    fun setDraggingState(isDragging: Boolean) {
        _isDragging.value = isDragging
    }

}