package com.patika.week3

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.patika.week3.databinding.FragmentHomeBinding

const val COUNTER = "COUNTER_KEY"
const val PATIKA = "PATIKA"

class HomeFragment : Fragment() {

    private lateinit var homeFragmentBinding: FragmentHomeBinding
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) return
        counter = savedInstanceState.getInt(COUNTER)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Log.v(PATIKA, "onCreateView called!")

        homeFragmentBinding = FragmentHomeBinding.inflate(inflater)
        return homeFragmentBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v(PATIKA, "onViewCreated called!")

        homeFragmentBinding.apply {

            tvCounter.text = getString(R.string.counter, counter)

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
        Log.v(PATIKA, "onSaveInstanceState called!")

        outState.putInt(COUNTER,counter)
    }

}