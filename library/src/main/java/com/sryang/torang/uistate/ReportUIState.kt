package com.sryang.torang.uistate

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
