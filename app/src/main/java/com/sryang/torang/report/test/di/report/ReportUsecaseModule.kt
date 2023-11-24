package com.sryang.torang.report.test.di.report

import com.sryang.torang.usecases.report.BlockUserUseCase
import com.sryang.torang.usecases.report.LoadReviewUseCase
import com.sryang.torang.usecases.report.ReportUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class ReportUsecaseModule
{
    @Provides
    fun providesBlockUserUseCase(): BlockUserUseCase
    {
        return object : BlockUserUseCase
        {
            override suspend fun invoke(userId: Int)
            {
                throw Exception("not yet implemented")
            }
        }
    }

    @Provides
    fun providesReportUseCase(): ReportUseCase
    {
        return object : ReportUseCase
        {
            override suspend fun invoke(reviewId: Int, reason: String)
            {
                throw Exception("not yet implemented")
            }
        }
    }

    @Provides
    fun providesLoadReviewUseCase(): LoadReviewUseCase
    {
        return object : LoadReviewUseCase
        {
            override fun invoke()
            {
                throw Exception("not yet implemented")
            }
        }
    }

}