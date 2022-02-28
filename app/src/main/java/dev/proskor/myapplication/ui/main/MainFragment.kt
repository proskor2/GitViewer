package dev.proskor.myapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dev.proskor.myapplication.R
import dev.proskor.myapplication.data.AdapterRepositories
import dev.proskor.myapplication.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    val adapter = AdapterRepositories()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = MainFragmentBinding.inflate(layoutInflater)
        binding.recyclerMyreps.adapter = adapter
        viewModel.repoList.observe(viewLifecycleOwner, Observer {
            adapter.setReposList(it)
            Toast.makeText(view.context, "Test OK", Toast.LENGTH_LONG).show()
        })
        viewModel.getRepos()
        return view
    }

}