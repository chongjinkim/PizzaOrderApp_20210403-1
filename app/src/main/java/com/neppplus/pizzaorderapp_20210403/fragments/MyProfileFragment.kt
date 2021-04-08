package com.neppplus.pizzaorderapp_20210403.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.pizzaorderapp_20210403.EditNicknameActivity
import com.neppplus.pizzaorderapp_20210403.R
import kotlinx.android.synthetic.main.fragment_my_profile.*

class MyProfileFragment : Fragment() {

//    두번째 프래그먼트 또한 마찬가지이다
//    onCreateView 오버라이딩 진행을 하고 난 뒤에
//    onActiityCreated로 오버라이딩 진행후 - 화면에 동작을 실제로 하는 코드를 작성
//    어떤 작성화면을 쓸건지 onCreateView- inflater 오버라이딩 진행
    val REQUEST_FOR_NICKNAME = 1564

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//프로필 화면으로 이동
//startActivityForResult로 이동(매개변수 생성)
//어떤 데이터를 받으러 가는 지 알기 위해 숫자를 적용
        editNicknameBtn.setOnClickListener {

            val myIntent = Intent(activity, EditNicknameActivity::class.java)

            startActivityForResult(myIntent, REQUEST_FOR_NICKNAME)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_FOR_NICKNAME) {

            if (resultCode == Activity.RESULT_OK) {

                val newNickname = data?.getStringExtra("nick")

                nicknameTxt.text = newNickname

            }

        }

    }

}