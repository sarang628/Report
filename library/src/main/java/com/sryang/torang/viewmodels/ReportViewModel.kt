package com.sryang.torang.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ReportViewModel @Inject constructor() : ViewModel()
{
    private var reviewId: Int? = null
    private var reason: String? = null
    private var action: String? = null

    fun setReviewId(reviewId: Int)
    {
        this.reviewId = reviewId
    }

    fun setReason(reason: String)
    {
        this.reason = this.reason // 신고 처리하기 신고물 피드에서 삭제
    }

    fun setAction(action: String)
    {
        this.action = action
    }

    fun onRestrictAccount()
    { // 계정 블록 처리하기
    }

}