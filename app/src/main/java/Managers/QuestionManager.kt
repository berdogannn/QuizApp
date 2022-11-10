package Managers

import Enums.CountryEnum
import Models.Country
import Models.Question
import com.example.quizappfirebase.R

object QuestionManager {

    const val TOTAL_QUESTION: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answer"
    const val country: String = "country"

    fun getCountries(type: CountryEnum): ArrayList<Country> {
        val countryList = ArrayList<Country>()
        val turkey = Country(1, R.drawable.turkey, "Türkiye", CountryEnum.Europe)
        val usa = Country(2, R.drawable.usa, "Amerika", CountryEnum.SouthAmerica)
        val china = Country(3, R.drawable.china, "Çin", CountryEnum.Asia)
        val france = Country(4, R.drawable.france, "Fransa", CountryEnum.Europe)
        val italy = Country(5, R.drawable.italy, "İtalya", CountryEnum.Europe)
        val spain = Country(6, R.drawable.spain, "İspanya", CountryEnum.Europe)
        val ahmet = Country(7, R.drawable.china, "Ahmet", CountryEnum.Europe)
        val mehmet = Country(8, R.drawable.china, "Mehmet", CountryEnum.Europe)
        val berkay = Country(9, R.drawable.china, "Berkay", CountryEnum.Europe)
        val burak = Country(10, R.drawable.china, "Burak", CountryEnum.Europe)
        val burak1 = Country(11, R.drawable.china, "Burak", CountryEnum.Asia)
        val burak2 = Country(12, R.drawable.china, "Burak", CountryEnum.Asia)
        val burak3 = Country(13, R.drawable.china, "Burak", CountryEnum.Asia)
        val burak4 = Country(14, R.drawable.china, "Burak", CountryEnum.Asia)
        val burak5 = Country(15, R.drawable.china, "Burak", CountryEnum.Africa)
        val burak6 = Country(16, R.drawable.china, "Burak", CountryEnum.Africa)
        val burak7 = Country(17, R.drawable.china, "Burak", CountryEnum.Africa)
        val burak8 = Country(18, R.drawable.china, "Burak", CountryEnum.Africa)
        val burak9 = Country(19, R.drawable.china, "Burak", CountryEnum.NorthAmerica)
        val burak10 = Country(20, R.drawable.china, "Burak", CountryEnum.NorthAmerica)
        val burak11 = Country(21, R.drawable.china, "Burak", CountryEnum.NorthAmerica)
        val burak17 = Country(22, R.drawable.china, "Burak", CountryEnum.NorthAmerica)
        val burak18 = Country(23, R.drawable.china, "Burak", CountryEnum.NorthAmerica)
        val burak12 = Country(24, R.drawable.china, "Burak", CountryEnum.SouthAmerica)
        val burak13 = Country(25, R.drawable.china, "Burak", CountryEnum.SouthAmerica)
        val burak14 = Country(26, R.drawable.china, "Burak", CountryEnum.SouthAmerica)
        val burak15 = Country(27, R.drawable.china, "Burak", CountryEnum.SouthAmerica)
        val burak16 = Country(28, R.drawable.china, "Burak", CountryEnum.SouthAmerica)

        countryList.add(turkey)
        countryList.add(usa)
        countryList.add(italy)
        countryList.add(france)
        countryList.add(spain)
        countryList.add(china)
        countryList.add(ahmet)
        countryList.add(mehmet)
        countryList.add(berkay)
        countryList.add(burak)
        countryList.add(burak1)
        countryList.add(burak2)
        countryList.add(burak3)
        countryList.add(burak4)
        countryList.add(burak5)
        countryList.add(burak6)
        countryList.add(burak7)
        countryList.add(burak8)
        countryList.add(burak9)
        countryList.add(burak10)
        countryList.add(burak11)
        countryList.add(burak12)
        countryList.add(burak13)
        countryList.add(burak14)
        countryList.add(burak15)
        countryList.add(burak16)
        countryList.add(burak17)
        countryList.add(burak18)

        return countryList.filter { it.continent == type } as ArrayList
    }

    fun getQuestion(type: CountryEnum): ArrayList<Question> {
        val question: String = "What country does this flag belong to?"
        val questionList = ArrayList<Question>()
        val shownList = ArrayList<Country>()
        val optionsList = ArrayList<Country>()
        val pList = ArrayList<Country>()
        var cAnswer: Int = 1
        var show: Int = 1
        val allCountries: ArrayList<Country> = getCountries(type)

        for (i in 1..allCountries.count()) {
            val pull = (allCountries - shownList).random()
            shownList.add(pull)
            optionsList.add(pull)

            val p2 = (allCountries - optionsList).random()
            optionsList.add(p2)

            val p3 = (allCountries - optionsList).random()
            optionsList.add(p3)

            val p4 = (allCountries - optionsList).random()
            optionsList.add(p4)

            val o1 = (optionsList - pList).random()
            pList.add(o1)
            val o2 = (optionsList - pList).random()
            pList.add(o2)
            val o3 = (optionsList - pList).random()
            pList.add(o3)
            val o4 = (optionsList - pList).random()
            pList.add(o4)

            if (pull.name == o1.name) {
                cAnswer = 1
            } else if (pull.name == o2.name) {
                cAnswer = 2
            } else if (pull.name == o3.name) {
                cAnswer = 3
            } else if (pull.name == o4.name) {
                cAnswer = 4
            }
            val que =
                Question(show, question, pull.image, o1.name, o2.name, o3.name, o4.name, cAnswer)
            questionList.add(que)
            show += show
            optionsList.clear()
            pList.clear()

        }
        return questionList
    }

    fun getAsiaQueList(): ArrayList<Question> {
        val question: String = "What country does this flag belong to?"
        val questionList = ArrayList<Question>()
        val shownList = ArrayList<Country>()
        val optionsList = ArrayList<Country>()
        val pList = ArrayList<Country>()
        var cAnswer: Int = 1
        var show: Int = 1
        val allCountries: ArrayList<Country> = getCountries(CountryEnum.Asia)


        for (i in 1..allCountries.count()) {
            val pull = (allCountries - shownList).random()
            shownList.add(pull)
            optionsList.add(pull)

            val p2 = (allCountries - optionsList).random()
            optionsList.add(p2)

            val p3 = (allCountries - optionsList).random()
            optionsList.add(p3)

            val p4 = (allCountries - optionsList).random()
            optionsList.add(p4)

            val o1 = (optionsList - pList).random()
            pList.add(o1)
            val o2 = (optionsList - pList).random()
            pList.add(o2)
            val o3 = (optionsList - pList).random()
            pList.add(o3)
            val o4 = (optionsList - pList).random()
            pList.add(o4)

            if (pull.name == o1.name) {
                cAnswer = 1
            } else if (pull.name == o2.name) {
                cAnswer = 2
            } else if (pull.name == o3.name) {
                cAnswer = 3
            } else if (pull.name == o4.name) {
                cAnswer = 4
            }
            val que =
                Question(show, question, pull.image, o1.name, o2.name, o3.name, o4.name, cAnswer)
            questionList.add(que)
            show += show
            optionsList.clear()
            pList.clear()

        }
        return questionList
    }

    fun getEuropeQueList(): ArrayList<Question> {
        val question: String = "What country does this flag belong to?"
        val questionList = ArrayList<Question>()
        val shownList = ArrayList<Country>()
        val optionsList = ArrayList<Country>()
        val pList = ArrayList<Country>()
        var cAnswer: Int = 1
        var show: Int = 1
        val allCountries: ArrayList<Country> = getCountries(CountryEnum.Europe)
        allCountries.size

        for (i in 1..allCountries.count()) {
            val pull = (allCountries - shownList).random()
            shownList.add(pull)
            optionsList.add(pull)

            val p2 = (allCountries - optionsList).random()
            optionsList.add(p2)

            val p3 = (allCountries - optionsList).random()
            optionsList.add(p3)

            val p4 = (allCountries - optionsList).random()
            optionsList.add(p4)

            val o1 = (optionsList - pList).random()
            pList.add(o1)
            val o2 = (optionsList - pList).random()
            pList.add(o2)
            val o3 = (optionsList - pList).random()
            pList.add(o3)
            val o4 = (optionsList - pList).random()
            pList.add(o4)

            if (pull.name == o1.name) {
                cAnswer = 1
            } else if (pull.name == o2.name) {
                cAnswer = 2
            } else if (pull.name == o3.name) {
                cAnswer = 3
            } else if (pull.name == o4.name) {
                cAnswer = 4
            }
            val que =
                Question(show, question, pull.image, o1.name, o2.name, o3.name, o4.name, cAnswer)
            questionList.add(que)
            show += show
            optionsList.clear()
            pList.clear()

        }
        return questionList
    }

    fun getNorthAmericaQueList(): ArrayList<Question> {
        val question: String = "What country does this flag belong to?"
        val questionList = ArrayList<Question>()
        val shownList = ArrayList<Country>()
        val optionsList = ArrayList<Country>()
        val pList = ArrayList<Country>()
        var cAnswer: Int = 1
        var show: Int = 1
        val allCountries: ArrayList<Country> = QuestionManager.getCountries(CountryEnum.NorthAmerica)
        allCountries.size

        for (i in 1..allCountries.count()) {
            val pull = (allCountries - shownList).random()
            shownList.add(pull)
            optionsList.add(pull)

            val p2 = (allCountries - optionsList).random()
            optionsList.add(p2)

            val p3 = (allCountries - optionsList).random()
            optionsList.add(p3)

            val p4 = (allCountries - optionsList).random()
            optionsList.add(p4)

            val o1 = (optionsList - pList).random()
            pList.add(o1)
            val o2 = (optionsList - pList).random()
            pList.add(o2)
            val o3 = (optionsList - pList).random()
            pList.add(o3)
            val o4 = (optionsList - pList).random()
            pList.add(o4)

            if (pull.name == o1.name) {
                cAnswer = 1
            } else if (pull.name == o2.name) {
                cAnswer = 2
            } else if (pull.name == o3.name) {
                cAnswer = 3
            } else if (pull.name == o4.name) {
                cAnswer = 4
            }
            val que =
                Question(show, question, pull.image, o1.name, o2.name, o3.name, o4.name, cAnswer)
            questionList.add(que)
            show += show
            optionsList.clear()
            pList.clear()

        }
        return questionList
    }

    fun getSouthAmericaQueList(): ArrayList<Question> {
        val question: String = "What country does this flag belong to?"
        val questionList = ArrayList<Question>()
        val shownList = ArrayList<Country>()
        val optionsList = ArrayList<Country>()
        val pList = ArrayList<Country>()
        var cAnswer: Int = 1
        var show: Int = 1
        val allCountries: ArrayList<Country> =
            QuestionManager.getCountries(CountryEnum.SouthAmerica)
        allCountries.size

        for (i in 1..allCountries.count()) {
            val pull = (allCountries - shownList).random()
            shownList.add(pull)
            optionsList.add(pull)

            val p2 = (allCountries - optionsList).random()
            optionsList.add(p2)

            val p3 = (allCountries - optionsList).random()
            optionsList.add(p3)

            val p4 = (allCountries - optionsList).random()
            optionsList.add(p4)

            val o1 = (optionsList - pList).random()
            pList.add(o1)
            val o2 = (optionsList - pList).random()
            pList.add(o2)
            val o3 = (optionsList - pList).random()
            pList.add(o3)
            val o4 = (optionsList - pList).random()
            pList.add(o4)

            if (pull.name == o1.name) {
                cAnswer = 1
            } else if (pull.name == o2.name) {
                cAnswer = 2
            } else if (pull.name == o3.name) {
                cAnswer = 3
            } else if (pull.name == o4.name) {
                cAnswer = 4
            }
            val que =
                Question(show, question, pull.image, o1.name, o2.name, o3.name, o4.name, cAnswer)
            questionList.add(que)
            show += show
            optionsList.clear()
            pList.clear()

        }
        return questionList
    }

    fun getAustraliaQueList(): ArrayList<Question> {
        val question: String = "What country does this flag belong to?"
        val questionList = ArrayList<Question>()
        val shownList = ArrayList<Country>()
        val optionsList = ArrayList<Country>()
        val pList = ArrayList<Country>()
        var cAnswer: Int = 1
        var show: Int = 1
        val allCountries: ArrayList<Country> =
            QuestionManager.getCountries(CountryEnum.Australia)
        allCountries.size

        for (i in 1..allCountries.count()) {
            val pull = (allCountries - shownList).random()
            shownList.add(pull)
            optionsList.add(pull)

            val p2 = (allCountries - optionsList).random()
            optionsList.add(p2)

            val p3 = (allCountries - optionsList).random()
            optionsList.add(p3)

            val p4 = (allCountries - optionsList).random()
            optionsList.add(p4)

            val o1 = (optionsList - pList).random()
            pList.add(o1)
            val o2 = (optionsList - pList).random()
            pList.add(o2)
            val o3 = (optionsList - pList).random()
            pList.add(o3)
            val o4 = (optionsList - pList).random()
            pList.add(o4)

            if (pull.name == o1.name) {
                cAnswer = 1
            } else if (pull.name == o2.name) {
                cAnswer = 2
            } else if (pull.name == o3.name) {
                cAnswer = 3
            } else if (pull.name == o4.name) {
                cAnswer = 4
            }
            val que =
                Question(show, question, pull.image, o1.name, o2.name, o3.name, o4.name, cAnswer)
            questionList.add(que)
            show += show
            optionsList.clear()
            pList.clear()

        }
        return questionList
    }

    fun getAfricaQueList(): ArrayList<Question> {
        val question: String = "What country does this flag belong to?"
        val questionList = ArrayList<Question>()
        val shownList = ArrayList<Country>()
        val optionsList = ArrayList<Country>()
        val pList = ArrayList<Country>()
        var cAnswer: Int = 1
        var show: Int = 1
        val allCountries: ArrayList<Country> =
            QuestionManager.getCountries(CountryEnum.Africa)
        allCountries.size

        for (i in 1..allCountries.count()) {
            val pull = (allCountries - shownList).random()
            shownList.add(pull)
            optionsList.add(pull)

            val p2 = (allCountries - optionsList).random()
            optionsList.add(p2)

            val p3 = (allCountries - optionsList).random()
            optionsList.add(p3)

            val p4 = (allCountries - optionsList).random()
            optionsList.add(p4)

            val o1 = (optionsList - pList).random()
            pList.add(o1)
            val o2 = (optionsList - pList).random()
            pList.add(o2)
            val o3 = (optionsList - pList).random()
            pList.add(o3)
            val o4 = (optionsList - pList).random()
            pList.add(o4)

            if (pull.name == o1.name) {
                cAnswer = 1
            } else if (pull.name == o2.name) {
                cAnswer = 2
            } else if (pull.name == o3.name) {
                cAnswer = 3
            } else if (pull.name == o4.name) {
                cAnswer = 4
            }
            val que =
                Question(show, question, pull.image, o1.name, o2.name, o3.name, o4.name, cAnswer)
            questionList.add(que)
            show += show
            optionsList.clear()
            pList.clear()

        }
        return questionList
    }

}



