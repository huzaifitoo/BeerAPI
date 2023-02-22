package com.example.beerapi.Fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import com.example.beerapi.Adapters.BeerAdapter
import com.example.beerapi.DetailsActivity
import com.example.beerapi.Network.*
import com.example.beerapi.R
import com.example.beerapi.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var mArticle: ArrayList<ResponseBeerModelItem> = arrayListOf()
    private lateinit var adapter: BeerAdapter
    private var price: Double = 0.00

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)


        val res = RetrofitClient().getClient()
            .create(APIInterface::class.java)

        res.getBeers().enqueue(object : Callback<ResponseBeerModel> {
            override fun onResponse(
                call: Call<ResponseBeerModel>,
                response: Response<ResponseBeerModel>
            ) {

                response.body()?.let { mArticle.addAll(it) }!!

                val recyclerView = binding.recyclerView
                adapter = BeerAdapter(requireContext(), mArticle)
                recyclerView.adapter = adapter

                adapter.setOnItemClickListener(object : BeerAdapter.onItemClickListener {
                    override fun onItemClick(position: Int) {

                        Toast.makeText(requireContext(), "clicked on $position", Toast.LENGTH_SHORT)
                            .show()

                        val intent = Intent(requireContext(), DetailsActivity::class.java)
                        intent.putExtra("name", mArticle[position].name)
                        intent.putExtra("img_url", mArticle[position].image_url)
                        intent.putExtra("description", mArticle[position].description)

                        startActivity(intent)
                    }
                })

                Log.d("Data", response.body().toString())
            }

            override fun onFailure(call: Call<ResponseBeerModel>, t: Throwable) {

                t.message?.let { Log.d("error something wrong", it) }
            }

        })















        return binding.root
    }


}
