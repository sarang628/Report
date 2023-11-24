# Report

## Architecture
- Drive UI from data models
- Separation of concerns
- Single source of truth
- Unidirectional Data Flow

위 네 가지 개념을 바탕으로 프로그램 작성

### UILayer
Compose

<img src = "/screenshot/package.png" width="300px" />

UIState
```
data class ReportUIState(val reviewId: Int? = null, // 신고할 리뷰 id
                         val reason: String? = null, // 신고 이유
                         val action: String? = null) // 차단 여부
```

ViewModel
```
@HiltViewModel
class ReportViewModel @Inject constructor() : ViewModel()
{
    private val _uiState = MutableStateFlow(ReportUIState())
    val uiState = _uiState.asStateFlow()
    fun setReviewId(reviewId: Int) {..} // 리뷰 id 설정
    fun setReason(reason: String) {..} // 이유 설정 + 신고처리 후 피드에서 삭제
    fun setAction(action: String) {..} // 차단 여부 설정
    fun onRestrictAccount() {..} // 차단 요청
}
```