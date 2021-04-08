package com.neppplus.pizzaorderapp_20210403.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.pizzaorderapp_20210403.R
import com.neppplus.pizzaorderapp_20210403.ViewStoreDetailActivity
import com.neppplus.pizzaorderapp_20210403.adapters.StoreAdapter
import com.neppplus.pizzaorderapp_20210403.datas.Store
import kotlinx.android.synthetic.main.fragment_pizza_store_list.*

class PizzaStoreListFragment : Fragment() {
//fragments폴더에서 - PizzaStoreListFragment를 만든 후에fragment()를 상속을 받게 된다.\
 //그 후 에 onCreateView를 오버라이딩을 한뒤에
 //return inflater.inflate(R.Layout. 어느 레이아웃을 올릴지, contaitner, false
 // inlfater 하나의 함수를 가져오기 위한 기능

  //ArrayList에 대한 변수를 만들고 난 뒤에 데이터를 채워줄 ArrayList를 만들어 준다.
    val mPizzaStoreList = ArrayList<Store>()

//피자가 어댑터를 초기화 시켜 준다. - 화면에 기능이 구현이 되지 않은 상태에서
//초기화를 하면 안되기 때문에 lateint var 를 사용한다.

    lateinit var mPizzaStoreAdapter : StoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pizza_store_list, container, false)
    }

//onActivitiyCreated - 화면에 있는 동작 코드들은 onActivityCreated 작성-storeList 등등

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

 //데이터 연결 채워줌
        mPizzaStoreList.add( Store("피자헛", "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg", "1588-5588") )
        mPizzaStoreList.add( Store("파파존스", "http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800", "1577-8080") )
        mPizzaStoreList.add( Store("미스터피자", "https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200", "1577-0077") )
        mPizzaStoreList.add( Store("도미노피자", "https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png", "1577-3082") )

  //어댑터와 데이터를 연결을 한다. 위치를 어디다 뿌릴건지, 어떤 xml을 뿌릴것이며 어떤 데이터를 첨부할 것인지 해본다.

        mPizzaStoreAdapter = StoreAdapter(activity!!, R.layout.store_list_item, mPizzaStoreList)
        pizzaStoreListView.adapter = mPizzaStoreAdapter


        //리스트뷰에서 어디든 클릭하면은 상세화면으로 넘어감.
        pizzaStoreListView.setOnItemClickListener { parent, view, position, id ->

            val clickedStore = mPizzaStoreList[position]
            //BaseActivity - val mContext = this 변수를 통해서 activity를 사용
            val myIntent = Intent(activity, ViewStoreDetailActivity::class.java)

            myIntent.putExtra("store", clickedStore)

            startActivity(myIntent)


        }

    }

}










