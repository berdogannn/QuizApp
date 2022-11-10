package com.example.quizappfirebase

import Enums.CountryEnum
import Managers.QuestionManager
import Models.Question
import android.app.ActionBar
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_quiz_question.*
import kotlin.collections.ArrayList

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    private var totalQue: Int = 1
    private var exit: Boolean = false
    lateinit var mAdView : AdView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        MobileAds.initialize(this) {}
        val adView = AdView(this)
        adView.setAdSize(AdSize.BANNER)
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val type = intent.getSerializableExtra(QuestionManager.country) as CountryEnum


        when (type) {
            CountryEnum.Asia -> mQuestionsList = QuestionManager.getQuestion(CountryEnum.Asia)
            CountryEnum.Europe -> mQuestionsList = QuestionManager.getQuestion(CountryEnum.Europe)
            CountryEnum.NorthAmerica -> mQuestionsList = QuestionManager.getQuestion(CountryEnum.NorthAmerica)
            CountryEnum.SouthAmerica -> mQuestionsList = QuestionManager.getQuestion(CountryEnum.SouthAmerica)
            CountryEnum.Australia -> mQuestionsList = QuestionManager.getQuestion(CountryEnum.Australia)
            CountryEnum.Africa -> mQuestionsList = QuestionManager.getQuestion(CountryEnum.Africa)
        }

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
        btn_exit.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Exit")
            alertDialog.setMessage("Do you want to Exit?")
            alertDialog.setPositiveButton("Exit") { dialog, which ->
                exit = true
            }
            alertDialog.show()
        }
        //exit = true

    }

    private fun setQuestion() {
        setOptionEnable(true)
        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size) {
            btn_submit.text = "FINISH"
        } else {
            btn_submit.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        progressBar.max = mQuestionsList!!.size
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_question.text = question!!.question
        iv_flag.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }

    }

    fun setOptionEnable(boolean: Boolean) {
        tv_option_one.isEnabled = boolean
        tv_option_two.isEnabled = boolean
        tv_option_three.isEnabled = boolean
        tv_option_four.isEnabled = boolean
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                setOptionEnable(false)
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition += 1
                    Toast.makeText(this, "Please Choose One Of The Options!", Toast.LENGTH_SHORT)
                        .show()

                    when {
                        ((mCurrentPosition <= mQuestionsList!!.size) && !exit) -> {
                            totalQue++
                            setQuestion()
                        }
                        else -> {
                            val type = intent.getSerializableExtra(QuestionManager.country) as CountryEnum
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(QuestionManager.CORRECT_ANSWERS, mCorrectAnswer)
                            intent.putExtra(QuestionManager.TOTAL_QUESTION, totalQue)
                            intent.putExtra(QuestionManager.country, type)
                            startActivity(intent)
                            finishAfterTransition()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    if (question!!.correctAnswer == mSelectedOptionPosition) {
                        mCorrectAnswer += 1
                        answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                    }

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btn_submit.text = "FINISH"
                    } else {
                        btn_submit.text = "NEXT"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(this, drawableView)
            }
        }

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border
        )
    }
}