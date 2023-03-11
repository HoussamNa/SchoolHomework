package com.example.devoirconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editTextAmount: EditText
    private lateinit var buttonMAD: Button
    private lateinit var buttonEUR: Button
    private lateinit var buttonUSD: Button
    private lateinit var textViewEUR: TextView
    private lateinit var textViewUSD: TextView

    private val exchangeRateMADtoEUR = 0.091
    private val exchangeRateMADtoUSD = 0.11
    private val exchangeRateEURtoMAD = 10.97
    private val exchangeRateUSDtoMAD = 9.09
    private val exchangeRateUSDtoEUR = 0.826
    private val exchangeRateEURtoUSD = 1.209

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextAmount = findViewById(R.id.editTextAmount);
        buttonMAD = findViewById(R.id.buttonMAD);
        buttonEUR = findViewById(R.id.buttonEUR);
        buttonUSD = findViewById(R.id.buttonUSD);
        textViewEUR = findViewById(R.id.textViewEUR);
        textViewUSD = findViewById(R.id.textViewUSD);

        fun convertToMAD(from: String) {
            val amountString = editTextAmount.text.toString()
            if (amountString.isEmpty()) {
                return
            }
            val amount = amountString.toDouble()
            val resultMAD = amount
            val resultEUR = amount * exchangeRateMADtoEUR
            val resultUSD = amount * exchangeRateMADtoUSD

            textViewEUR.text = String.format("EN EUR %.2f", resultEUR)
            textViewUSD.text = String.format("EN USD %.2f", resultUSD)
        }
        fun convertToEUR(from: String) {
            val amountString = editTextAmount.text.toString()
            if (amountString.isEmpty()) {
                return
            }
            val amount = amountString.toDouble()
            val resultMAD = amount * exchangeRateEURtoMAD
            val resultEUR = amount
            val resultUSD = resultEUR * exchangeRateEURtoUSD

            textViewEUR.text = String.format("EN MAD %.2f", resultMAD)
            textViewUSD.text = String.format("EN USD %.2f", resultUSD)
        }
        fun convertToUSD(from: String) {
            val amountString = editTextAmount.text.toString()
            if (amountString.isEmpty()) {
                return
            }
            val amount = amountString.toDouble()
            val resultMAD = amount * exchangeRateUSDtoMAD
            val resultEUR = amount * exchangeRateUSDtoEUR
            val resultUSD = amount

            textViewEUR.text = String.format("EN EUR %.2f", resultEUR)
            textViewUSD.text = String.format("EN MAD %.2f", resultMAD)
        }
        buttonMAD.setOnClickListener {
            convertToMAD("MAD")
        }

        buttonEUR.setOnClickListener {
            convertToEUR("EUR")
        }

        buttonUSD.setOnClickListener {
            convertToUSD("USD")
        }
    }
}