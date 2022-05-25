package cl.desafiolatm.centroformacion.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cl.desafiolatm.centroformacion.model.Curso
import cl.desafiolatm.centroformacion.model.ListaCursos
import cl.desafiolatm.centroformacion.repository.ClienteRepository
import cl.desafiolatm.centroformacion.repository.CursoRepository
import cl.desafiolatm.centroformacion.repository.CursosItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CursoViewModel(application: Application): AndroidViewModel(application) {

    private val clienteRepo = ClienteRepository()
    private val cursosItemRepo = CursosItemRepository(getApplication())
    private val cursoRepo = CursoRepository(getApplication())
    private val log = "ERROR_CALL"
    var id = MutableLiveData<String>()

    val listaCursos = cursosItemRepo.listarCursos()
    val listaCurso = cursoRepo.listarCurso()
    val curso:MutableLiveData<Curso> = MutableLiveData()

    fun callCursosItem(){
        clienteRepo.getListaCursos().enqueue(object : Callback<ListaCursos>{
            override fun onResponse(call: Call<ListaCursos>, response: Response<ListaCursos>) {
                response.body().let {
                    cursosItemRepo.agregarLista(it!!)
                }
            }

            override fun onFailure(call: Call<ListaCursos>, t: Throwable) {
                Log.e(log,t.message.toString())
            }

        })
    }

    fun getCurso(id:String){
        clienteRepo.getCurso(id).enqueue(object : Callback<Curso>{
            override fun onResponse(call: Call<Curso>, response: Response<Curso>) {
                response.body().let {
                    cursoRepo.agregarCurso(it!!)
                }
            }

            override fun onFailure(call: Call<Curso>, t: Throwable) {
                Log.e(log,t.message.toString())
            }

        })
    }

    fun buscarCursos(){
        CoroutineScope(Dispatchers.IO).launch {
            curso.postValue(cursoRepo.buscarCurso(id.value!!))
        }
    }

}