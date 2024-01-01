package com.example.kisileruygulamasi.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentKisiDetayBinding

class KisiDetayFragment : Fragment() {
    private lateinit var tasarim: FragmentKisiDetayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentKisiDetayBinding.inflate(inflater, container, false)
        tasarim.toolbarKisiDetay.title = "Kişi Detay"

        val bundle: KisiDetayFragmentArgs by navArgs();
        val gelenKisi = bundle.kisi

        tasarim.editTextKisiAd.setText(gelenKisi.kisi_ad)
        tasarim.editTextKisiTel.setText(gelenKisi.kisi_tel)


        tasarim.buttonGuncelle.setOnClickListener {
            val kisiAdi = tasarim.editTextKisiAd.text.toString();
            val kisiTel = tasarim.editTextKisiTel.text.toString();
            guncelle(gelenKisi.kisi_id, kisiAdi, kisiTel)
        }
        return tasarim.root
    }

    fun guncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        Log.i("Kişi Güncelle", "$kisi_id - $kisi_ad - $kisi_tel")
    }
}