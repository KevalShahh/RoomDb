package com.example.menudemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.example.roomdb.R

class MenuDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_demo)
       main(10)
    }
    fun main(n:Int) {
        var t1 = 0
        var t2 = 1
        for (i in 1..n) {
            var sum = t1 + t2
            t1 = t2
            t2 = sum
            Log.d("TAG", "main: Fibonaci series : $t1")
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_design,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1->{
                Toast.makeText(this, "Option selected", Toast.LENGTH_SHORT).show()
            }
            R.id.item2->{
                Toast.makeText(this, "Context selected", Toast.LENGTH_SHORT).show()
            }
            R.id.item3->{
                Toast.makeText(this, "popUp selected", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
