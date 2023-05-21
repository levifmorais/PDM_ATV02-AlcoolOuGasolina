package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var percentual:Double = 0.7
    private lateinit var txtResultado: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtResultado = findViewById(R.id.textResultado)

        if (savedInstanceState != null) {
            percentual=savedInstanceState.getDouble("percentual")
            txtResultado.text = savedInstanceState.getString("resultado")
        }
        Log.d("PDM23","No onCreate, $percentual")

        val btCalc: Button = findViewById(R.id.btCalcular)
        btCalc.setOnClickListener(View.OnClickListener {
            //código do evento
            //percentual=0.75
            val edAlcool= findViewById<EditText>(R.id.edAlcool).text.toString().toDoubleOrNull()
            val edGas= findViewById<EditText>(R.id.edGasolina).text.toString().toDoubleOrNull()
            var debugg = 0.0
            if (edAlcool != null && edGas != null) {
                debugg = edGas * percentual
                if (edAlcool <= edGas * percentual) {
                    txtResultado.text = getString(R.string.alcool)
                }
                else {
                    txtResultado.text = getString(R.string.gasolina)
                }
            }
            else {
                txtResultado.text = getString(R.string.valores_invalidos)
            }

            Log.d("PDM23","No btCalcular, $percentual")
        })

        val btSwitch: Switch = findViewById(R.id.swPercentual)
        btSwitch.setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked) {
                percentual = 0.75
            }
            else {
                percentual = 0.7
            }
            Log.d("PDM23","No Switch, $percentual")
        }

    }
override fun onResume(){
    super.onResume()
    Log.d("PDM23","No onResume, $percentual")
}
override fun onStart(){
    super.onStart()
    Log.d("PDM23","No onResume")
}
override fun onPause(){
    super.onPause()
    Log.d("PDM23","No onResume")
}
override fun onStop(){
    super.onStop()
    Log.d("PDM23","No onResume")
}
override fun onDestroy(){
    super.onDestroy()
    Log.d("PDM23","No onResume")
}
fun onClickBtCalcular(v: View) {
        //código do evento
        percentual = 0.75
        Log.d("PDM23", "No onClick, $percentual")
}
override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("percentual",percentual)
        outState.putString("resultado", txtResultado.text.toString())
}
}