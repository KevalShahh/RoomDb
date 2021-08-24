package com.example.roomdb

import androidx.room.*

@Dao
interface EmployeeDao {
    @Query("SELECT * from employee ORDER BY salary DESC")
    fun getAll(): List<EmployeeEntity>

    @Insert
    fun insert(employeeEntity: EmployeeEntity)

    @Query("UPDATE employee SET name=:Name , dep=:Dep , salary=:Salary WHERE id=:Id")
    fun update(Name:String,Dep:String,Salary:String,Id:Int)

    @Query("DELETE from employee WHERE id=:Id")
    fun delete(Id: Int)
}