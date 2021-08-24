package com.example.roomdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.example.roomdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)

        var db=EmployeeDatabase.getInstance(this)

        viewBinding.btnSave.setOnClickListener {
            var ename=viewBinding.edtName.text.toString()
            var edep=viewBinding.edtDepartment.text.toString()
            var esal=viewBinding.edtSalary.text.toString()
            db.EmployeeDao().insert(EmployeeEntity(0,ename,edep,esal))
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
        }
        viewBinding.btnData.setOnClickListener {
            startActivity(Intent(this,RecyclerviewList::class.java))
        }
    }
}