package uz.personal.androidproject.ui.fragment.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.personal.domain.model.UserPageData
import uz.personal.domain.usecase.UserUseCase
import javax.inject.Inject

@HiltViewModel
class UserMainFragmentViewModel
@Inject constructor(
    private val userUseCase: UserUseCase
    ) :
    ViewModel() {

    private var _userList = MutableLiveData<List<UserPageData>>()
    val userList: LiveData<List<UserPageData>> = _userList

    fun getUser() = viewModelScope.launch {
        _userList.value = userUseCase.execute()
    }
}