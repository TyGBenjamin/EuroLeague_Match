package com.example.soccermatch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccermatch.model.local.entity.Match
import com.example.soccermatch.model.repository.RepositoryImpl
import com.example.soccermatch.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel class to hold listData.
 *
 * @constructor Create instance of [SoccerViewModel]
 */
@HiltViewModel
class SoccerViewModel @Inject constructor(private val repo: RepositoryImpl) : ViewModel() {

    private val _matchList: MutableStateFlow<Resource<List<Match>>> = MutableStateFlow(Resource.Loading)
    val matchList = _matchList.asStateFlow()

    /**
     * Get list.
     *
     */
    fun getList() {
        viewModelScope.launch {
            _matchList.value = repo.getList()
        }
    }
}
