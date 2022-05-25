package cl.desafiolatm.centroformacion.repository

import cl.desafiolatm.centroformacion.client.ClienteRetrofit
import cl.desafiolatm.centroformacion.model.Curso
import cl.desafiolatm.centroformacion.model.ListaCursos
import retrofit2.Call

class ClienteRepository {

    private val cliente = ClienteRetrofit.getInstancia(ClienteRetrofit.base_url)

    fun getListaCursos(): Call<ListaCursos>{
        return cliente.getCourses()
    }

    fun getCurso(id:String): Call<Curso>{
        return cliente.getCurso(id)
    }
}