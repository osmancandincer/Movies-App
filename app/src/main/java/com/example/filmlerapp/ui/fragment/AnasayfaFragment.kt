package com.example.filmlerapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmlerapp.R
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.databinding.FragmentAnasayfaBinding
import com.example.filmlerapp.ui.adapter.FilmlerAdapter
import com.example.filmlerapp.ui.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)

        binding.anasayfaToolbarBaslik = "Filmler"

       /* binding.filmRv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)*/

        /*val filmlerListesi = ArrayList<Filmler>()
        val f1 = Filmler(1, "Django", "django", 24)
        val f2 = Filmler(2, "Interstellar", "interstellar", 32)
        val f3 = Filmler(3, "Inception", "inception", 16)
        val f4 = Filmler(4, "The Hateful Eight", "thehatefuleight", 28)
        val f5 = Filmler(5, "The Pianist", "thepianist", 18)
        val f6 = Filmler(6, "Anadoluda", "anadoluda", 10)
        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)
        filmlerListesi.add(f5)
        filmlerListesi.add(f6)*/

        //resim isimleri drawabledaki resim dosyaları ile aynı isimde olmalı

        viewModel.filmlerListesi.observe(viewLifecycleOwner){
            val filmlerAdapter = FilmlerAdapter(requireContext(),it)
            binding.filmlerAdapter = filmlerAdapter
        }



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }


}
