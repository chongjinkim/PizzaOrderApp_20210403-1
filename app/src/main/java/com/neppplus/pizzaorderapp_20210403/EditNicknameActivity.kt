package com.neppplus.pizzaorderapp_20210403

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)
        setupEvents()
        setValues()
    }

    //이벤트 처리이기 때문에 setUpEvents에 작성
    override fun setupEvents() {

        okBtn.setOnClickListener {

            //문자열 생성 - 입력할시 문자열
         val inputNew = newNicknameEdt.text.toString()

         val resultIntent = Intent()

         resultIntent.putExtra("new", inputNew)

         setResult(Activity.RESULT_OK, resultIntent)

         finish()

        }

    }

    override fun setValues() {

    }

}