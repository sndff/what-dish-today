package com.c22_067.whatdishtoday.ui.home.home_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.c22_067.whatdishtoday.adapter.RecipeListsAdapter
import com.c22_067.whatdishtoday.databinding.FragmentHomeAllBinding

class HomeAllFragment : Fragment() {

    private var viewModel = HomeViewModel()

    private lateinit var _binding: FragmentHomeAllBinding
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeAllBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[HomeViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val result = viewModel.getAllRecipes()
        binding.rvMainCategory.adapter = RecipeListsAdapter(requireContext(), result)
    }

    fun launchFragment(): HomeAllFragment {
        return HomeAllFragment()
    }

}