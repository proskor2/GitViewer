package dev.proskor.myapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.proskor.myapplication.R

class RepDetailFragment : Fragment() {

    companion object {
        fun newInstance() = RepDetailFragment()
    }

    private lateinit var viewModel: RepDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rep_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RepDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}