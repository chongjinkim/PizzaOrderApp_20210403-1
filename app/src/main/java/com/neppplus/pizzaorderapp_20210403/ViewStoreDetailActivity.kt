package com.neppplus.pizzaorderapp_20210403

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.neppplus.pizzaorderapp_20210403.datas.Store
import kotlinx.android.synthetic.main.activity_view_store_detail.*

class ViewStoreDetailActivity : BaseActivity() {

    lateinit var mStore : Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        callBtn.setOnClickListener {

            val pl = object : PermissionListener {
                override fun onPermissionGranted() {

                    val myUri = Uri.parse("tel:${mStore.phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "전화 연결 불가.", Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission.with(mContext)
                    .setPermissionListener(pl)
                    .setDeniedMessage("[설정]에서 전화 권한을 허용해 주세요.")
                    .setPermissions(Manifest.permission.CALL_PHONE)
                    .check()

        }

    }

    override fun setValues() {

        mStore = intent.getSerializableExtra("store") as Store

        Glide.with(mContext).load(mStore.logoURL).into(logoImg)
        storeNameTxt.text = mStore.name
        phoneNumTxt.text = mStore.phoneNum

    }

}