package com.c22_067.whatdishtoday.ui.detail

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.c22_067.whatdishtoday.databinding.FragmentIngredientsBinding

class IngredientsFragment : Fragment() {

    private lateinit var binding: FragmentIngredientsBinding
    private val viewModel: DetailViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentIngredientsBinding.inflate(LayoutInflater.from(context))
        val key = requireArguments().getString("key")
        binding.progressBar.visibility = View.VISIBLE
        viewModel.getDetail(key!!)
        viewModel.repository.detail.observeForever { detail ->
            val builder = SpannableStringBuilder()
            if (detail != null) {
                detail.ingredient?.forEach { ingredient ->
                    builder.append(ingredient + "\n")
                }
            }
            binding.tvIngredients.text = builder
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    fun launchFragment(key: String?): IngredientsFragment {
        val fragment = IngredientsFragment()
        val bundle = Bundle().apply {
            putString("key", key)
        }
        fragment.arguments = bundle

        return fragment
    }
}