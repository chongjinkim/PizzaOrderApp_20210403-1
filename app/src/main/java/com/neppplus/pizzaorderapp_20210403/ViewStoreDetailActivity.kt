package com.neppplus.pizzaorderapp_20210403

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.neppplus.pizzaorderapp_20210403.datas.Store
import kotlinx.android.synthetic.main.activity_view_store_detail.*

//BaseActivity - 상속을 받는다.
class ViewStoreDetailActivity : BaseActivity() {

    lateinit var mStore: Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
//전화 기능을 위해서는 tedPermissinons 라이브러리를 이용을 한다.
// <uses-permission android:name="android.permission.CALL_PHONE" />  해당 코드 추가.

        callBtn.setOnClickListener {

            val p1 = object : PermissionListener {

                override fun onPermissionGranted() {
                    val myUri = Uri.parse("tel:${mStore.phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "전화 연결 불가", Toast.LENGTH_SHORT).show()
                }


            }

            //실제 권한을 확인하는 요청을 해야한다.
            TedPermission.with(mContext)
                    .setPermissionListener(p1)
                    .setDeniedMessage("권한을 허용 해 주세요")
                    .setPermissions(Manifest.permission.CALL_PHONE)
                    .check()

        }
        //Ui화면에서 쓰이기 때문에 setValues에서 기능을 구현한다.
// Serializable을 사용하였기 때문에 클래스 첨부 ,꺼내오기가 가능하다.
        override fun setValues() {

            mStore = intent.getSerializableExtra("store") as Store

            Glide.with(mContext).load(mStore.logoURL).into(logoImg)
            storeNameTxt.text = mStore.name
            phoneNumTxt.text = mStore.phoneNum

        }

    }
}