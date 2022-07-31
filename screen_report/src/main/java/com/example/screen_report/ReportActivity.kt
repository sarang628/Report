package com.example.screen_report

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.torang_core.navigation.ReportNavigation
import com.example.torang_core.util.EventObserver
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

@AndroidEntryPoint
class ReportActivity : AppCompatActivity() {

    private val viewModel: ReportViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        viewModel.noFeedInformation.observe(this, EventObserver {
            if (it)
                showNoFeedInformationDialog()
        })

        viewModel.setReviewId(intent.getIntExtra("reviewId", -1))
    }

    private fun showNoFeedInformationDialog() {
        AlertDialog.Builder(this)
            .setMessage("신고 한 피드의 정보가 없습니다.")
            .setCancelable(false)
            .setPositiveButton("확인") { _, _ ->
                finish()
            }
            .show()
    }
}


class ReportNavigationImpl @Inject constructor() : ReportNavigation {
    override fun goReport(context: Context, reviewId: Int) {
        context.startActivity(Intent(context, ReportActivity::class.java).apply {
            putExtra("reviewId", reviewId)
        })
    }
}

@Module
@InstallIn(ActivityComponent::class)
abstract class ReportModule {
    @Binds
    abstract fun provideReportNavigation(reportNavigationImpl: ReportNavigationImpl): ReportNavigation
}