package com.sarang.torang.usecases.report

import com.sarang.torang.data.dto.ReviewDTO

interface LoadReviewUseCase //리뷰 불러오기 usecase
{
    suspend fun invoke(id: Int): ReviewDTO
}