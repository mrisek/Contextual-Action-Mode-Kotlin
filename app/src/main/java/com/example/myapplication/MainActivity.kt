package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var mActionMode: ActionMode? = null

    private val mActionModeCallback = object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            mode.menuInflater.inflate(R.menu.example_menu, menu)
            mode.title = "Choose your option"
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.option_1 -> {
                    Toast.makeText(this@MainActivity, "Option 1 selected", Toast.LENGTH_SHORT).show()
                    mode.finish()
                    return true
                }
                R.id.option_2 -> {
                    Toast.makeText(this@MainActivity, "Option 2 selected", Toast.LENGTH_SHORT).show()
                    mode.finish()
                    return true
                }
                else -> return false
            }
        }

        override fun onDestroyActionMode(mode: ActionMode) {
            mActionMode = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_view)
        textView.setOnLongClickListener(View.OnLongClickListener {
            if (mActionMode != null) {
                return@OnLongClickListener false
            }

            mActionMode = startSupportActionMode(mActionModeCallback)
            true
        })
    }
}
