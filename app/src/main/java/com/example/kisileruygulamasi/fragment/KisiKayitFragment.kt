package com.example.kisileruygulamasi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentKisiKayitBinding

class KisiKayitFragment : Fragment() {
    private lateinit var tasarim: FragmentKisiKayitBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentKisiKayitBinding.inflate(inflater, container, false)
        tasarim.toolbarKisiKayit.title ="Kişi Kayıt"

        tasarim.buttonKaydet.setOnClickListener {
            val kisiAdi = tasarim.editTextKisiAd.text.toString();
            val kisiTel = tasarim.editTextKisiTel.text.toString();
        }
        return tasarim.root
    }


}