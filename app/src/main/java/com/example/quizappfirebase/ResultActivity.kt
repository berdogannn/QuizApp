package com.example.quizappfirebase

import Enums.CountryEnum
import Managers.QuestionManager
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    lateinit var mAdView : AdView
    private var mInterstitialAd: InterstitialAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        MobileAds.initialize(this) {}
        val adView = AdView(this)
        adView.setAdSize(AdSize.BANNER)
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val correctAnswer = intent.getIntExtra(QuestionManager.CORRECT_ANSWERS, 0)
        val totalQuestions = intent.getIntExtra(QuestionManager.TOTAL_QUESTION, 0)
        tv_score.text = "Your Score is ${correctAnswer} out of ${totalQuestions}"


        btn_main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finishAfterTransition()
        }

        btn_playAgain.setOnClickListener {
            val type = intent.getSerializableExtra(QuestionManager.country) as CountryEnum
            val intent = Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra(QuestionManager.country, type)
            startActivity(intent)
        }

    }
}