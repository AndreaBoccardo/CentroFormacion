package cl.desafiolatm.centroformacion.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import cl.desafiolatm.centroformacion.model.Curso

@Dao
interface CursoDao {

    @Insert(onConflict = REPLACE)
    fun agregarCurso(curso: Curso)

    @Query("select description, id, image, minimumSkill, modality, scholarshipsAvailable, start, " +
            "title, tuition, weeks from curso_detalle")
    fun listarCurso(): LiveData<List<Curso>>

    @Query("select description, id, image, minimumSkill, modality, scholarshipsAvailable, start, " +
            "title, tuition, weeks from curso_detalle where id = :id")
    fun buscarCurso(id: String): Curso
}