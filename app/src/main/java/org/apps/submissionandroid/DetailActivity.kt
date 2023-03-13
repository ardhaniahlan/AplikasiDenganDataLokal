package org.apps.submissionandroid

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class DetailActivity : AppCompatActivity() {

    companion object{
        const val KEY_FOOD = "key_food"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailName: TextView = findViewById(R.id.tv_nama)
        val tvDetailDescription: TextView = findViewById(R.id.tv_desc)
        val ivDetailPhoto: ImageView = findViewById(R.id.img_photo)
        val tvDetailMasak: TextView = findViewById(R.id.tv_cara_masak)

        val dataFood = intent.getParcelableExtra<Food>("key_food")
        if (dataFood != null) {
            tvDetailName.text = dataFood.nama
            tvDetailDescription.text = dataFood.desc
            ivDetailPhoto.setImageResource(dataFood.photo)
            tvDetailMasak.text = dataFood.masak
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnShare: Button = findViewById(R.id.action_share)
        btnShare.setOnClickListener{
            shareContentText()
        }
    }

    private fun shareContentText(){
        val tvDetailName: TextView = findViewById(R.id.tv_nama)
        val tvDetailDescription: TextView = findViewById(R.id.tv_desc)
        val ivDetailPhoto: ImageView = findViewById(R.id.img_photo)
        val tvDetailMasak: TextView = findViewById(R.id.tv_cara_masak)

        val dataFood = intent.getParcelableExtra<Food>("key_food")
        if (dataFood != null) {
            tvDetailName.text = dataFood.nama
            tvDetailDescription.text = dataFood.desc
            ivDetailPhoto.setImageResource(dataFood.photo)
            tvDetailMasak.text = dataFood.masak
        }

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        val shareBody = "Nama: ${tvDetailName.text} \nDeskripsi: ${tvDetailDescription.text} \nCara Masak: ${tvDetailMasak.text}"
        val shareSubject = "Makanan"
        intent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
        intent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(intent, "Bagikan dengan"))
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}