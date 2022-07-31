package com.example.screen_report

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.torang_core.repository.ReportAfterSupport
import com.example.torang_core.repository.ReportReason
import com.example.torang_core.repository.ReportRepository
import com.example.torang_core.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReportViewModel @Inject constructor(private val reportRepository: ReportRepository) :
    ViewModel() {
    private val _noFeedInformation = MutableLiveData<Event<Boolean>>()
    val noFeedInformation: LiveData<Event<Boolean>> = _noFeedInformation

    /** 신고 이유 전송 결과 */
    private val _resultReportReason = MutableLiveData<Event<Boolean>>()
    val resultReportReason: LiveData<Event<Boolean>> = _resultReportReason

    /** 지원 작입 전송 결과 */
    private val _resultAfterSupport = MutableLiveData<Event<Boolean>>()
    val resultAfterSupport: LiveData<Event<Boolean>> = _resultAfterSupport

    /** 신고 이유 전송 요청 */
    fun sendReportReason(reportReason: ReportReason, reviewId: Int) {
        viewModelScope.launch {
            _resultReportReason.postValue(
                Event(reportRepository.sendReportReason(reportReason, reviewId))
            )
        }
    }

    /** 신고 이후 지원 전송 요청 */
    fun sendReportAfterSupport(reportAfterSupport: ReportAfterSupport, reviewId: Int) {
        viewModelScope.launch {
            _resultAfterSupport.postValue(
                Event(reportRepository.sendReportAfterSupport(reportAfterSupport, reviewId))
            )
        }
    }

    /** 리뷰 아이디 설정 */
    fun setReviewId(reviewId: Int) {
        if (reviewId == -1) {
            _noFeedInformation.postValue(Event(true))
        } else {
            viewModelScope.launch {
                _noFeedInformation.postValue(Event(!reportRepository.hasFeed(reviewId)))
            }
        }
    }
}