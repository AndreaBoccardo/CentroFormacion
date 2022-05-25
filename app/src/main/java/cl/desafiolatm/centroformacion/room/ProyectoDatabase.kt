package cl.desafiolatm.centroformacion.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.desafiolatm.centroformacion.dao.CursoDao
import cl.desafiolatm.centroformacion.dao.CursosItemDao
import cl.desafiolatm.centroformacion.model.Curso
import cl.desafiolatm.centroformacion.model.ListaCursosItem

@Database(entities = [Curso::class, ListaCursosItem::class], version = 1)
abstract class ProyectoDatabase: RoomDatabase() {

    abstract fun cursoDao(): CursoDao
    abstract fun cursosItemDao(): CursosItemDao

    companion object{
        @Volatile
        private var instancia:ProyectoDatabase? = null

        fun getInstancia(context: Context) : ProyectoDatabase
        {
            if(instancia == null)
            {
                synchronized(this)
                {
                    instancia = Room.databaseBuilder(context,
                        ProyectoDatabase::class.java,
                        "proyecto_db")
                        .build()
                }
            }
            return instancia!!
        }
    }
}