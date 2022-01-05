package com.example.pickimagefromgallery

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.pickimagefromgallery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bin: ActivityMainBinding
    private val REQUEST_CODE = 100
    private var imageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bin.root)

        initView()

    }

    private fun initView() {
        supportActionBar?.title = "Pick Image"
        bin.btnPick.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            imageUri = data?.data
            bin.imageView.setImageURI(imageUri)
        }
    }
}