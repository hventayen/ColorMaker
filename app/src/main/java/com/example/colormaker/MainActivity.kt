package com.example.colormaker

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var view: View
    private lateinit var reset: Button
    private lateinit var sb_red: SeekBar
    private lateinit var sb_green: SeekBar
    private lateinit var sb_blue: SeekBar
    private lateinit var et_red: EditText
    private lateinit var et_green: EditText
    private lateinit var et_blue: EditText
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var sw_red: Switch
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var sw_green: Switch
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var sw_blue: Switch
    var red = 0
    var green = 0
    var blue = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        view = findViewById(R.id.view)
        reset = findViewById(R.id.reset)

        sb_red = findViewById(R.id.sb_red)
        sb_green = findViewById(R.id.sb_green)
        sb_blue = findViewById(R.id.sb_blue)

        et_red = findViewById(R.id.et_red)
        et_green = findViewById(R.id.et_green)
        et_blue = findViewById(R.id.et_blue)

        sw_red = findViewById<Switch>(R.id.sw_red)
        sw_green = findViewById<Switch>(R.id.sw_green)
        sw_blue = findViewById<Switch>(R.id.sw_blue)

        sb_red.progress = 0
        sb_green.progress = 0
        sb_blue.progress = 0

        view.setBackgroundColor(Color.rgb(sb_red.progress, sb_green.progress, sb_blue.progress))

        fun changeColor() {
            view.setBackgroundColor(Color.rgb(sb_red.progress, sb_green.progress, sb_blue.progress))

        }

        sb_red.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) {
                et_red.setText(progress.toString())
                if (seekBar != null) {
                    red = seekBar.progress
                    if (sb_red.progress != 0)
                        sw_red.isChecked = false
                    changeColor()
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        sb_green.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) {
                et_green.setText(progress.toString())
                if (seekBar != null) {
                    green = seekBar.progress
                    if (sb_green.progress != 0)
                        sw_green.isChecked = false
                    changeColor()
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        sb_blue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) {
                et_blue.setText(progress.toString())

                if (seekBar != null) {
                    blue = seekBar.progress
                    if (sb_blue.progress != 0)
                        sw_blue.isChecked = false
                    changeColor()
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        et_red.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                et_red.setOnEditorActionListener {view, actionId, keyEvent ->
                    if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE ||
                        keyEvent == null ||
                        keyEvent.keyCode == KeyEvent.KEYCODE_ENTER) {
                        sb_red.progress = Integer.parseInt(p0.toString())
                        if (sb_red.progress != 0)
                            sw_red.isChecked = false
                    }
                    false
                }
            }
        })
        et_green.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                et_green.setOnEditorActionListener {view, actionId, keyEvent ->
                    if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE ||
                        keyEvent == null ||
                        keyEvent.keyCode == KeyEvent.KEYCODE_ENTER) {
                        sb_green.progress = Integer.parseInt(p0.toString())
                        if (sb_green.progress != 0)
                            sw_green.isChecked = false
                    }
                    false
                }
            }
        })
        et_blue.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                et_blue.setOnEditorActionListener {view, actionId, keyEvent ->
                    if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE ||
                        keyEvent == null ||
                        keyEvent.keyCode == KeyEvent.KEYCODE_ENTER) {
                        sb_blue.progress = Integer.parseInt(p0.toString())
                        if (sb_blue.progress != 0)
                            sw_blue.isChecked = false
                    }
                    false
                }
            }
        })

        sw_red.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                sb_red.progress = 0
        }
        sw_green.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                sb_green.progress = 0
        }
        sw_blue.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                sb_blue.progress = 0
        }

        reset.setOnClickListener{
            sb_red.progress = 0
            sb_green.progress = 0
            sb_blue.progress = 0
            sw_red.isChecked = false
            sw_green.isChecked = false
            sw_blue.isChecked = false
            et_red.setText("0")
            et_green.setText("0")
            et_blue.setText("0")
        }
    }
}