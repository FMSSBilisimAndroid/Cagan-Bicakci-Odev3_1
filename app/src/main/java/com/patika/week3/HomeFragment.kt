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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.v(PATIKA, "onCreateView called!")

        /**
         * when the emulator re rotated after onCreate method, the onCreateView called.
         * then set the [counter] value with the value that saved in Bundle
         * must check if its null because while running the app in first time it could be crash,
         * because it has no saved data into bundle in initial state.
         **/

        if (savedInstanceState != null){
            counter = savedInstanceState.getInt(COUNTER)
        }

        homeFragmentBinding = FragmentHomeBinding.inflate(inflater)
        return homeFragmentBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v(PATIKA, "onViewCreated called!")

        homeFragmentBinding.apply {

            /**
             * firstly we should set also text view value otherwise
             * it would shown as null even [counter] has a value from bundle
             *
             * also every time the counter value changed (increment or decrement),
             * updates text view again.
            **/

            tvCounter.text = getString(R.string.counter, counter)

            btnIncrement.setOnClickListener {
                counter++
                tvCounter.text = getString(R.string.counter, counter)
            }
            btnDecrement.setOnClickListener {
                counter--
                tvCounter.text = getString(R.string.counter, counter)
            }

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.v(PATIKA, "onSaveInstanceState called!")

        /**
         * when the emulator rotated horizontally firstly onSaveInstanceState called.
         * [counter] : counter variable
         * [COUNTER] : key to save into state, then call this keyword to get stored Integer.
         * * And here it saves by calling putInt() key and its value.
         **/

        outState.putInt(COUNTER, counter)
    }

}