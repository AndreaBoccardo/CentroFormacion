package cl.desafiolatm.centroformacion.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cl.desafiolatm.centroformacion.model.ListaCursos
import cl.desafiolatm.centroformacion.room.ProyectoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CursosItemRepository(var context: Context) {

    private val db = ProyectoDatabase.getInstancia(context)

    fun agregarLista(listaCursos: ListaCursos){
        CoroutineScope(Dispatchers.IO).launch {
            db.cursosItemDao().agregarLista(listaCursos)
        }
    }

    fun listarCursos(): LiveData<List<ListaCursos>>{
        return db.cursosItemDao().listarCursos()
    }
}