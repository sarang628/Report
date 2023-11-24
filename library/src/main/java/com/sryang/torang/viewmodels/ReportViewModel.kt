package com.sryang.torang.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReportViewModel @Inject constructor() :
    ViewModel() {
    private val _noFeedInformation = MutableLiveData<Boolean>()
    val noFeedInformation: LiveData<Boolean> = _noFeedInformation

    /** 신고 이유 전송 결과 */
    private val _resultReportReason = MutableLiveData<Boolean>()
    val resultReportReason: LiveData<Boolean> = _resultReportReason

    /** 지원 작입 전송 결과 */
    private val _resultAfterSupport = MutableLiveData<Boolean>()
    val resultAfterSupport: LiveData<Boolean> = _resultAfterSupport

    /** 신고 이유 전송 요청 */
    fun sendReportReason(reportReason: Int, reviewId: Int) {
        viewModelScope.launch {
        }
    }

    /** 신고 이후 지원 전송 요청 */
    fun sendReportAfterSupport(reviewId: Int) {
        viewModelScope.launch {
        }
    }

    /** 리뷰 아이디 설정 */
    fun setReviewId(reviewId: Int) {
        if (reviewId == -1) {
        } else {
            viewModelScope.launch {
            }
        }
    }
}