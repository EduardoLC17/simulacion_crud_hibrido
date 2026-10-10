package com.example.srodenas.simulacioncrud.Views

import com.example.srodenas.simulacioncrud.Data.RepositoryClient
import com.example.srodenas.simulacioncrud.Logic.Controller
import com.example.srodenas.simulacioncrud.Logic.interfaces.OperationsInterface
import com.google.android.material.animation.AnimatableView.Listener

//simulo un diálogo. Ya no recibe el Controller.
class Dialog {
    private var listener: OperationsInterface? = null

    fun setListener ( _listener : OperationsInterface){
        listener = _listener
    }

    //la pantalla me pasa el id ya elegido (-1 si no hay clientes) para editar/borrar
    fun show(typeAction : Int, id : Int = -1){
        listener?.let{
            when (typeAction){
                0 -> onAccept()

                1 ->
                    if (id != -1)
                        onEdit(id, "CAMBIADO", "APELLIDOS CAMBIADOS", "611111111")

                2 ->
                    if (id != -1)
                        onDelete(id)
            }
        }
    }

    private fun onDelete(id : Int) {
        listener!!.ClientDel(id)
    }

    private fun onEdit(id: Int, name : String, apellidos : String, telefono : String) {
        listener!!.ClientUpdate(id, name, apellidos, telefono)
    }

    private fun onAccept() {
        listener!!.ClientAdd(RepositoryClient.incrementPrimary(), "NUEVO CLIENTE", "NUEVOS APELLIDOS", "622222222")
    }
}