package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(){
            val inputCarPrice = editTextCarPrice.text.toString()
            val inputDownPayment = editTextDownPayment.text.toString()
            val inputLoan = editTextLoanPeriod.text.toString()
            val inputInterest = editTextInterestRate.text.toString()

            val interestRate = inputInterest.toDouble() / 100

            val carLoan = inputCarPrice.toDouble() - inputDownPayment.toDouble()
            val interest = carLoan * interestRate * inputLoan.toDouble()
            val monthlyRepayment = (carLoan - interest) / inputLoan.toDouble() / 12

            textViewLoan.setText("Loan : RM%.2f".format(carLoan))
            textViewInterest.setText("Interest : RM%.2f".format(interest))
            textViewMonthlyRepayment.setText("Monthly Repayment : RM%.2f".format(monthlyRepayment))
        }

        buttonReset.setOnClickListener(){
            editTextCarPrice.setText("")
            editTextDownPayment.setText("")
            editTextLoanPeriod.setText("")
            editTextInterestRate.setText("")
        }
    }
}
