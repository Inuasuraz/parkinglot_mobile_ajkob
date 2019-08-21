package buu.informatics.s59160081.parkinglot

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160081.parkinglot.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var Lot_One: Parking = Parking("","","")
    private var Lot_Two: Parking = Parking("","","")
    private var Lot_Three: Parking = Parking("","","")
    private var select = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.ButtonUpdate.visibility = View.GONE
        binding.ButtonDelete.visibility = View.GONE

        binding.ButtonOne.setOnClickListener{
            select = 1
            show(select)

        }

        binding.ButtonTwo.setOnClickListener{
            select = 2
            show(select)
        }

        binding.ButtonThree.setOnClickListener{
            select = 3
            show(select)
        }

        binding.ButtonUpdate.setOnClickListener{
            update(it)
        }

        binding.ButtonDelete.setOnClickListener{
            delete(it)
        }

    }


    private fun update(view: View){
        if (select == 1){
            if (License.text.toString().replace("\\s".toRegex(), "").length < 1 &&
                    Name.text.toString().replace("\\s".toRegex(), "").length < 1 &&
                    Phone.text.toString().replace("\\s".toRegex(), "").length < 1){
                alert(1)
            }else{
                Lot_One.license = License.text.toString()
                Lot_One.name = Name.text.toString()
                Lot_One.phone = Phone.text.toString()
                binding.ButtonOne.setBackgroundColor(Color.parseColor("#c94f59"))
                alert(2)
            }

        }else if (select == 2){
            if (License.text.toString().replace("\\s".toRegex(), "").length < 1 &&
                Name.text.toString().replace("\\s".toRegex(), "").length < 1 &&
                Phone.text.toString().replace("\\s".toRegex(), "").length < 1){
                alert(1)
            }else{
                Lot_Two.license = License.text.toString()
                Lot_Two.name = Name.text.toString()
                Lot_Two.phone = Phone.text.toString()
                binding.ButtonTwo.setBackgroundColor(Color.parseColor("#c94f59"))
                alert(2)
            }
        }else if (select == 3){
            if (License.text.toString().replace("\\s".toRegex(), "").length < 1 &&
                Name.text.toString().replace("\\s".toRegex(), "").length < 1 &&
                Phone.text.toString().replace("\\s".toRegex(), "").length < 1){
                alert(1)
            }else{
                Lot_Three.license = License.text.toString()
                Lot_Three.name = Name.text.toString()
                Lot_Three.phone = Phone.text.toString()
                binding.ButtonThree.setBackgroundColor(Color.parseColor("#c94f59"))
                alert(2)
            }
        }
    }

    private fun delete(view : View){
        if (select == 1){
            Lot_One.license = ""
            Lot_One.name = ""
            Lot_One.phone = ""
            alert(3)
        }else if (select == 2){
            Lot_Two.license = ""
            Lot_Two.name = ""
            Lot_Two.phone = ""
            alert(3)
        }else if (select == 3){
            Lot_Three.license = ""
            Lot_Three.name = ""
            Lot_Three.phone = ""
            alert(3)
        }
    }

    private fun show(lot : Int){

        setBackground()
        if (lot == 1){
            if (!Lot_One.license.equals("")){
                binding.ButtonOne.setBackgroundColor(Color.parseColor("#c94f59"))
                License.setText(Lot_One.license)
                Name.setText(Lot_One.name)
                Phone.setText(Lot_One.phone)
            }else{
                binding.ButtonOne.setBackgroundColor(Color.parseColor("#48a3b0"))
            }

        }else if (lot == 2){
            if (!Lot_Two.license.equals("")){
                binding.ButtonTwo.setBackgroundColor(Color.parseColor("#c94f59"))
                License.setText(Lot_Two.license)
                Name.setText(Lot_Two.name)
                Phone.setText(Lot_Two.phone)
            }else{
                binding.ButtonTwo.setBackgroundColor(Color.parseColor("#48a3b0"))
            }
        }else if (lot == 3){

            if (!Lot_Three.license.equals("")){
                binding.ButtonThree.setBackgroundColor(Color.parseColor("#c94f59"))
                License.setText(Lot_Three.license)
                Name.setText(Lot_Three.name)
                Phone.setText(Lot_Three.phone)
            }else{
                binding.ButtonThree.setBackgroundColor(Color.parseColor("#48a3b0"))
            }

        }
    }

    private fun setBackground(){
        binding.ButtonUpdate.visibility = View.VISIBLE
        binding.ButtonDelete.visibility = View.VISIBLE

        if (!Lot_One.license.equals("")){
            binding.ButtonOne.setBackgroundColor(Color.parseColor("#ff6673"))
        }else{
            binding.ButtonOne.setBackgroundColor(Color.parseColor("#66E8FA"))
        }

        if (!Lot_Two.license.equals("")){
            binding.ButtonTwo.setBackgroundColor(Color.parseColor("#ff6673"))
        }else{
            binding.ButtonTwo.setBackgroundColor(Color.parseColor("#66E8FA"))
        }

        if (!Lot_Three.license.equals("")){
            binding.ButtonThree.setBackgroundColor(Color.parseColor("#ff6673"))
        }else{
            binding.ButtonThree.setBackgroundColor(Color.parseColor("#66E8FA"))
        }

    }

    private fun alert(operation : Int){
        val dialogBuilder= AlertDialog.Builder(this)
        if (operation == 1){
            dialogBuilder.setTitle("Alert")
            dialogBuilder.setMessage("Please fill up all the box")
            dialogBuilder.setPositiveButton("Close"){ dialogInterface: DialogInterface, i: Int -> Unit }

            dialogBuilder.create().show()
        }else if (operation == 2){
                Toast.makeText(this,"Update complete",Toast.LENGTH_LONG).show()
        }else if (operation == 3){
                Toast.makeText(this,"Delete complete",Toast.LENGTH_LONG).show()
        }

    }

}
