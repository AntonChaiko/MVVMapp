package com.example.mvvmapp.ui.screens.viewfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mvvmapp.R
import com.example.mvvmapp.databinding.FragmentViewBinding
import com.example.mvvmapp.room.PersonsViewModel
import com.example.mvvmapp.ui.base.BaseFragment


class ViewFragment : BaseFragment<FragmentViewBinding, ViewFragmentViewModel>() {

    private val model: ViewFragmentViewModel by viewModels()
    private val personsViewModel: PersonsViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun getFragmentView(): Int = R.layout.fragment_view

    override fun getViewModel(): Class<ViewFragmentViewModel> = ViewFragmentViewModel::class.java
}
