package com.sryang.torang.usecases.report

import com.sryang.torang.data.report.ReviewDTO

interface LoadReviewUseCase
{
    suspend fun invoke(id: Int): ReviewDTO
}