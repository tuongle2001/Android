/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsrealestate.network.MarsApi
import com.example.android.marsrealestate.network.MarsApiFilter
import com.example.android.marsrealestate.network.MarsProperty
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    private val _navigateToSelectedProperty = MutableLiveData<MarsProperty>()
    val navigateToSelectedProperty: LiveData<MarsProperty>
        get() = _navigateToSelectedProperty

    enum class MarsApiStatus { LOADING, ERROR, DONE }


    // The internal MutableLiveData String that stores the most recent response
    private val _status = MutableLiveData<MarsApiStatus>()

    val status: LiveData<MarsApiStatus>
        get() = _status

//    private val _property = MutableLiveData<MarsProperty>()
    private val _properties = MutableLiveData<List<MarsProperty>>()

//    val property: LiveData<MarsProperty>
//        get() = _property
    val properties: LiveData<List<MarsProperty>>
        get() = _properties

    // The external immutable LiveData for the response String
//    val response: LiveData<String>
//        get() = _response

    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getMarsRealEstateProperties(MarsApiFilter.SHOW_ALL)
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
//    private fun getMarsRealEstateProperties() {
    private fun getMarsRealEstateProperties(filter: MarsApiFilter) {
//        _response.value = "Set the Mars API Response here!"
//
//        MarsApi.retrofitService.getProperties().enqueue(
//                object: Callback<List<MarsProperty>> {
//                    override fun onResponse(call: Call<List<MarsProperty>>,response: Response<List<MarsProperty>>) {
//                        _response.value ="Success: ${response.body()?.size} Mars properties retrieved"
//                    }
//
//                    override fun onFailure(call: Call<List<MarsProperty>>, t: Throwable) {
//                        _response.value = "Failure: " + t.message
//                    }
//                })

        viewModelScope.launch {
            _status.value = MarsApiStatus.LOADING
            try {
//                _properties.value = MarsApi.retrofitService.getProperties()
                _properties.value = MarsApi.retrofitService.getProperties(filter.value)

                _status.value = MarsApiStatus.DONE

//                if (listResult.size > 0) {
//                    _property.value = listResult[0]
//                }

            } catch (e: Exception) {
                _status.value = MarsApiStatus.ERROR
                _properties.value = ArrayList()
            }



        }
    }

    fun updateFilter(filter: MarsApiFilter) {
        getMarsRealEstateProperties(filter)
    }

    fun displayPropertyDetails(marsProperty: MarsProperty) {
        _navigateToSelectedProperty.value = marsProperty
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}
