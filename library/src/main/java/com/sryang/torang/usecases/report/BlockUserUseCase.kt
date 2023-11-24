package com.sryang.torang.usecases.report

interface BlockUserUseCase // 사용자 차단 usecase
{
    suspend fun invoke(userId : Int)
}