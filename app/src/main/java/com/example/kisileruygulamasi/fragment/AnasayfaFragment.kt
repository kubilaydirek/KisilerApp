package com.example.kisileruygulamasi.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.model.KisilerModel
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter

class AnasayfaFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var tasarim: FragmentAnasayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)
        tasarim.toolbar.title = "Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbar)

        tasarim.rv.layoutManager = LinearLayoutManager(requireContext())
        val kisilerListesi = ArrayList<KisilerModel>()
        val k1 = KisilerModel(1, "Kubilay", "11111111111")
        val k2 = KisilerModel(2, "Gizem", "2222222")
        val k3 = KisilerModel(3, "Ahmet", "123423412")
        val k4 = KisilerModel(4, "Zeliha", "6546457456")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        kisilerListesi.add(k4)

        val adapter = KisilerAdapter(requireContext(), kisilerListesi)
        tasarim.rv.adapter = adapter

        tasarim.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }

        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)

                val item = menu.findItem(R.id.action_ara)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@AnasayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false;
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return tasarim.root
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        ara(newText)
        return true
    }

    fun ara(aramaKelimesi: String) {
        Log.e("Kişi Ara", aramaKelimesi)
    }
}