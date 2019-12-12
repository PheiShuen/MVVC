package com.example.mvvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import java.util.zip.CheckedOutputStream

class MainActivity : AppCompatActivity() {

    //Declare module variable
    private lateinit var countViewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MVVC","onCreate")

        //Initialized the viewModel
        countViewModel = ViewModelProviders.of(this)
            .get(CountViewModel::class.java)

        //Add observer
        countViewModel.count.observe(
            this,
            Observer{
                if(it.equals(10)) goodLuck()
            }
        )

        textViewCounter.text = countViewModel.count.value.toString()

        buttonPlus.setOnClickListener {
            countViewModel.increment()
            textViewCounter.text = countViewModel.count.value.toString()
        }

        buttonMinus.setOnClickListener {
            countViewModel.decrement()
            textViewCounter.text = countViewModel.count.value.toString()
        }

    }

    private fun goodLuck(){
        Toast.makeText(this,
            "Good Luck!!",
            Toast.LENGTH_SHORT)
            .show()
    }

    override fun onDestroy() {
        Log.d("MVVC","onCreate")
        super.onDestroy()
    }
}
