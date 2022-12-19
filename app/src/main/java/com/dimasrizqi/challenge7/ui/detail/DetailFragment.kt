package com.dimasrizqi.challenge7.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.dimasrizqi.challenge7.databinding.FragmentDetailBinding
import com.dimasrizqi.challenge7.models.Data
import com.dimasrizqi.challenge7.service.TheMovieDBApiInterface
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment: Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    @Inject
    lateinit var api : TheMovieDBApiInterface

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAnalytics = Firebase.analytics

        getMovieDetails()
    }

    private fun getMovieDetails() {
        val id = arguments?.getInt("ID")
        api.getDetailsMovies(id).enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                val code = response.code()
                    if(code == 200){
                        val body = response.body()
                        Log.d("name", body.toString())
                        val imageBase = "https://image.tmdb.org/t/p/w500/"
                        binding.tvDetailTitle.text = body?.title
                        binding.tvDetailReleaseDate.text = body?.releaseDate
                        binding.tvMovieDescription.text = body?.description
                        binding.tvDetailRating.text = body?.rating.toString()
                        Glide.with(requireContext()).load(imageBase + body?.backdropPath).into(binding.ivDetailBanner)
                        Glide.with(requireContext()).load(imageBase + body?.posterPath).into(binding.ivDetailMovie)
                    }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {

            }

        })
    }


}