package com.kardibus.github.ui.users

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.kardibus.github.AppConstants
import com.kardibus.github.BR
import com.kardibus.github.R
import com.kardibus.github.ViewModelProviderFactory
import com.kardibus.github.data.model.TotalCount
import com.kardibus.github.databinding.FragmentUserBinding
import com.kardibus.github.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_user.*
import javax.inject.Inject

class UsersFragment : BaseFragment<FragmentUserBinding, UsersViewModel>(),
    UsersNavigator, UsersItemViewModel.ArticleItemViewModelListener {
    @Inject
    lateinit var factory: ViewModelProviderFactory
    lateinit var usersAdapter: UsersAdapter
    private var usersViewModel: UsersViewModel? = null
    private var page:Int = 1


    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_user

    override val viewModel: UsersViewModel
        get() {
            usersViewModel = ViewModelProvider(this, factory).get(UsersViewModel::class.java)
            return usersViewModel as UsersViewModel
        }

    override fun onRetryClick() {

    }


    override fun onItemClick(item: UsersDataItem) {
        val bundle = Bundle()
        bundle.putParcelable(
            AppConstants.USER,
            item
        )
        getNavController().navigate(R.id.action_articleFragment_to_articleDetailsFragment, bundle)
    }

    override fun handleError(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun setData(data: List<UsersDataItem>) {
        usersAdapter.clearItems()
        usersAdapter.addItems(data)
    }

    override fun search() {
        viewModel.fetchUsers(txt_user_search.text.toString(),page = 1,30)
    }

    override fun more() {
        ++page
        viewModel.fetchUsers(txt_user_search.text.toString(),page = page,30)
    }

    override fun back() {
        --page
        viewModel.fetchUsers(txt_user_search.text.toString(),page = page,30)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usersViewModel?.setNavigator(this)
        usersAdapter = UsersAdapter(arrayListOf(), this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
        setHasOptionsMenu(false)
        val typeface = ResourcesCompat.getFont(requireActivity().applicationContext, R.font.regular)
        toolbar_title.run {
            toolbar_title.run { toolbar_title.typeface = typeface }
        }

    }

    private fun setUp() {
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        getViewDataBinding().resultsBeanRecyclerView.layoutManager = LinearLayoutManager(activity)
        getViewDataBinding().resultsBeanRecyclerView.itemAnimator = DefaultItemAnimator()
        getViewDataBinding().resultsBeanRecyclerView.adapter = usersAdapter
    }
}