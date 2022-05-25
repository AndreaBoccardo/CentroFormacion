package cl.desafiolatm.centroformacion.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cl.desafiolatm.centroformacion.model.Curso
import cl.desafiolatm.centroformacion.room.ProyectoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CursoRepository(var context: Context) {

    private val db = ProyectoDatabase.getInstancia(context)

    fun agregarCurso(curso: Curso){
        CoroutineScope(Dispatchers.IO).launch {
            db.cursoDao().agregarCurso(curso)
        }
    }

    fun listarCurso(): LiveData<List<Curso>>{
        return db.cursoDao().listarCurso()
    }

    fun buscarCurso(id: String): Curso{
        return db.cursoDao().buscarCurso(id)
    }
}