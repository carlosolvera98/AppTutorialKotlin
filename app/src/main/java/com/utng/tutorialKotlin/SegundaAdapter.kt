package com.utng.tutorialKotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_segunda.view.*

class SegundaAdapter(private val mContext: Context, private val listaSegundas: List<Segunda>) : ArrayAdapter<Segunda>(mContext, 0, listaSegundas) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_segunda, parent, false)//Almacena los datos

        val producto = listaSegundas[position]//Toma la posicion de la lista

        layout.nombre.text = producto.titulo//Asigna el titulo

        layout.imageView.setImageResource(producto.imaTema//Asigna la imagen al item

        )

        return layout
    }

}