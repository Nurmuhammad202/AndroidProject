package uz.personal.androidproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.personal.domain.model.PostUseCaseData
import uz.personal.domain.usecase.PostUseCase
import javax.inject.Inject

@HiltViewModel
class FragmentMainViewModel @Inject constructor(private val postUseCase: PostUseCase) :
    ViewModel() {

    private val _listPostUseCaseData = MutableLiveData<List<PostUseCaseData>>()
    val listPostUseCaseData: LiveData<List<PostUseCaseData>> = _listPostUseCaseData

    fun getPostUseCase() = viewModelScope.launch {
        _listPostUseCaseData.value = postUseCase.execute()
    }

}