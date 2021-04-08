package com.neppplus.pizzaorderapp_20210403

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.pizzaorderapp_20210403.adapters.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

//lateint var -> 나중에 대입 한다는 변수
//화면이 기능이 구현이 되지 않은 상태에서 대입을 하면 안된다.
//늦은 초기화 미리 이름만 올려놓고 추후에 변수를 초기화 할 때 사용한다.
//var이라서 언제든지 초기화가 가능 하기 때문이다.

    lateinit var mViewPagerAdapter : MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

 //mViewPagerADpaterm MainViewPagerAdapter(supportFragmentManager)
 //메인 뷰페이저와 어댑터를 연결한다.
        mViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager)
        mainViewPager.adapter = mViewPagerAdapter

//탭레이아웃 - Viewpager와 연결이 완료되었다.
//뷰페이저로 설치를 해주기.
        mainTabLayout.setupWithViewPager(mainViewPager)

    }


}