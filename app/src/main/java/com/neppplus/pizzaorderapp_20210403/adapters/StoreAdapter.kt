package com.neppplus.pizzaorderapp_20210403.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.neppplus.pizzaorderapp_20210403.R
import com.neppplus.pizzaorderapp_20210403.datas.Store

//패키지 adapters파일에 StoreAdapter를 만들고 난 뒤에 ArrayAdapter를 상속받는다 <타입을 데이터타입 - Store로 넣은 뒤에>
//멤버 변수들을 만든뒤에 재료로 넣어준다. ArrayAdapter의 경우 기본생성자를 제공을 하지 않는다.
//재료는 거의 val mContext : Context, val resId : Int, val mList : ArrayList<Store>를 넣어준다.

class StoreAdapter(
        val mContext : Context,
        val resId : Int,
        val mList : ArrayList<Store>) : ArrayAdapter<Store>(mContext, resId, mList) {

//val inflater 변수를 만든다. xml에 정의 된 리소슬 view로 받아준다. 즉 xml을 불려오는 역할이다.
    val inflater = LayoutInflater.from(mContext)

 //getView 오버라이딩 진행 - position 위치 converView 재활용할 뷰 재활용할 view가 없기때문에 채워준다.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {

            tempRow = inflater.inflate(R.layout.store_list_item, null)

        }
     //tempRow 무조건 결과로 나가도 된다. 이미 채워진 상태이고 null인 상태가 아니기 때문이다.

        val row = tempRow!!

   //mList[] 뿌려줄 row안에있는 textview 변수로 담기
        val storeData = mList[position]

     //뿌려줄 ui에 있는 요소들을 가져오자 -> row 변수안에 있는 이미지뷰, 텍스트뷰 등을 꺼내오자, 참조 객체를 가져오는 것.
        val logoImg = row.findViewById<ImageView>(R.id.logoImg)
        val storeNameTxt = row.findViewById<TextView>(R.id.storeNameTxt)

     //실제 데이터 반영
        storeNameTxt.text = storeData.name
     //링크 반영 , 라이브러리에서 추가를 한 뒤에 -> build.gradle에서 추가
     //<uses-permission android:name="android.permission.INTERNET" />
     // android:usesCleartextTraffic="true" 해당 코드를 반드시 setting을 해주어야한다
       Glide.with(mContext).load(storeData.logoURL).into(logoImg)

       return row

    }

}