


class Therapist {
    var currentClient = Client()
    fun setClientName() {
        System.out.println(QuestionsBase.NAME.s)
        var name= readLine()
        var re = Regex("[0-9]+")
        while (name?.matches(re) == true) {
            println("Буквами:")
            name = readLine()
        }
        currentClient.name = name
    }

    fun setClientSex() {
        println(QuestionsBase.SEX.s)
        var sex: String? = readLine()
        while (sex != "М" && sex != "Ж") {
            println("М или Ж:")
            sex = readLine()
        }
        currentClient.sex = sex
    }

    fun setClientAge() {
        System.out.println(QuestionsBase.AGE.s)
        var age = readLine()
        var re = Regex("\\d+")
        while (!age?.matches(re)!!) {
            println("Число целое:")
            age = readLine()
        }
        currentClient.age = age.toInt()
    }

    fun setClientPainType() {
        println(QuestionsBase.HEAD_ACHE.s)
        println(QuestionsBase.BELLY_ACHE.s)
        println(QuestionsBase.BLACK_EYE_ACHE.s)
        println(QuestionsBase.TEMPERATURE_ACHE.s)
        println(QuestionsBase.COLD.s)
        var painType = readLine()
        var re = Regex("[1-5]")
        while (!painType?.matches(re)!!) {
            println("Введите цифру от 1 до 5")
            painType = readLine()
        }
        currentClient.painType = painType.toInt()
    }

    fun healing() {
        when (currentClient.painType) {
            1 -> headHealing()
            2 -> bellyHealing()
            3 -> blackEyeHealing()
            4 -> temperatureHealing()
            5 -> coldHealing()
        }
    }

    private fun coldHealing() {
        println("Ответ 'Да' или 'Нет'")
        println(QuestionsBase.COLD_ALLERGY.s)
        val coldAllergy = clientHealingAnswer
        println(QuestionsBase.DRY_COUGH.s)
        val dryCough = clientHealingAnswer
        if (coldAllergy) {
            println("Ваш диагноз: у вас аллергия на Холод")
        } else if (dryCough) {
            println("Ваш диагноз: у вас ОРВИ")
        } else {
            println("Ваш диагноз: у вас гайморит")
        }
    }

    private fun temperatureHealing() {
        println("Ответ 'Да' или 'Нет'")
        println(QuestionsBase.TEMPERATURE_COVID.s)
        val temperatureCovid = clientHealingAnswer
        if (!temperatureCovid) {
            println(QuestionsBase.SMELLS.s)
            val covidSmells = clientHealingAnswer
            println(QuestionsBase.COUGH.s)
            val covidCough = clientHealingAnswer
            if (covidCough && !covidSmells) {
                println("Ваш диагноз: У вас Ковид.")
            }
        } else {
            println("Ваш диагноз: простуда")
        }
    }

    private fun blackEyeHealing() {
        println("Ответ 'Да' или 'Нет'")
        println(QuestionsBase.EYE_FAINTING.s)
        val eyeFainting = clientHealingAnswer
        println(QuestionsBase.EYE_PRESSURE_DROPS.s)
        val eyePressureDrops = clientHealingAnswer
        println(QuestionsBase.EYE_BANGING.s)
        val eyeBanging = clientHealingAnswer
        if (eyeFainting) {
            println("Ваш диагноз: Переутомление")
        } else if (eyePressureDrops) {
            println("Ваш диагноз: «Пятна могут появляться из-за частого перепад давления. Выдано направление к кардиологу.»")
        } else if (eyeBanging) {
            println("Ваш диагноз: возможно черепно-мозговая травма. Выдано направление на МРТ. После результатов обследования ждём вас снова")
        } else {
            println("Ваш диагноз: у вас нарушение кровообращения")
        }
    }

    private fun bellyHealing() {
        println("Ответ 'Да' или 'Нет'")
        println(QuestionsBase.BELLY_DIARRHEA.s)
        val bellyDiarrhea = clientHealingAnswer
        println(QuestionsBase.BELLY_NAGGING_PAIN.s)
        clientHealingAnswer
        println(QuestionsBase.BELLY_URINA_BLOOD.s)
        val bellyUrinaBlood = clientHealingAnswer
        System.out.println(QuestionsBase.BELLY_ALCOHOL.s)
        val bellyAlcohol = clientHealingAnswer
        if (bellyDiarrhea) {
            println("Ваш диагноз: отравление")
        } else if (bellyUrinaBlood) {
            println("Ваш диагноз: камни в почках.")
        } else if (bellyAlcohol) {
            println("Ваш диагноз: язва ")
        } else {
            println("Ваш диагноз: гастрит")
        }
    }

    private fun headHealing() {
        println("Ответ 'Да' или 'Нет'")
        System.out.println(QuestionsBase.HEAD_TWO_DAYS.s)
        val headTwoDays = clientHealingAnswer
        System.out.println(QuestionsBase.HEAD_THROBBING_PAIN.s)
        val headThrobbingPain = clientHealingAnswer
        if (headThrobbingPain) {
            System.out.println(QuestionsBase.HIGH_PRESSURE.s)
            val highPressure = clientHealingAnswer
            if (!highPressure) {
                System.out.println(QuestionsBase.LOW_PRESSURE.s)
                val lowPressure = clientHealingAnswer
                if (lowPressure) {
                    println("Ваш диагноз: гипотония")
                }
            } else {
                println("Ваш диагноз: гипертония")
            }
        }
        System.out.println(QuestionsBase.HEAD_NERVOUS.s)
        val headNervous = clientHealingAnswer
        if (!headTwoDays) {
            println("Примите анальгин")
        } else if (headNervous) {
            println("Ваш диагноз: переутомление")
        } else {
            println("Ваш диагноз: мигрень.")
        }
    }

    private val clientHealingAnswer: Boolean
         get() {
            var answer = readLine()
            while (answer != "Да" && answer != "Нет" &&
                answer != "да" && answer != "нет"
            ) {
                println("Введите только \"Да\" или \"Нет\"")
                answer = readLine()
            }
            return answer == "Да" || answer == "да"
        }
}