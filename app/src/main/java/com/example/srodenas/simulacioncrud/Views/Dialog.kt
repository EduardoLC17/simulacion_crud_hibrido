package com.example.srodenas.simulacioncrud.Views

import com.example.srodenas.simulacioncrud.Data.RepositoryClient
import com.example.srodenas.simulacioncrud.Logic.Controller
import com.google.android.material.animation.AnimatableView.Listener

//simulo un diálogo.
class Dialog(
    var clientAdd : (Int, String, String, String) -> Unit,
    var clientUpdate : (Int, String, String, String) -> Unit,
    var clientDel : (Int) -> Unit
) {

    fun show(typeAction : Int, id : Int = -1){
        when (typeAction){
            0 -> onAccept()
            1 -> if (id != -1) onEdit(id, "CAMBIADO", "APELLIDOS CAMBIADOS", "611111111")
            2 -> if (id != -1) onDelete(id)
        }
    }

    private fun onDelete(id : Int) {
        clientDel(id)
    }

    private fun onEdit(id: Int, name : String, apellidos : String, telefono : String) {
        clientUpdate(id, name, apellidos, telefono)
    }

    private fun onAccept() {
        clientAdd(RepositoryClient.incrementPrimary(), "NUEVO CLIENTE", "NUEVOS APELLIDOS", "622222222")
    }
}