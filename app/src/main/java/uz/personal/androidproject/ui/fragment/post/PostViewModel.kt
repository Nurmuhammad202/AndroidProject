package uz.personal.androidproject.ui.fragment.post

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
class PostViewModel @Inject constructor(private val postUseCase: PostUseCase) : ViewModel() {

    private val _postListLiveData = MutableLiveData<List<PostUseCaseData>>()
    val postListLiveData: LiveData<List<PostUseCaseData>> = _postListLiveData

    fun getPost(userId: Int) = viewModelScope.launch {
        _postListLiveData.value = postUseCase.execute(userId = userId)
    }
}