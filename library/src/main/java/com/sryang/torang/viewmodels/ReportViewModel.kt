package com.sryang.torang.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sryang.torang.usecases.report.BlockUserUseCase
import com.sryang.torang.usecases.report.LoadReviewUseCase
import com.sryang.torang.usecases.report.ReportUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ReportUIState(
    val reviewId: Int? = null, /*신고할 리뷰 id*/
    val userId: Int? = null, /* 사용자 ID */
    val userName: String? = null, /* 이름 */
    val profileUrl: String? = null, /* 프로필 */
    val reason: String? = null, /* 신고 이유 */
    val action: String? = null, /* 차단 여부 */
    val error: String? = null, /* 에러 메세지 */
    val isLoading: Boolean = false /* 화면 로딩 */
)

@HiltViewModel
class ReportViewModel @Inject constructor(
    private val reportUseCase: ReportUseCase,
    private val blockUserUseCase: BlockUserUseCase,
    private val loadReviewUseCase: LoadReviewUseCase
) : ViewModel()
{
    private val _uiState = MutableStateFlow(ReportUIState())
    val uiState = _uiState.asStateFlow()

    suspend fun setReason(reason: String): Boolean // 이유 설정 + 신고처리 후 피드에서 삭제
    {
        try
        {
            reportUseCase.invoke(reviewId = uiState.value.reviewId!!, reason = reason)
            _uiState.update { it.copy(reason = reason) }
            return true
        } catch (e: Exception)
        {
            _uiState.update { it.copy(error = e.toString()) }
        }
        return false
    }

    fun setAction(action: String) // 차단 여부 설정
    {
        _uiState.update {
            it.copy(action = action)
        }
    }

    suspend fun onRestrictAccount(): Boolean // 차단 요청
    {
        try
        {
            blockUserUseCase.invoke(uiState.value.userId!!)
            return true
        } catch (e: Exception)
        {
            _uiState.update { it.copy(error = e.toString()) }
        }
        return false
    }

    fun clearErrorMessage()
    {
        _uiState.update { it.copy(error = null) }
    }

    fun loadReview(reviewId: Int)
    {
        viewModelScope.launch {
            try
            {
                _uiState.update { it.copy(isLoading = true) } //화면 가리기
                val reviewDto = loadReviewUseCase.invoke(reviewId)
                Log.d("_ReportViewModel", reviewDto.toString())
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        reviewId = reviewId,
                        userId = reviewDto.userId,
                        profileUrl = reviewDto.profileUrl,
                        userName = reviewDto.userName
                    )
                }
            } catch (e: Exception)
            {
                _uiState.update {
                    it.copy(error = e.toString())
                }
            }
        }
    }

}