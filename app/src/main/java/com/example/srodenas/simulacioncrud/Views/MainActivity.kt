package com.example.srodenas.simulacioncrud.Views

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.srodenas.simulacioncrud.Logic.Client
import com.example.srodenas.simulacioncrud.Logic.Controller
import com.example.srodenas.simulacioncrud.Logic.interfaces.OperationsInterface
import com.example.srodenas.simulacioncrud.R

class MainActivity : AppCompatActivity(), OperationsInterface {
    private lateinit var myButtonAdd: ImageView
    private lateinit var myButtonUpdate: ImageView
    private lateinit var myButtonDel: ImageView
    private lateinit var myDialog : Dialog
    private val controller= Controller()

    companion object {
        const val TAG = "---SALIDA---"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
  //      enableEdgeToEdge()  //barra superior transparente. App de borde a borde (toaaaa)
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        Log. d(TAG, "Esto es un ejemplo de log")
        start()
    }




    //Aquí comienza todo. Como si fuera nuestro main
    private fun start() {
        myButtonAdd = findViewById(R.id.myButtonAdd)
        myButtonUpdate = findViewById(R.id.myButtomEdit)
        myButtonDel = findViewById(R.id.myButtomDel)
        myDialog = Dialog()          // ya sin controller
        myDialog.setListener(this)

        myButtonAdd.setOnClickListener {
            myDialog.show(0)
        }
        myButtonUpdate.setOnClickListener {
            myDialog.show(1, controller.devIdRandom())   // el id aleatorio lo elige la pantalla
        }
        myButtonDel.setOnClickListener {
            myDialog.show(2, controller.devIdRandom())
        }
    }


    override fun ClientAdd(id: Int, name: String, apellidos: String, telefono: String) {
        controller.ClientAddController(Client(id, name, apellidos, telefono))
        Log.d(TAG, "El cliente con id = $id, ha sido insertado correctamente")
        showConsoleData()
    }

    override fun ClientDel(id: Int) {
        if (controller.ClientDelController(id))
            Log.d(TAG, "El cliente con id = $id, ha sido eliminado correctamente")
        else
            Log.d(TAG, "El cliente con id = $id, no ha sido encontrado para eliminar")
        showConsoleData()
    }



    override fun ClientUpdate(id: Int, name: String, apellidos: String, telefono: String) {
        if (controller.ClientUpdateController(id, name, apellidos, telefono))
            Log.d(TAG, "El cliente con id = $id, ha sido actualizado correctamente")
        else
            Log.d(TAG, "El cliente con id = $id, no ha sido encontrado para actualizar")
        showConsoleData()
    }

    fun showConsoleData() {
        Log.d(TAG, controller.showData())
    }
}