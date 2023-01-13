package uz.personal.androidproject.ui.fragment.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.personal.domain.model.UserPageData
import uz.personal.domain.model.UserPageDetailsData
import uz.personal.domain.usecase.UserInfoUseCase
import uz.personal.domain.usecase.UserUseCase
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(private val userUseCase: UserInfoUseCase) :
    ViewModel() {

    private val _user = MutableLiveData<UserPageDetailsData>()
    val user: LiveData<UserPageDetailsData> = _user
    fun getUserById(userId: Int) = viewModelScope.launch {
        _user.value = userUseCase.execute(userId)
    }
}