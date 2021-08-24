package com.example.runtimedemo

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Camera
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.*
import com.example.roomdb.R
import com.example.roomdb.databinding.ActivityRuntimeDemoBinding
import java.security.Permission

class RuntimeDemo : AppCompatActivity() {
    lateinit var viewBinding: ActivityRuntimeDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityRuntimeDemoBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)
        var array= arrayOf("java","kotlin","json","xml","andorid","kml","anaconda","python")
        var adapter=ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,array)
        viewBinding.actv.setAdapter(adapter)

        viewBinding.btnCamera.setOnClickListener {
            if (checkSelfPermission(
                    this,
                    Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
            } else requestPermission()
        }
    }

    private fun requestPermission() {
        if (shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
                } else {
                    AlertDialog.Builder(this).setTitle("Alert").setMessage("Permission required..Please Accept")
                        .setPositiveButton("Yes") { _, _ ->
                            requestPermission()
                        }.setNegativeButton("No") { _, _ ->
                        Toast.makeText(this, "Permssion Denied", Toast.LENGTH_SHORT).show()
                    }.show()
                }
                return
            }
        }
    }
}