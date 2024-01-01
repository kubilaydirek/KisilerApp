package com.example.kisileruygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.fragment.AnasayfaFragmentDirections
import com.example.kisileruygulamasi.model.KisilerModel
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(val mContext: Context, var kisilerListesi: List<KisilerModel>) :
    RecyclerView.Adapter<KisilerAdapter.CardViewHolder>() {
    inner class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textBilgi: TextView
        val kisiSilImage: ImageView
        val cardView: CardView

        init {
            textBilgi = view.findViewById(R.id.textViewKisiBilgi)
            kisiSilImage = view.findViewById(R.id.imageViewSil)
            cardView = view.findViewById(R.id.satirCard)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.card_tasarim, parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.textBilgi.text = kisilerListesi[position].kisi_ad

        holder.cardView.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisilerListesi[position])
            Navigation.findNavController(it).navigate(gecis)
        }

        holder.kisiSilImage.setOnClickListener {
            Snackbar.make(
                it, "${kisilerListesi[position].kisi_ad} silinsin mi?", Snackbar.LENGTH_LONG
            ).setAction("EVET") {

            }.show()
        }
    }
}