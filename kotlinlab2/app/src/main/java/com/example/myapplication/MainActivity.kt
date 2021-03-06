package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_mora.setOnClickListener {
            if(ed_name.length()<1)
                tv_text.text ="請輸入玩家姓名"
            else
                tv_name.text= String.format("名字\n%s", ed_name.text )
                tv_mmora.text= String.format("我方出拳\n%s", when {
                    btn_scissor.isChecked -> "剪刀"
                    btn_stone.isChecked -> "石頭"
                    else -> "布"
                })
            var computer =(Math.random()*3).toInt()
            tv_cmora.text= String.format("電腦出拳\n%s", when (computer) {
                0 -> "剪刀"
                1 -> "石頭"
                else -> "布"
            })
            when{
                btn_scissor.isChecked && computer==2 || btn_stone.isChecked && computer==0 ||
                        btn_paper.isChecked && computer==1 ->
                {
                    tv_winner.text = String.format("勝利者\n%s", ed_name.text)
                    tv_text.text = "恭喜你獲勝了"
                }
                btn_scissor.isChecked && computer==1 || btn_stone.isChecked && computer==2 ||
                        btn_paper.isChecked && computer==0 ->
                {
                    tv_winner.text = "勝利者\n電腦"
                    tv_text.text = "可惜，電腦獲勝了！"
                }
                else ->{
                            tv_winner.text = "勝利者\n平手"
                            tv_text.text = "平局，請再試一次！"
                    }
                }
        }

        }
    }
