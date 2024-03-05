package com.utad.mvvmtareas.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.utad.mvvmtareas.data.network.model.HomeWorkResponse
import com.utad.mvvmtareas.databinding.ItemBinding

class HomeWorkAdapter: ListAdapter<HomeWorkResponse, HomeWorkAdapter.BaseAdapterViewHolder>(BaseItemCallBack){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        // 2 el binding es para modificar el layout que eh creado para cargar el objeto, en este caso: listado.xml
        val binding = ItemBinding.inflate(inflater, parent, false)
        return BaseAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseAdapterViewHolder, position: Int) {
        val tarea = getItem(position)
        // coloco lo que quiero que se muestre en mi lista,  uno el holder.binding con los id que he elegido
        holder.binding.tvTitle.text = tarea.title
        holder.binding.tvTeacher.text = tarea.teacherName
        holder.binding.tvSubjetcName.text = "${tarea.subject.title} - ${tarea.subject.classX}"
        holder.binding.tvDate.text = tarea.date
        holder.binding.tvMaterials.text = tarea.necessaryMaterials.toString()


    }
    // la inner class es la que devuelve el binding a mi vista
    inner class BaseAdapterViewHolder(val binding: ItemBinding):
        RecyclerView.ViewHolder(binding.root)

}

object BaseItemCallBack : DiffUtil.ItemCallback<HomeWorkResponse>() {
    override fun areItemsTheSame(oldItem: HomeWorkResponse, newItem: HomeWorkResponse): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeWorkResponse, newItem: HomeWorkResponse): Boolean {
        return oldItem == newItem
    }

}
// una vez tengo el adapter completo, vuelvo a la activity correspondiente para cargar el RV