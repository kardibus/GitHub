package com.kardibus.github.ui.userdetails

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import com.kardibus.github.AppConstants
import com.kardibus.github.ViewModelProviderFactory
import com.kardibus.github.ui.users.UsersDataItem
import com.kardibus.github.ui.base.BaseFragment
import com.kardibus.github.BR
import com.kardibus.github.R
import com.kardibus.github.databinding.FragmentUserDetailsBinding
import kotlinx.android.synthetic.main.fragment_user_details.*
import javax.inject.Inject

class UserDetailsFragment :
    BaseFragment<FragmentUserDetailsBinding, UserDetailsViewModel>(),
    UserDetailsNavigator {
    @Inject
    lateinit var factory: ViewModelProviderFactory
    private var userDetailsViewModel: UserDetailsViewModel? = null
    private var usersDataItem: UsersDataItem? = null
    private var userDetailDataItem:UserDetailDataItem?=null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_user_details

    override val viewModel: UserDetailsViewModel
        get() {
            userDetailsViewModel =
                ViewModelProvider(this, factory).get(UserDetailsViewModel::class.java)
            return userDetailsViewModel as UserDetailsViewModel
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userDetailsViewModel?.setNavigator(this)
        if (arguments != null) {
            usersDataItem = arguments?.getParcelable(AppConstants.USER)
            viewModel.fetchUsers(usersDataItem?.login.toString())
        }
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setUp()

        val typefaceBold = ResourcesCompat.getFont(requireActivity().applicationContext, R.font.bold)
        titleTextView.run {
            titleTextView.run { titleTextView.typeface = typefaceBold }
        }
        val typefaceRegurlar = ResourcesCompat.getFont(requireActivity().applicationContext, R.font.regular)
        authorTextView.run {
            authorTextView.run { authorTextView.typeface = typefaceRegurlar }
        }
        contentTextView.run {
            contentTextView.run { contentTextView.typeface = typefaceRegurlar }
        }
        dateTextView.run {
            dateTextView.run { dateTextView.typeface = typefaceRegurlar }
        }
    }

    private fun setUp() {
        setUpToolbar()
        setUser()

    }

    private fun setUser() {

    }

    private fun setUpToolbar() {
        getViewDataBinding().toolbar.setNavigationOnClickListener {
            if (activity != null) {
                activity?.onBackPressed()
            }
        }
    }

    override fun handleError(message: String?) {
        TODO("Not yet implemented")
    }

    override fun setData(data: List<Any>) {
            getViewDataBinding().user = data.get(0) as UserDetailDataItem?
    }
}