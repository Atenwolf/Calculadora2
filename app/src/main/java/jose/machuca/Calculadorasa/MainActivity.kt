package jose.machuca.Calculadorasa

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var total = 0.0
    var validacion = true
    var operacion = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun ingresarNum(numero: String) {
        val txtOpe: TextView = findViewById(R.id.txtOpe)
        if (txtOpe.text == "0" || !validacion) {
            txtOpe.text = numero
        } else {
            txtOpe.text = "" + txtOpe.text + numero
        }

        validacion = true
    }

    fun historial() {
        val txtHis: TextView = findViewById(R.id.txtHis)
        val txtOpe: TextView = findViewById(R.id.txtOpe)
        if (validacion) {
            txtHis.text = "" + txtHis.text + txtOpe.text + operacion
            validacion = false
            txtOpe.text = "0"
        }
    }

    fun operacion() {
        val txtOpe: TextView = findViewById(R.id.txtOpe)
        val numero = txtOpe.text.toString().toDouble() //

        when (operacion) {
            "+" -> total += numero
            "-" -> total -= numero
            "*" -> total *= numero
            "/" -> {
                if (numero != 0.0) {
                    total /= numero
                } else {
                    // Mostrar un Toast para manejar la división por cero
                    Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show()
                }
            }
            else -> total = numero
        }
    }

    fun clickNum0(view: View) {
        ingresarNum("0")
    }

    fun clickNum1(view: View) {
        ingresarNum("1")
    }

    fun clickNum2(view: View) {
        ingresarNum("2")
    }

    fun clickNum3(view: View) {
        ingresarNum("3")
    }

    fun clickNum4(view: View) {
        ingresarNum("4")
    }

    fun clickNum5(view: View) {
        ingresarNum("5")
    }

    fun clickNum6(view: View) {
        ingresarNum("6")
    }

    fun clickNum7(view: View) {
        ingresarNum("7")
    }

    fun clickNum8(view: View) {
        ingresarNum("8")
    }

    fun clickNum9(view: View) {
        ingresarNum("9")
    }

    fun sumar(view: View) {
        operacion()
        if (validacion) {
            operacion = "+"
        }
        historial()
    }

    fun restar(view: View) {
        operacion()
        if (validacion) {
            operacion = "-"
        }
        historial()
    }

    fun multiplicar(view: View) {
        operacion()
        if (validacion) {
            operacion = "*"
        }
        historial()
    }

    fun dividir(view: View) {
        operacion()
        if (validacion) {
            operacion = "/"
        }
        historial()
    }

    fun igual(view: View) {
        operacion()
        val txtHis: TextView = findViewById(R.id.txtHis)
        val txtOpe: TextView = findViewById(R.id.txtOpe)
        if (validacion) {
            txtHis.text = "" + txtHis.text + txtOpe.text + operacion
            txtOpe.text = total.toString()
            txtHis.text = ""
            operacion = ""
            total = 0.0
        }
    }

    fun borrar(view: View) {
        val txtHis: TextView = findViewById(R.id.txtHis)
        val txtOpe: TextView = findViewById(R.id.txtOpe)
        txtHis.text = ""
        txtOpe.text = "0"
        operacion = ""
        total = 0.0
        validacion = true
    }
}

