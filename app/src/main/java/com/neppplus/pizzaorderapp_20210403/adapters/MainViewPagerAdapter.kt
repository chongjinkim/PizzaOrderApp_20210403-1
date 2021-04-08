package com.neppplus.pizzaorderapp_20210403.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.neppplus.pizzaorderapp_20210403.fragments.MyProfileFragment
import com.neppplus.pizzaorderapp_20210403.fragments.PizzaStoreListFragment

class MainViewPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

//    MainViewPagerAdapter를 만들어준 뒤에 재료로 fm : 타입 FragnmetManger를 입력을 한 뒤에
//    FragmentPagerAdapter를 상속을 받음
//    FragementPagerAdapter에 재료 자식의 변수 - fm을 넣어주면 FragmentManger오류가 없어짐

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "피자주문"
            else -> "내 정보 설정"
        }
    }

//    getItem - 각각의 position에 맞는 프래그먼트 객체를 리턴
//  각각 위치에 맞는 Fragment 객체를 리턴한다.
//각각의 Fragment위치에 맞는 객체를 리턴한다.
    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> PizzaStoreListFragment()
            else -> MyProfileFragment()
        }

    }
//getCount - 들어갈 Fragment가 2개이기 때문에 return 2를 넣어준다.
    override fun getCount(): Int {
        return 2
    }
}