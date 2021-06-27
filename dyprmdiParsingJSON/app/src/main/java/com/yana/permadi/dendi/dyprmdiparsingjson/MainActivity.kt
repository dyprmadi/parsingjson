package com.yana.permadi.dendi.dyprmdiparsingjson

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yana.permadi.dendi.dyprmdiparsingjson.model.DataItem
import com.yana.permadi.dendi.dyprmdiparsingjson.model.ResponUser
import com.yana.permadi.dendi.dyprmdiparsingjson.network.ApiConfig
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Response
import retrofit2.Call
import java.net.CacheResponse
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = UserAdapter(mutableListOf())


        rvuser.setHasFixedSize(true)
        rvuser.layoutManager = LinearLayoutManager(this)
        rvuser.adapter = adapter
        getUser()
    }

    private fun getUser() {
        val client = ApiConfig.getApiService().getListUsers("1")

        client.enqueue(object : retrofit2.Callback<ResponUser> {
            override fun onResponse(
                call: Call<ResponUser>,
                response: retrofit2.Response<ResponUser>
            ) {
                if (response.isSuccessful) {
                    val dataArray = response.body()?.data as List<DataItem>
                    for (data in dataArray) {
                        adapter.addUser(data)
                    }
                }
            }

            override fun onFailure(call: Call<ResponUser>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        })
    }
}