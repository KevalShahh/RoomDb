package com.example.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
class EmployeeEntity(

    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "dep")
    var dep: String,
    @ColumnInfo(name = "salary")
    var salary: String,
    )