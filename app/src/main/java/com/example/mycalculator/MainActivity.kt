package com.example.mycalculator

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    var calcStr : String = ""
    val numberList = ArrayList<Double>()
    val operationList = ArrayList<Char>()

    // 効果音用
    private lateinit var soundPool: SoundPool
    private var soundA = 0
    private var soundB = 0
    private var soundC = 0
    private var soundD = 0
    private var soundE = 0
    private var soundF = 0
    private var soundG = 0
    private var soundH = 0
    private var soundI = 0
    private var soundJ = 0
    private var soundK = 0
    private var soundL = 0
    private var soundM = 0
    private var soundN = 0
    private var soundO = 0
    private var soundP = 0
    private var soundQ = 0
    private var soundR = 0
    private var soundS = 0
    private var soundT = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val audioAttributes = AudioAttributes.Builder()
            // USAGE_MEDIA or USAGE_GAME
            .setUsage(AudioAttributes.USAGE_GAME)
            // CONTENT_TYPE_MUSIC or CONTENT_TYPE_SPEECH, etc.
            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
            .build()

        soundPool = SoundPool.Builder().setAudioAttributes(audioAttributes)
            // ストリーム数に応じて
            .setMaxStreams(20)
            .build()

        // boyoyon1.mp3 をロードしておく
        soundA = soundPool.load(this, R.raw.boyoyon1, 1)

        // woodfish1.mp3 をロードしておく
        soundB = soundPool.load(this, R.raw.woodfish1, 1)

        // broadcastingstart1.mp3 をロードしておく
        soundC = soundPool.load(this, R.raw.broadcastingstart1, 1)

        // peopleperformanceuwaa1.mp3 をロードしておく
        soundD = soundPool.load(this, R.raw.peopleperformanceuwaa1, 1)

        // peoplestudiolaughlarge2.mp3 をロードしておく
        soundE = soundPool.load(this, R.raw.peoplestudiolaughlarge2, 1)

        // machinegun1.mp3 をロードしておく
        soundF = soundPool.load(this, R.raw.machinegun1, 1)

        // conch1.mp3 をロードしておく
        soundG = soundPool.load(this, R.raw.conch1, 1)

        // question1.mp3 をロードしておく
        soundH = soundPool.load(this, R.raw.question1, 1)

        // drumroll1.mp3 をロードしておく
        soundI = soundPool.load(this, R.raw.drumroll1, 1)

        // walkgeta1.mp3 をロードしておく
        soundJ = soundPool.load(this, R.raw.walkgeta1, 1)

        // walktussock1.mp3 をロードしておく
        soundK = soundPool.load(this, R.raw.walktussock1, 1)

        // dooropen1.mp3 をロードしておく
        soundL = soundPool.load(this, R.raw.dooropen1, 1)

        // money1.mp3 をロードしておく
        soundM = soundPool.load(this, R.raw.money1, 1)

        // aburazemicry1.mp3 をロードしておく
        soundN = soundPool.load(this, R.raw.aburazemicry1, 1)

        // thunder1.mp3 をロードしておく
        soundO = soundPool.load(this, R.raw.thunder1, 1)

        // catcry1.mp3 をロードしておく
        soundP = soundPool.load(this, R.raw.catcry1, 1)

        // elephant1.mp3 をロードしておく
        soundQ = soundPool.load(this, R.raw.elephant1, 1)

        // wave2.mp3 をロードしておく
        soundR = soundPool.load(this, R.raw.wave2, 1)

        // gameswordmanstart1.mp3 をロードしておく
        soundS = soundPool.load(this, R.raw.gameswordmanstart1, 1)

        // question2.mp3 をロードしておく
        soundT = soundPool.load(this, R.raw.question2, 1)

        // load が終わったか確認する場合
        soundPool.setOnLoadCompleteListener{ soundPool, sampleId, status ->
            Log.d("debug", "sampleId=$sampleId")
            Log.d("debug", "status=$status")
        }


        /*******
         * 0 ～ 9 ボタンクリック時
         ********/
        buttonOf0.setOnClickListener {
            formula.text = "${formula.text}0"  // 表示値に 0 をAdd
            calcStr += "0"                     // 数字文字列に 0 をAdd

            // soundA(boyoyon1.mp3 ) の再生
            soundPool.play(soundA, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        buttonOf1.setOnClickListener {
            formula.text = "${formula.text}1"  // 表示値に 1 をAdd
            calcStr += "1"                   // 数字文字列に 1 をAdd

            // soundB(woodfish1.mp3) の再生
            soundPool.play(soundB, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        buttonOf2.setOnClickListener {
            formula.text = "${formula.text}2"  // 表示値に 2 をAdd
            calcStr += "2"                   // 数字文字列に 2 をAdd

            // soundC(broadcastingstart1.mp3) の再生
            soundPool.play(soundC, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        buttonOf3.setOnClickListener {
            formula.text = "${formula.text}3"  // 表示値に 3 をAdd
            calcStr += "3"                   // 数字文字列に 3 をAdd

            // soundD(peopleperformanceuwaa1.mp3) の再生
            soundPool.play(soundD, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        buttonOf4.setOnClickListener {
            formula.text = "${formula.text}4"  // 表示値に 4 をAdd
            calcStr += "4"                   // 数字文字列に 4 をAdd

            // soundE(peoplestudiolaughlarge2.mp3) の再生
            soundPool.play(soundE, 1.0f, 1.0f, 1, 0, 1.0f)
        }


        buttonOf5.setOnClickListener {
            formula.text = "${formula.text}5"  // 表示値に 5 をAdd
            calcStr += "5"                   // 数字文字列に 5 をAdd

            // soundF(machinegun1.mp3) の再生
            soundPool.play(soundF, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        buttonOf6.setOnClickListener {
            formula.text = "${formula.text}6"  // 表示値に 6 をAdd
            calcStr += "6"                   // 数字文字列に 6 をAdd

            // soundG(conch1.mp3) の再生
            soundPool.play(soundG, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        buttonOf7.setOnClickListener {
            formula.text = "${formula.text}7"  // 表示値に 7 をAdd
            calcStr += "7"                   // 数字文字列に 7 をAdd

            // soundH(question1.mp3) の再生
            soundPool.play(soundH, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        buttonOf8.setOnClickListener {
            formula.text = "${formula.text}8"  // 表示値に 8 をAdd
            calcStr += "8"                   // 数字文字列に 8 をAdd

            // soundI(drumroll1.mp3) の再生
            soundPool.play(soundI, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        buttonOf9.setOnClickListener {
            formula.text = "${formula.text}9"  // 表示値に 9 をAdd
            calcStr += "9"                   // 数字文字列に 9 をAdd

            // soundJ(walkgeta1.mp3) の再生
            soundPool.play(soundJ, 1.0f, 1.0f, 1, 0, 1.0f)
        }


        /*******
         * . ボタンクリック時
         ********/
        buttonOfComma.setOnClickListener {
            formula.text = "${formula.text}."  // 表示値に . をAdd
            calcStr += "."                   // 数字文字列に . をAdd

            // soundK(walktussock1.mp3) の再生
            soundPool.play(soundK, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        /********
         * ＋ ボタン クリック時
         *******/
        additionButton.setOnClickListener {
            formula.text = "${formula.text}+"
            addList(calcStr, '+')
            calcStr = ""

            // soundL(dooropen1.mp3) の再生
            soundPool.play(soundL, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        /********
         * － ボタン クリック時
         *******/
        subtractionButton.setOnClickListener {
            formula.text = "${formula.text}-"
            addList(calcStr, '-')
            calcStr = ""

            // soundM(money1.mp3) の再生
            soundPool.play(soundM, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        /********
         * × ボタン クリック時
         *******/
        multipliButton.setOnClickListener {
            formula.text = "${formula.text}*"
            addList(calcStr, '*')
            calcStr = ""

            // soundN(aburazemicry1.mp3) の再生
            soundPool.play(soundN, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        /********
         * ÷ ボタン クリック時
         *******/
        divisionButton.setOnClickListener {
            formula.text = "${formula.text}/"
            addList(calcStr, '/')
            calcStr = ""

            // soundO(thunder1.mp3) の再生
            soundPool.play(soundO, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        /*******
        * DELボタン クリック時
         *******/
        deleteButton.setOnClickListener {
            var formStr = formula.text.toString()

            if(!formStr.isEmpty()){
                formula.text = formStr.subSequence(0, formStr.lastIndex)
            }

            if(!calcStr.isEmpty()){
                calcStr = calcStr.substring(0, calcStr.lastIndex)
            }

            // soundP(catcry1.mp3) の再生
            soundPool.play(soundP, 1.0f, 1.0f, 1, 0, 1.0f)

        }

        /*******
         * ％ ボタン クリック時
         *******/
        percentButton.setOnClickListener {
            formula.text = "${formula.text}%"

            // soundQ(elephant1.mp3) の再生
            soundPool.play(soundQ, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        /*******
         * +/- ボタン クリック時
         *******/
        plusMinusButton.setOnClickListener {

            // soundR(wave2.mp3) の再生
            soundPool.play(soundR, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        /*******
        * クリアボタン クリック時
         ******/
        clearButton.setOnClickListener {
            formula.text = ""
            calcStr = ""
            numberList.clear()
            operationList.clear()

            // soundS(gameswordmanstart1.mp3) の再生
            soundPool.play(soundS, 1.0f, 1.0f, 1, 0, 1.0f)
        }

        /********
        * ＝ ボタン クリック時
         ********/
        equalButton.setOnClickListener {
            formula.text = "${formula.text}="
            addList(calcStr)

            var result = calcualte().toString()
            formula.text = result
            calcStr = result
            numberList.clear()
            operationList.clear()

            // soundT(question2.mp3) の再生
            soundPool.play(soundT, 1.0f, 1.0f, 1, 0, 1.0f)
        }

    }

    fun addList(str : String, operation : Char) {
        try {
            // 数値文字列をキャスト
            var num = str.toDouble()

            // 数値用リストに追加
            numberList.add(num)
            // 操作用リストに追加
            operationList.add(operation)
        }catch (e:Exception){
            formula.text = "数値エラー"
        }
    }

    // イコール用
    fun addList(str : String){
        try{
            // 数値文字列をキャスト
            var num = str.toDouble()
            // 数値用リストに追加
            numberList.add(num)

        }catch(e:Exception){
            formula.text = "数値エラー"
        }

    }

    // 計算用
    fun calcualte() : Double {

        var i = 0
        while(i < operationList.size) {

            // 最初にかけ算と割り算を処理する
            if (operationList.get(i) == '*' || operationList.get(i) == '/') {
                var result =
                    // かけ算の場合
                    if (operationList.get(i) == '*') {
                        numberList.get(i) * numberList.get(i + 1)
                        // 割り算の場合
                    } else {
                        numberList.get(i) / numberList.get(i + 1)
                    }

                // 計算で使用した１つ目の数を計算結果に置き換え
                numberList.set(i, result)
                // 計算で使用した２つ目の数を削除
                numberList.removeAt(i + 1)
                // 計算済みの演算子をリストから削除
                operationList.removeAt(i)
                i--

            // 引き算を、足し算として扱う
            } else if (operationList.get(i) == '-') {
                operationList.set(i, '+')
                numberList.set(i + 1, numberList.get(i + 1) * (-1))
            }
            i++
        }

        // 合計の計算
        var result = 0.0
        for(i in numberList){
            result += i
        }

        return result
    }
}
