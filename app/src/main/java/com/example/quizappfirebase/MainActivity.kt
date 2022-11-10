package com.example.quizappfirebase

import Enums.CountryEnum
import Managers.QuestionManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var type: CountryEnum? = null
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}
        val adView = AdView(this)
        adView.setAdSize(AdSize.BANNER)
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btn_asia.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            type = CountryEnum.Asia
            intent.putExtra(QuestionManager.country, type)
            startActivity(intent)
        }
        btn_europe.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            type = CountryEnum.Europe
            intent.putExtra(QuestionManager.country, type)
            startActivity(intent)
        }
        btn_north_america.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            type = CountryEnum.NorthAmerica
            intent.putExtra(QuestionManager.country, type)
            startActivity(intent)
        }
        btn_south_america.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            type = CountryEnum.SouthAmerica
            intent.putExtra(QuestionManager.country, type)
            startActivity(intent)
        }
        btn_australia.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            type = CountryEnum.Australia
            intent.putExtra(QuestionManager.country, type)
            startActivity(intent)
        }
        btn_africa.setOnClickListener {
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            type = CountryEnum.Africa
            intent.putExtra(QuestionManager.country, type)
            startActivity(intent)
        }

    }
}




