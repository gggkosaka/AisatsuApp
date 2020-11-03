package jp.techacademy.genki.kosaka.aisatsuapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.app.TimePickerDialog
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        /*
        button1.setOnClickListener {
            Log.d("UI_PARTS", "ボタンをタップしました")
        }
        textView.text = "テキスト"

         */
    }

    override fun onClick(v: View) {
        showTimePickerDialog()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")

                //要件ではminuteは不要だったので、hourのみで判定
                if (hour >= 2 && hour <= 9){
                    textView.text = "おはよう"
                }else if (hour >= 2 && hour <= 17){
                    textView.text = "こんにちは"
                }else{
                    textView.text = "こんばんは"
                }
            },
            23, 0, true)
        timePickerDialog.show()
    }
}