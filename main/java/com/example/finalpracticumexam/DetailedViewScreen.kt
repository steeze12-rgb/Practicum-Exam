package com.example.finalpracticumexam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class DetailedViewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)
        val btnNavigation=findViewById<Button>(R.id.btnNavigation)
        val btnDisplay=findViewById<Button>(R.id.btnDisplay)
        val txtOutput=findViewById<TextView>(R.id.txtOutput)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code of the back to screen button
        btnNavigation.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //Code of the display button
        btnDisplay.setOnClickListener {
            var output = ""

            for (i in MainActivity.itemArray.indices) {

                output += """
                    Item: ${MainActivity.itemArray[i]}
                    Category: ${MainActivity.categoryArray[i]}
                    Quantity: ${MainActivity.quantityArray[i]}
                    Comments: ${MainActivity.commentsArray[i]}

                """.trimIndent()

                output += "\n\n"
            }

            txtOutput.text = output

            Log.d("PACKING_APP", "Displayed full packing list")
        }

    }
    }
