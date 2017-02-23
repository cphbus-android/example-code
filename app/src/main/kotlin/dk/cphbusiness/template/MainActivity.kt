package dk.cphbusiness.template

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.toast


class MainActivity : Activity() {

    val Int.text: String
        get() = getString(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = "Hello from Kotlin"
        button1.onClick { toast("Button 1 was clicked") }
        Log.d("KAT", "created")
//        val wt = getString(R.string.warningText)
        Log.w("KAT", "Integer value = ${R.string.warningText}")
        Log.w("KAT", R.string.warningText.text)
/*
        <resources>
            <string name="buttonText">Tryk her</string>
            <string name="warningText">Uha uha</string>
        </resources>
*/
        }

    override fun onStart() {
        super.onStart()
        Log.d("KAT", "started")
        }

    override fun onResume() {
        super.onResume()
        }

    override fun onPause() {
        super.onPause()
        }

    override fun onStop() {
        super.onStop()
        }

    fun button2Clicked(view: View) {
        message.text = "Button 2 was clicked"
        }

    }
