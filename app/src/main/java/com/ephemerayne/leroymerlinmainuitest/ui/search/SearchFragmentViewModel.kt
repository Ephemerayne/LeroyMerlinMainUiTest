package com.ephemerayne.leroymerlinmainuitest.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchFragmentViewModel : ViewModel() {

    fun getCategories(input: String): LiveData<List<String>> {
        return MutableLiveData<List<String>>().apply {
            value = if (input.length >= 3) {
                searchCategories.filter { it.contains(input, ignoreCase = true) }
            } else {
                searchCategories
            }
        }
    }

    private val searchCategories = listOf(
        "Обои",
        "Ковер",
        "Люстры",
        "Стеллаж",
        "Шторы",
        "Зеркало",
        "Ламинат",
        "Столы",
        "Линолеум",
        "Плинтус"
    )
}