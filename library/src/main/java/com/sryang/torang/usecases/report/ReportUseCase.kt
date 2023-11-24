package com.sryang.torang.usecases.report

interface ReportUseCase // 신고 usecase
{
    suspend fun invoke(reviewId: Int, reason: String)
}