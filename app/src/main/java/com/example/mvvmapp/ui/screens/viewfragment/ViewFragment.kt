package com.example.mvvmapp.ui.screens.viewfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.example.domain.model.EmployeeModel
import com.example.mvvmapp.R
import com.example.mvvmapp.common.base.BaseFragment
import com.example.mvvmapp.databinding.FragmentViewBinding
import com.example.mvvmapp.ui.screens.viewfragment.adapter.ViewFragmentAdapter


class ViewFragment : BaseFragment<FragmentViewBinding, ViewFragmentViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.list.observe(viewLifecycleOwner, { it ->
            setAdapter(it)
            it.forEach { Log.d("asd", it.email) }
        })
        viewModel.getEmployeeLiveData().observe(viewLifecycleOwner,{
            setAdapter(it)
        })
    }

    fun setAdapter(list: List<EmployeeModel>) {
        val adapter = ViewFragmentAdapter()
        adapter.submitList(list)
        binding.recycler.adapter = adapter
    }

    override fun getFragmentView(): Int = R.layout.fragment_view

    override fun getViewModel(): Class<ViewFragmentViewModel> = ViewFragmentViewModel::class.java
}
