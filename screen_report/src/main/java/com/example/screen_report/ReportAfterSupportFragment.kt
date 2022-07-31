package com.example.screen_report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.screen_report.databinding.FragmentReportAfterSupportBinding
import com.example.torang_core.util.EventObserver
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReportAfterSupportFragment : Fragment() {

    private val reportViewModel: ReportViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding =
            FragmentReportAfterSupportBinding.inflate(layoutInflater, container, false).apply {
                viewModel = reportViewModel
                lifecycleOwner = viewLifecycleOwner
                reviewId = 1
            }
        (requireActivity() as AppCompatActivity).apply {
            setSupportActionBar(binding.toolbar2)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            binding.toolbar2.setNavigationOnClickListener {
                onBackPressed()
            }
        }
        subScribeUI()
        return binding.root
    }

    private fun subScribeUI() {
        reportViewModel.resultAfterSupport.observe(viewLifecycleOwner, EventObserver {
            if (it)
                requireActivity().finish()
        })
    }
}