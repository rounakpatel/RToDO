package com.example.myapplicationtodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var listItems: ArrayList<String>
    private lateinit var listAdapter: ArrayAdapter<String>
    private lateinit var addButton: Button
    private lateinit var newItemEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list_view)
        addButton = findViewById(R.id.add_button)
        newItemEditText = findViewById(R.id.new_item_edit_text)

        listItems = ArrayList()
        listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, listItems)
        listView.adapter = listAdapter

        addButton.setOnClickListener {
            listItems.add(newItemEditText.text.toString())
            newItemEditText.setText("")
            listAdapter.notifyDataSetChanged()
        }

        listView.setOnItemClickListener { _, view, _, _ ->
            val checkedTextView = view as CheckedTextView
            checkedTextView.isChecked = !checkedTextView.isChecked
        }
    }
}
