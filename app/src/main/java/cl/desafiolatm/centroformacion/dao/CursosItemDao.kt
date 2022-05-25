package cl.desafiolatm.centroformacion.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import cl.desafiolatm.centroformacion.model.ListaCursos

@Dao
interface CursosItemDao {

    @Insert(onConflict = REPLACE)
    fun agregarLista(listaCursos: ListaCursos)

    @Query("select id, image, previewDescription, start, title, weeks from curso_lista")
    fun listarCursos(): LiveData<List<ListaCursos>>
}