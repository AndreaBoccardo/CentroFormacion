package cl.desafiolatm.centroformacion.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatm.centroformacion.R
import cl.desafiolatm.centroformacion.databinding.ItemLayoutBinding
import cl.desafiolatm.centroformacion.model.ListaCursos
import cl.desafiolatm.centroformacion.model.ListaCursosItem
import com.squareup.picasso.Picasso

class CursosItemAdapter: RecyclerView.Adapter<CursosItemAdapter.CustomViewHolder>() {

    private var lista:List<ListaCursosItem> = ListaCursos()
    lateinit var listener: MiOnClickListener

    class CustomViewHolder(itemView: View, var listener: MiOnClickListener): RecyclerView.ViewHolder(itemView){

        private val binding = ItemLayoutBinding.bind(itemView)

        fun bindData(cursoItem: ListaCursosItem){
            with(binding){
                Picasso.get().load(cursoItem.image).resize(250,250)
                    .into(ivFotoItem)
                tvNombreItem.text = cursoItem.title
                itemView.setOnClickListener {
                    listener.onClickListener(cursoItem)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return CustomViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun updateData(lista:List<ListaCursosItem>){
        this.lista = lista
        notifyDataSetChanged()
    }

    interface MiOnClickListener{
        fun onClickListener(cursoItem: ListaCursosItem)
    }

    fun setMiOnClickListener(listener: MiOnClickListener)
    {
        this.listener = listener
    }
}