package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdb.databinding.ActivityRecyclerviewListBinding

class RecyclerviewList : AppCompatActivity() {
    lateinit var viewBinding: ActivityRecyclerviewListBinding
     lateinit var name: Array<String>
    lateinit var salary: kotlin.Array<String>
    lateinit var dep: kotlin.Array<String>
    lateinit var id: kotlin.Array<Int>

    /* var name: ArrayList<String> = ArrayList()
     var salary: ArrayList<String> = ArrayList()
     var dep: ArrayList<String> = ArrayList()
    var id:ArrayList<Int> = ArrayList()*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityRecyclerviewListBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)
        name= arrayOf("","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","")
        salary= arrayOf("","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","")
        dep= arrayOf("","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","")
        id= arrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
        var db = EmployeeDatabase.getInstance(this)
        var getData: List<EmployeeEntity> = db.EmployeeDao().getAll()
        for (i in 0..(getData.size - 1)) {
            name.set(i,getData[i].name)
            dep.set(i,getData[i].dep)
            salary.set(i,getData[i].salary)
            id.set(i,getData[i].id)
          /*
            dep= arrayOf(getData[i].dep)
            salary= arrayOf(getData[i].salary)
            id= arrayOf(getData[i].id)*/

            /* name.add(getData[i].name)
             salary.add(getData[i].salary)
             dep.add(getData[i].dep)
             id.add(getData[i].id)*/
        }
        var adapter = EmployeeAdapter(this, name, salary, dep, id)
        viewBinding.rvRoom.adapter = adapter
        viewBinding.rvRoom.layoutManager = LinearLayoutManager(this)
        Log.d("TAG", "onCreate: ")
    }
}