package com.example.screen_report

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.screen_report.databinding.FragmentReportReasonBinding
import com.example.torang_core.util.EventObserver
import com.example.torang_core.util.Logger
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReportReasonFragment : Fragment() {

    private val reportViewModel: ReportViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentReportReasonBinding.inflate(layoutInflater, container, false).apply {
            viewModel = reportViewModel
            reviewId = requireActivity().intent.getIntExtra("reviewId", -1)
            Logger.d("reviewId is $reviewId")
        }

        (requireActivity() as AppCompatActivity).apply {
            setSupportActionBar(binding.tbReport)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            binding.tbReport.setNavigationOnClickListener {
                onBackPressed()
            }
        }

        subScribeUI()

        return binding.root
    }

    private fun subScribeUI() {
        reportViewModel.resultReportReason.observe(viewLifecycleOwner, EventObserver {
            if (it)
                findNavController().navigate(R.id.action_reportReasonFragment_to_reportResultFragment)
        })
    }
}