package com.example.mangalist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mangalist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Manga>()

//    private fun showSelectedHero(manga: Manga) {
//        val intent = Intent(this@MainActivity, Pindah::class.java)
//        startActivity(intent)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvHeroes
        binding.rvHeroes.setHasFixedSize(true)

        list.addAll(getListManga())
        showRecyclerList()

    }

    private fun getListManga(): ArrayList<Manga> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listManga = ArrayList<Manga>()
        for (i in dataName.indices) {
            val manga = Manga(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listManga.add(manga)
        }
        return listManga
    }

    private fun showRecyclerList() {
        binding.rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list, this)
        binding.rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallBack(object : ListHeroAdapter.OnItemClickCallBack {
            override fun onItemClicked(data: Manga) {
                val intentToDetail = Intent(this@MainActivity, Pindah::class.java)
                intentToDetail.putExtra(Pindah.KEY_HERO, data.name)
                startActivity(intentToDetail)
            }
        })
    }
}