package com.sryang.torang.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class ReportUIState(val reviewId: Int? = null, // 신고할 리뷰 id
                         val reason: String? = null, // 신고 이유
                         val action: String? = null) // 차단 여부

@HiltViewModel
class ReportViewModel @Inject constructor() : ViewModel()
{
    private val _uiState = MutableStateFlow(ReportUIState())
    val uiState = _uiState.asStateFlow()

    fun setReviewId(reviewId: Int) // 리뷰 id 설정
    {

    }

    fun setReason(reason: String) // 이유 설정 + 신고처리 후 피드에서 삭제
    {
        _uiState.update {
            it.copy(reason = reason)
        } // 신고 처리하기 신고물 피드에서 삭제
    }

    fun setAction(action: String) // 차단 여부 설정
    {
        _uiState.update {
            it.copy(action = action)
        }
    }

    fun onRestrictAccount() // 차단 요청
    {

    }

}