package dk.cphbusiness.template

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import dk.cphbusiness.template.numbers.Rational
import dk.cphbusiness.template.numbers.rational
import kotlinx.android.synthetic.main.activity_rational.*
import org.jetbrains.anko.onClick

class RationalActivity : Activity() {
    var t = Rational(0, 1)
    var z = Rational(0, 1)
    var y = Rational(0, 1)
    var x = Rational(0, 1)

    fun update() {
        tField.text = t.text
        zField.text = z.text
        yField.text = y.text
        xField.text = x.text
        }

    fun push(number: Rational) {
        t = z
        z = y
        y = x
        x = number
        update()
        }

    fun push(number: Int) { push(number.rational) }

    fun pop(): Rational {
        val r = x
        x = y
        y = z
        z = t
        return r
        }

    fun isNumber(part: String): Boolean {
        for (digit in part) if (!(digit in '0'..'9')) return false
        return true
        }

    fun plus() {
        val b = pop()
        val a = pop()
        val r = a + b
        push(r)
        }

    fun div() {
        val b = pop()
        val a = pop()
        val r = a/b
        push(r)
        }

    fun handle(part: String) {
        when {
            isNumber(part) -> {
                val n = part.toInt()
                push(n)
                }
            part == "+" -> plus()
            part == "/" -> div()
            else -> xField.text = "ups ${part}"
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rational)
        val b = findViewById(R.id.okButton) as Button

        okButton.onClick {
            val parts = inputText.text.split(" ")
            for (part in parts) handle(part)
            inputText.setText("")
            }
        }

    }
