package com.example.quiz;


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun reset(view: View) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Reset")
        builder.setMessage("You want to reset?")


        builder.setPositiveButton("Yes") { dialogInterface, which ->
            btnt.setChecked(false)
            btnf.setChecked(false)
            ck.setChecked(false)
            ck1.setChecked(false)
            ck2.setChecked(false)


            Toast.makeText(applicationContext, "Reset done!", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }

        builder.setNegativeButton("No") { dialogInterface, which ->
            Toast.makeText(applicationContext, "Reset canceled!", Toast.LENGTH_SHORT).show()
        }

        builder.setNeutralButton("Exit"){ dialogInterface, which ->
            finish()
        }

        val dialog: AlertDialog = builder.create()

        dialog.show()



    }
    fun Submmit_btn(view: View) {
        var Recored = 0
        val c = Calendar.getInstance()

        val mDay = c.get(Calendar.DAY_OF_MONTH)
        val mYear = c.get(Calendar.YEAR)
        val mMonth = c.get(Calendar.MONTH)+1
        val time = c.get(Calendar.HOUR_OF_DAY)



        val builder = AlertDialog.Builder(this@MainActivity)

       builder.setTitle("Result")

        if(btnt?.isChecked== true){
            Recored = Recored + 50
        }
        if(ck?.isChecked == true
            || ck1?.isChecked == true
            || ck2?.isChecked == true){
            Recored = Recored + 50
        }

        if(Recored >= 50) {

            builder.setMessage(" Your "+ Recored+"%"+
                    '\n'+"Day "+mMonth+"/"+ mDay+ "/"+mYear + " Time:" +  time)

        }else
        {
            builder.setMessage("You Failed!! "+ Recored+"%"+
                    '\n'+"Day "+mMonth+"/"+ mDay+ "/"+mYear + " Time:" +  time)
        }

        builder.setPositiveButton("Yes")
        {
               dialogInterface,
         which ->
           Toast.makeText(applicationContext,
               "CLOSED ", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
            finish()
        }

        builder.setNegativeButton("Cancel")
        {
                dialogInterface,
                which ->
            Toast.makeText(applicationContext,
                "okay",Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }


        val dialog: AlertDialog = builder.create()

        dialog.show()
    }


}

