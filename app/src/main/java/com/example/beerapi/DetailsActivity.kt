package com.example.beerapi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.beerapi.databinding.ActivityDetailsBinding
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        val name = bundle!!.getString("name")
        val desp = bundle!!.getString("description")
        val tagline = bundle!!.getString("tagLine")

        val img_url = bundle.getString("img_url")

        binding.tvName.text = name
        binding.tvDescription.text = desp


        Picasso.get().load(img_url).into(binding.ivImage)

    }
}