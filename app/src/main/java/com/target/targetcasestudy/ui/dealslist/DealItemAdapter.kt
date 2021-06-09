package com.target.targetcasestudy.ui.dealslist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.target.targetcasestudy.databinding.DealListItemBinding
import com.target.targetcasestudy.domain.model.response.DealDomainModel

class DealItemAdapter(private val domainModelList: List<DealDomainModel>, val onDealClickListener: OnDealsClickListener) : RecyclerView.Adapter<DealItemViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealItemViewHolder {
    return DealItemViewHolder.from(parent)
  }

  override fun getItemCount(): Int {
    return domainModelList.size
  }

  override fun onBindViewHolder(viewHolder: DealItemViewHolder, position: Int) {
    viewHolder.bind(domainModelList[position], onDealClickListener)
  }
}

class DealItemViewHolder(private val viewBinding: DealListItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {
  fun bind(dealDomainModel: DealDomainModel, onDealClickListener: OnDealsClickListener) {
    viewBinding.dealItem = dealDomainModel
    viewBinding.dealItemClickListener = onDealClickListener
    viewBinding.executePendingBindings()
  }

  companion object {
    fun from(parent: ViewGroup): DealItemViewHolder {
      val layoutInflater = LayoutInflater.from(parent.context)
      val binding = DealListItemBinding.inflate(layoutInflater, parent, false)
      return DealItemViewHolder(binding)
    }
  }

}

class OnDealsClickListener(val onClickListener: (dealDomainModel: DealDomainModel) -> Unit) {
  fun onItemClicked(dealDomainModel: DealDomainModel) = onClickListener(dealDomainModel)
}