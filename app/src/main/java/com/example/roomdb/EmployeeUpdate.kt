package com.example.roomdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.roomdb.databinding.ActivityEmployeeUpdateBinding

class EmployeeUpdate : AppCompatActivity() {
    lateinit var viewBinding:ActivityEmployeeUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityEmployeeUpdateBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)

       /* viewBinding.edtNameUpdate.setText(intent.getStringExtra("name"))
        viewBinding.edtSalaryUpdate.setText(intent.getStringExtra("salary"))
        viewBinding.edtDepartmentUpdate.setText(intent.getStringExtra("dep"))

        var db = EmployeeDatabase.getInstance(this)

        viewBinding.btnUpdate.setOnClickListener {
            var name= viewBinding.edtNameUpdate.text.toString()
            var dep=viewBinding.edtDepartmentUpdate.text.toString()
            var salary=viewBinding.edtSalaryUpdate.text.toString()
            var id=intent.getIntExtra("id",0)
            db.EmployeeDao().update(name,dep,salary,id)
            Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,RecyclerviewList::class.java))
        }*/
    }
}