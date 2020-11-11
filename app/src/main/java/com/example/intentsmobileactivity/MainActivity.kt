package com.example.intentsmobileactivity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.MapBtn).setOnClickListener { viewMap() }
        findViewById<Button>(R.id.CamBtn).setOnClickListener { takePic() }
        findViewById<Button>(R.id.CalcBtn).setOnClickListener { openCalc() }

        findViewById<Button>(R.id.ToDoBtn).setOnClickListener { ToDoo() }
        findViewById<Button>(R.id.GamesBtn).setOnClickListener {  Games() }
    }

    //OPENS SELECTED BROWSER AND ENTERS GOOGLE
    private fun viewMap (){
        val gmIntentUri = Uri.parse("geo: 16.408516, 120.598008")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        mapIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        if (mapIntent.resolveActivity(packageManager) != null){
            startActivity(mapIntent)
        }else{
            Toast.makeText(this,"No History", Toast.LENGTH_SHORT).show()
        }
    }
    val REQUEST_IMAGE_CAPTURE = 2
    private fun takePic() {
        val takePicIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePicIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
        }
    }
    //OPEN THE PHONE'S DEFAULT MUSIC PLAYER APP
    private fun openCalc() {
        val calcIntent = Intent(Intent.ACTION_MAIN)
        calcIntent.addCategory(Intent.CATEGORY_APP_CALCULATOR)
        calcIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        if (calcIntent.resolveActivity(packageManager) != null) {
            startActivity(calcIntent)
        } else {
            Toast.makeText(this, "Math is Life", Toast.LENGTH_SHORT).show()
        }
    }
    fun ToDoo() {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }else{
            val text = "ERROR!: Too many task"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }
    }

    fun Games() {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }else{
            val text = "ERROR!: EXAM WEEK! No time for gaming"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }
    }
}