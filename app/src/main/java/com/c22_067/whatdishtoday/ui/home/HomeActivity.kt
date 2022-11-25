package com.c22_067.whatdishtoday.ui.home

import android.app.Activity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.c22_067.whatdishtoday.R
import com.c22_067.whatdishtoday.adapter.ListKategoriAdapter
import com.c22_067.whatdishtoday.model.ModelKategori
import com.c22_067.whatdishtoday.model.ModelMakanan
import com.c22_067.whatdishtoday.network.Config
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class HomeActivity : AppCompatActivity() {

    var modelKategori: ModelKategori? = null
    var modelKategoriList: MutableList<ModelMakanan> = ArrayList()
    var listKategoriAdapter: ListKategoriAdapter? = null
    var strKategoriKey: String? = null
    var strKategori: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        listKategoriAdapter = ListKategoriAdapter(this, modelKategoriList)
        rv_makanan.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false))
        rvMakanan.setHasFixedSize(true)
        rvMakanan.setAdapter(listKategoriAdapter)
        rvMakanan.showShimmerAdapter()

        modelKategori = intent.getSerializableExtra(LIST_KATEGORI) as ModelKategori
        if (modelKategori != null) {
            strKategoriKey = modelKategori?.strKategoriKey
            strKategori = modelKategori?.strKategori
            tvTitleMakanan.setText(strKategori)

            //method get kategori
            getListKategori()
        }
    }

    private fun getListKategori() {
        AndroidNetworking.get(Config.BASEURL + Config.LIST_CATEGORIES)
            .addPathParameter("key", strKategoriKey)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    try {
                        val jsonArray = response.getJSONArray("results")
                        for (i in 0 until jsonArray.length()) {
                            val jsonObjectList = jsonArray.getJSONObject(i)
                            val dataApi = ModelMakanan()
                            dataApi.strTitleResep = jsonObjectList.getString("title")
                            dataApi.strThumbnail = jsonObjectList.getString("thumb")
                            dataApi.strKeyResep = jsonObjectList.getString("key")
                            modelKategoriList.add(dataApi)
                        }
                        listKategoriAdapter?.notifyDataSetChanged()
//                        rvListCategories.hideShimmerAdapter()
                    } catch (e: JSONException) {
                        e.printStackTrace()
                        Toast.makeText(this@HomeActivity,
                            "Gagal menampilkan resep masakan.", Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val LIST_KATEGORI = "strListKategori"
        fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
            val window = activity.window
            val layoutParams = window.attributes
            if (on) {
                layoutParams.flags = layoutParams.flags or bits
            } else {
                layoutParams.flags = layoutParams.flags and bits.inv()
            }
            window.attributes = layoutParams
        }
    }

}
