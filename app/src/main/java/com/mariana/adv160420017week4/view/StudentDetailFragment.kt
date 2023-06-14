package com.mariana.adv160420017week4.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mariana.adv160420017week4.R
import com.mariana.adv160420017week4.databinding.FragmentStudentDetailBinding
import com.mariana.adv160420017week4.util.loadImage
import com.mariana.adv160420017week4.viewmodel.DetailViewModel
import com.mariana.adv160420017week4.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_list.*

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel:DetailViewModel
    private lateinit var dataBinding: FragmentStudentDetailBinding

    fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it

            dataBinding.listener = object : ButtonUpdateClickListener {
                override fun onButtonUpdatelClick(v: View) {
                    TODO("Not yet implemented")
                }

            }

//            imageView2.loadImage(it.photoUrl, progressBar2)
//            txtID.setText(it.id)
//            txtName.setText(it.name)
//            txtBod.setText(it.dob)
//            txtPhone.setText(it.phone)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_student_detail, container, false)
        return dataBinding.root
//        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = StudentDetailFragmentArgs.fromBundle(requireArguments()).id

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(id)

        observeViewModel()
    }
}