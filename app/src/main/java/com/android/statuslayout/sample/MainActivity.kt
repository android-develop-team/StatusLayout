package com.android.statuslayout.sample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.status.layout.*

class MainActivity : AppCompatActivity() {

    private lateinit var statusLayout: StatusLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        statusLayout = findViewById(R.id.status_root_view)
//        statusLayout.addSuccessView(StatusLayout(this))
//        statusLayout.status = StatusLayout.LOADING
        statusLayout.onStatusEmptyClick = {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
        }

        statusLayout.onStatusErrorClick = { }
        statusLayout.onStatusLoadingClick = { }
        statusLayout.onStatusNormalClick = { }
        statusLayout.onStatusSuccessClick = { }

        statusLayout.apply {
            onStatusEmptyClick = {}
            onStatusErrorClick = {}
            onStatusLoadingClick = {}
            onStatusNormalClick = {}
            onStatusSuccessClick = {}
        }

        statusLayout
            .EmptyClick { Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show() }
            .ErrorClick { Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show() }
            .LoadingClick { Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show() }
            .NormalClick { Toast.makeText(this, "Normal", Toast.LENGTH_SHORT).show() }
            .SuccessClick { Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.status_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        statusLayout.status = item.title.toString()
        statusLayout.status(item.title.toString())
        return true
    }

}
