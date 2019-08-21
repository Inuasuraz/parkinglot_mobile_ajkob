package buu.informatics.s59160081.parkinglot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160081.parkinglot.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.ButtonOne.setOnClickListener{

        }

        binding.ButtonTwo.setOnClickListener{

        }

        binding.ButtonThree.setOnClickListener{

        }

    }


}
