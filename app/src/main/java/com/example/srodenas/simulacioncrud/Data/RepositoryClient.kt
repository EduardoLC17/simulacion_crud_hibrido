package com.example.srodenas.simulacioncrud.Data

import com.example.srodenas.simulacioncrud.Logic.Client


class RepositoryClient {

    companion object {  //Sólo puedo tener un companion object por clase.
        var primary = 100

        val arrayClient : List<Client> = listOf (
            Client (RepositoryClient.incrementPrimary(), "Santi", "Garcia Lopez", "600111222"),
            Client (RepositoryClient.incrementPrimary(), "Sonia", "Ruiz Perez", "600333444"),
            Client (RepositoryClient.incrementPrimary(), "Guille", "Moreno Diaz", "600555666"),
            Client (RepositoryClient.incrementPrimary(), "Diego", "Torres Gil", "600777888")
        )

        fun incrementPrimary() = primary ++ //devuelvo la clave e incremento.
    }

}
//Ya tengo mi Lista inmutable de Clientes.

/*
Importante, ver que si declaro una clase terminado en (), lo que quiero decir que la voy a
instanciar ya que sería el constructor primario. Sin embargo, como no quiero objeto, no tiene sentido
declarala con un constructor por defecto, ni bloque ini, ni nada.
 */
