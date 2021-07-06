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
        viewModel.removeAll()

        binding.syncStaffButton.setOnClickListener {
            viewModel.insertAll()
            binding.syncStaffButton.visibility = View.GONE
            binding.recycler.visibility = View.VISIBLE
            setAdapter()
        }
        binding.swipeLayout.setOnRefreshListener {
            setAdapter()
            binding.swipeLayout.isRefreshing = false
        }
    }

    private fun setAdapter() {
        viewModel.getEmployeeLiveData().observe(viewLifecycleOwner, {
            val adapter = ViewFragmentAdapter()
            adapter.submitList(it)
            binding.recycler.adapter = adapter
        })
    }

    override fun getFragmentView(): Int = R.layout.fragment_view

    override fun getViewModel(): Class<ViewFragmentViewModel> = ViewFragmentViewModel::class.java
}
