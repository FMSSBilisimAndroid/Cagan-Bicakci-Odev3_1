package com.patika.week3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.patika.week3.databinding.FragmentHomeBinding

const val COUNTER = "COUNTER"

class HomeFragment : Fragment() {

    private lateinit var homeFragmentBinding: FragmentHomeBinding
    private var counter = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Log.v("PATIKA", "onCreateView called!")

        homeFragmentBinding = FragmentHomeBinding.inflate(inflater)
        return homeFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val counterFromSavedState = savedInstanceState?.getInt(COUNTER)
        homeFragmentBinding.tvCounter.text = getString(R.string.counter, counterFromSavedState)

        Log.v("PATIKA", "onViewCreated called!")

        homeFragmentBinding.apply {
            btnIncrement.setOnClickListener{
                counter++
                tvCounter.text = getString(R.string.counter, counter)
            }
            btnDecrement.setOnClickListener{
                counter--
                tvCounter.text = getString(R.string.counter, counter)
            }

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNTER,counter)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

}