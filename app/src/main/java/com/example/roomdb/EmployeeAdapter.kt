package com.example.roomdb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(
    var context: Context,
    var name: Array<String>,
    var salary: Array<String>,
    var dep: Array<String>,
    var id: Array<Int>
) : RecyclerView.Adapter<EmployeeAdapter.EmployeeeViewHolder>() {
    class EmployeeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Ename: TextView = itemView.findViewById(R.id.idTVEmpName)
        val Esalary: TextView = itemView.findViewById(R.id.idTVEmpSalary)
        val Edep: TextView = itemView.findViewById(R.id.idTVEmpDep)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeeViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_recycler_item, parent, false)
        return EmployeeeViewHolder(view)

    }

    override fun onBindViewHolder(holder: EmployeeeViewHolder, position: Int) {
        holder.Ename.text = name[position]
        holder.Esalary.text = salary[position]
        holder.Edep.text = dep[position]
        holder.itemView.setOnClickListener {
            var dialogView: View =
                LayoutInflater.from(context).inflate(R.layout.activity_employee_update, null, false)
            var dialog =
                androidx.appcompat.app.AlertDialog.Builder(context).setView(dialogView).create()
            dialog.show()
            var Name = dialogView.findViewById<EditText>(R.id.edt_name_update)
            var Salary = dialogView.findViewById<EditText>(R.id.edt_salary_update)
            var Dep = dialogView.findViewById<EditText>(R.id.edt_department_update)
            var db = EmployeeDatabase.getInstance(context)
            Name.setText(holder.Ename.text)
            Salary.setText(holder.Esalary.text)
            Dep.setText(holder.Edep.text)
            dialogView.findViewById<Button>(R.id.btn_update).setOnClickListener {
                var ename = Name.text.toString()
                var esalary = Salary.text.toString()
                var edep = Dep.text.toString()
                var Eid = id[position]
                db.EmployeeDao().update(ename, edep, esalary, Eid)
                /* holder.Ename.text = ename
                 holder.Edep.text = edep
                 holder.Esalary.text = esalary*/
                Toast.makeText(context, "Data Updated", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            dialogView.findViewById<Button>(R.id.btn_delete).setOnClickListener {
                androidx.appcompat.app.AlertDialog.Builder(context)
                    .setMessage("Are you sure you want to delete this data ?")
                    .setPositiveButton("Yes") { _, _ ->
                        var Eid = id[position]
                        db.EmployeeDao().delete(Eid)
                        Toast.makeText(context, "Data Deleted", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }.setNegativeButton("Cancel", null).show()
            }
        }
    }
    override fun getItemCount(): Int {
        return name.size
    }
}
