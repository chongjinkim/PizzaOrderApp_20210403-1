package com.neppplus.pizzaorderapp_20210403.datas

import java.io.Serializable

//데이터 값을 위해 datas라는 패키지를 새로 생성을 한뒤에 멤버 변수를 적고 나서 String 타입으로 저장을 한다.
//그 뒤 에 이미 만들어 놓은 adapters파일에 StoreAdapter를 kotlin class를 통해서 생성을 한다.
class Store(
        val name : String,
        val logoURL : String,
        val phoneNum : String) : Serializable{

}