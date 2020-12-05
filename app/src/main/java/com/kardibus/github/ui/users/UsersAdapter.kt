package com.kardibus.github.ui.users

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.kardibus.core.ui.BaseRecyclerViewAdapter
import com.kardibus.core.ui.BaseViewHolder
import com.kardibus.github.R
import com.kardibus.github.databinding.ItemUserViewBinding

class UsersAdapter(items: MutableList<UsersDataItem>, listener: UsersItemViewModel.ArticleItemViewModelListener) :
    BaseRecyclerViewAdapter<UsersDataItem>(items, listener) {

    private lateinit var context: Context

    override fun getItemCount(): Int=items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        context=parent.context
        return ArticleViewHolder(
            ItemUserViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    inner class ArticleViewHolder(private val mBinding: ItemUserViewBinding) :
        BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            val user = items[position]
            mBinding.viewModel = UsersItemViewModel(user, onItemClick = { itemListener.onItemClick(user) })
            val typeface = ResourcesCompat.getFont(context, R.font.bold)
            mBinding.authorTextView.setTypeface(typeface)
            mBinding.executePendingBindings()
        }
    }


}