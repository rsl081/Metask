package com.s2dioapps.metask.ui.component.createtask.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.s2dioapps.metask.R

class CreateTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        findViewById<Button>(R.id.ct_back)?.setOnClickListener {
            onBackPressed()
        }
        findViewById<Button>(R.id.btn_cancel)?.setOnClickListener {
            onBackPressed()
        }
    }
}
