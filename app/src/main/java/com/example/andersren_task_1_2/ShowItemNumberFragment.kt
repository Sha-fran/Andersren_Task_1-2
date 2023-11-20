package com.example.andersren_task_1_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.andersren_task_1_2.databinding.ShowNumberOfFragmentBinding

const val TAG = "dialog"

class ShowItemNumberFragment : DialogFragment() {
    private var _binding : ShowNumberOfFragmentBinding? = null
    val binding get() = _binding!!

    companion object {
        fun newInstance() = ShowItemNumberFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showsDialog = true
        isCancelable = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ShowNumberOfFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
