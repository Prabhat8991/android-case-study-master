package com.target.targetcasestudy.ui.dealslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.target.targetcasestudy.R
import com.target.targetcasestudy.databinding.FragmentDealListBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DealListFragment : DaggerFragment() {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val binding = FragmentDealListBinding.inflate(inflater)
    val viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(DealsViewModel::class.java)
    viewModel.dealDomainModel.observe(requireActivity(), Observer {
      binding.recyclerView.adapter = DealItemAdapter(it, onDealClickListener = OnDealsClickListener {dealDomainModel ->
        viewModel.setSelectedDealModel(dealDomainModel)
        findNavController().navigate(R.id.action_dealListFragment_to_dealItemFragment)
      })
    })
    binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    return binding.root
  }
}
