package es.uji.al416637.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    lateinit var celsiusEditText: EditText
    lateinit var farenheitEditText: EditText
    private var changing = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        celsiusEditText = findViewById(R.id.celsiusEditText)
        celsiusEditText.addTextChangedListener {
            if(!changing) {
                changing = true
                onCelsiusChanged(it.toString())
                changing = false
            }
        }

        farenheitEditText = findViewById(R.id.farenheitEditText)
        farenheitEditText.addTextChangedListener {
            if(!changing) {
                changing = true
                onFarenheitChanged(it.toString())
                changing = false
            }
        }
    }

    private fun onCelsiusChanged(celsiusString: String) {
        val celsius = celsiusString.toDoubleOrNull()
        if(celsius == null)
            farenheitEditText.setText("")
        else {
            val farenheit = celsius / 100 * 180 + 32
            farenheitEditText.setText(farenheit.toString())
        }
    }

    private fun onFarenheitChanged(farenheitString: String) {
        val farenheit = farenheitString.toDoubleOrNull()
        if(farenheit == null)
            celsiusEditText.setText("")
        else {
            val celsius = (farenheit - 32) / 180 * 100
            celsiusEditText.setText(celsius.toString())
        }
    }
}