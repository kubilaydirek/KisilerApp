package com.example.kisileruygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.model.KisilerModel

class KisilerAdapter(val mContext: Context, var kisilerListesi: List<KisilerModel>) :
    RecyclerView.Adapter<KisilerAdapter.CardViewHolder>() {
    inner class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textBilgi: TextView

        init {
            textBilgi = view.findViewById(R.id.textViewKisiBilgi)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view =
            LayoutInflater.from(mContext).inflate(R.layout.card_tasarim, parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.textBilgi.text = kisilerListesi[position].kisi_ad
    }
}