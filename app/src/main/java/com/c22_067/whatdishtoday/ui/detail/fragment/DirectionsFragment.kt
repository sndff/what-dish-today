package com.c22_067.whatdishtoday.ui.detail.fragment

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.c22_067.whatdishtoday.databinding.FragmentDirectionsBinding
import com.c22_067.whatdishtoday.ui.detail.DetailViewModel

class DirectionsFragment : Fragment() {

    private lateinit var binding: FragmentDirectionsBinding
    private val viewModel: DetailViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentDirectionsBinding.inflate(LayoutInflater.from(context))
        val key = requireArguments().getString("key")
        binding.progressBar.visibility = View.VISIBLE
        viewModel.getDetail(key!!)
        viewModel.repository.detail.observeForever { detail ->
            val builder = SpannableStringBuilder()
            if (detail != null) {
                detail.step?.forEach { steps ->
                    builder.append(steps + "\n\n")
                }
            }
            binding.tvSteps.text = builder
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    fun launchFragment(key: String?): DirectionsFragment {
        val fragment = DirectionsFragment()
        val bundle = Bundle().apply {
            putString("key", key)
        }
        fragment.arguments = bundle

        return fragment
    }
}