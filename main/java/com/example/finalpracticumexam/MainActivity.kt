package com.example.finalpracticumexam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    companion object {
        val itemArray = ArrayList<String>()
        val categoryArray = ArrayList<String>()
        val quantityArray = ArrayList<Int>()
        val commentsArray = ArrayList<String>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val edtItem = findViewById<EditText>(R.id.edtItem)
        val edtCategory = findViewById<EditText>(R.id.edtcategory)
        val edtQuantity = findViewById<EditText>(R.id.edtquantity)
        val edtComments = findViewById<EditText>(R.id.edtcomment)
        val txtItems= findViewById<TextView>(R.id.txtItems)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnView=findViewById<Button>(R.id.btnView)
        var totalItems=0
        //To calculate the total Items
         for (qty in quantityArray){
             totalItems += qty
         }
        "Total Items Packed: $totalItems".also { txtItems.text = it }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main))
        { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Code for the add button
        btnAdd.setOnClickListener {
            val item = edtItem.text.toString()
            val category = edtCategory.text.toString()
            val quantityText = edtQuantity.text.toString()
            val comments = edtComments.text.toString()

            // Error Handling
            if (item.isEmpty() || category.isEmpty() ||
                quantityText.isEmpty() || comments.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please fill in all fields",
                    Toast.LENGTH_SHORT
                ).show()

                Log.e("INPUT_ERROR", "Empty fields detected")

            } else {

                try {
                    val quantity = quantityText.toInt()

                    itemArray.add(item)
                    categoryArray.add(category)
                    quantityArray.add(quantity)
                    commentsArray.add(comments)

                    Toast.makeText(
                        this,
                        "Item Added Successfully",
                        Toast.LENGTH_SHORT
                    ).show()

                    Log.d("PACKING_APP", "Item Added: $item")

                    // Clear inputs
                    edtItem.text.clear()
                    edtCategory.text.clear()
                    edtQuantity.text.clear()
                    edtComments.text.clear()

                } catch (e: NumberFormatException) {

                    Toast.makeText(
                        this,
                        "Quantity must be a number",
                        Toast.LENGTH_SHORT
                    ).show()

                    Log.e("INPUT_ERROR", "Invalid quantity")
                }
            }
        }
        //code for the view button
      btnView.setOnClickListener {
          startActivity(Intent(this, DetailedViewScreen::class.java))
      }

    }
}


