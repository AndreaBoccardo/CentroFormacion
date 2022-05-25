package cl.desafiolatm.centroformacion.service

import cl.desafiolatm.centroformacion.model.Curso
import cl.desafiolatm.centroformacion.model.ListaCursos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CursoService {

    @GET("courses")
    fun getCourses(): Call<ListaCursos>

    @GET("courses_details/{id}")
    fun getCurso(@Path("id") id:String): Call<Curso>
}