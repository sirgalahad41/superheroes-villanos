package com.ucaldas.aplicacion1

object Utils {
    object Rutas {
        const val LISTA = "lista"
        const val DETALLE = "detalle/{id}/{villano}"
        fun detalle(id: Int, esVillano: Boolean = false) = "detalle/$id/$esVillano"
    }
}
