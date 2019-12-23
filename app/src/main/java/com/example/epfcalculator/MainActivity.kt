package com.example.epfcalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtDOB.setOnClickListener(){
            val c:Calendar = Calendar.getInstance();
            val currentDay = c.get(Calendar.DAY_OF_MONTH);
            val currentMonth = c.get(Calendar.MONTH);
            val currentYear = c.get(Calendar.YEAR);
            var saving = 0;

            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{
                    view, year, month, day ->
                        txtDOB.setText(day.toString() + "/" +
                                        (month + 1).toString() + "/" +
                                            year.toString())
                    val curAge = currentYear - year;

                    txtAge.text = curAge.toString() + " years old";

                    when(curAge){
                        in 16..20 -> saving = 5000
                        in 21..25 -> saving = 14000
                        in 26..30 -> saving = 29000
                        in 31..35 -> saving = 50000
                        in 36..40 -> saving = 78000
                        in 41..45 -> saving = 116000
                        in 46..50 -> saving = 165000
                        in 51..55 -> saving = 228000
                    }

                    txtSaving.text = "RM " + saving.toString() + ".00";
                    txtAmount.text = "RM " + (saving * 0.3).toInt() + ".00";
                },currentYear, currentMonth, currentDay)

            dpd.show()
        }
    }


}
