package com.neppplus.pizzaorderapp_20210403

import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    val mContext = this //상황에따라 this를

    abstract fun setupEvents()// 이벤트 처리를 하기 위한 함수
    abstract fun setValues()// 화면에 UI(값)을 띄워주기 위한 함수

//추상메쏘드 -함수는 물려주지만 내용물은 알아서 구현하게 하자, 다들 제각각
 //상속받는 액티비티들이 반드시 구현을 해야함


}