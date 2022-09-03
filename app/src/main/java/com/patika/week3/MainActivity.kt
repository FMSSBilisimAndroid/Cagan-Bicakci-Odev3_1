package com.patika.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // Log.v("PATIKADEV","onCreate called.")
    }

    /*
    override fun onStart() {
        super.onStart()
        Log.v("PATIKADEV","onStart called.")
    }

    override fun onResume() {
        super.onResume()
        Log.v("PATIKADEV","onResume called.")
    }

    override fun onPause() {
        super.onPause()
        Log.v("PATIKADEV","onPause called.")
    }

    override fun onStop() {
        super.onStop()
        Log.v("PATIKADEV","onStop called.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("PATIKADEV","onRestart called.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("PATIKADEV","onDestroy called.")
    }*/



}