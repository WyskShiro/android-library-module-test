package com.jera.apptemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import will.shiro.validatetor.presentation.view.Retriever

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val testButton = findViewById<Button>(R.id.test_button)
        testButton.setOnClickListener {
            startActivity(Retriever.getDashboardActivity(this, ""))
        }
    }
}
