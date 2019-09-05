package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var calcStr : String = ""
    val numberList = ArrayList<Double>()
    val operationList = ArrayList<Char>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*******
         * 0 ～ 9 ボタンクリック時
         ********/
        buttonOf0.setOnClickListener {
            formula.text = "${formula.text}0"  // 表示値に 0 をAdd
            calcStr += "0"                     // 数字文字列に 0 をAdd
        }

        buttonOf1.setOnClickListener {
            formula.text = "${formula.text}1"  // 表示値に 1 をAdd
            calcStr += "1"                   // 数字文字列に 1 をAdd
        }

        buttonOf2.setOnClickListener {
            formula.text = "${formula.text}2"  // 表示値に 2 をAdd
            calcStr += "2"                   // 数字文字列に 2 をAdd
        }

        buttonOf3.setOnClickListener {
            formula.text = "${formula.text}3"  // 表示値に 3 をAdd
            calcStr += "3"                   // 数字文字列に 3 をAdd
        }

        buttonOf4.setOnClickListener {
            formula.text = "${formula.text}4"  // 表示値に 4 をAdd
            calcStr += "4"                   // 数字文字列に 4 をAdd
        }
        buttonOf5.setOnClickListener {
            formula.text = "${formula.text}5"  // 表示値に 5 をAdd
            calcStr += "5"                   // 数字文字列に 5 をAdd
        }

        buttonOf6.setOnClickListener {
            formula.text = "${formula.text}6"  // 表示値に 6 をAdd
            calcStr += "6"                   // 数字文字列に 6 をAdd
        }

        buttonOf7.setOnClickListener {
            formula.text = "${formula.text}7"  // 表示値に 7 をAdd
            calcStr += "7"                   // 数字文字列に 7 をAdd
        }

        buttonOf8.setOnClickListener {
            formula.text = "${formula.text}8"  // 表示値に 8 をAdd
            calcStr += "8"                   // 数字文字列に 8 をAdd
        }

        buttonOf9.setOnClickListener {
            formula.text = "${formula.text}9"  // 表示値に 9 をAdd
            calcStr += "9"                   // 数字文字列に 9 をAdd
        }


        /*******
         * . ボタンクリック時
         ********/
        buttonOfComma.setOnClickListener {
            formula.text = "${formula.text}."  // 表示値に . をAdd
            calcStr += "."                   // 数字文字列に . をAdd
        }

        /********
         * ＋ ボタン クリック時
         *******/
        additionButton.setOnClickListener {
            formula.text = "${formula.text}+"
            addList(calcStr, '+')
            calcStr = ""
        }

        /********
         * － ボタン クリック時
         *******/
        subtractionButton.setOnClickListener {
            formula.text = "${formula.text}-"
            addList(calcStr, '-')
            calcStr = ""
        }

        /********
         * × ボタン クリック時
         *******/
        multipliButton.setOnClickListener {
            formula.text = "${formula.text}*"
            addList(calcStr, '*')
            calcStr = ""
        }

        /********
         * ÷ ボタン クリック時
         *******/
        divisionButton.setOnClickListener {
            formula.text = "${formula.text}/"
            addList(calcStr, '/')
            calcStr = ""
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

        }

        /*******
         * ％ ボタン クリック時
         *******/
        percentButton.setOnClickListener {
            formula.text = "${formula.text}%"
        }

        /*******
         * +/- ボタン クリック時
         *******/
        plusMinusButton.setOnClickListener {

        }

        /*******
        * クリアボタン クリック時
         ******/
        clearButton.setOnClickListener {
            formula.text = ""
            calcStr = ""
            numberList.clear()
            operationList.clear()
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
