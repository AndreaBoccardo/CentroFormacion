package cl.desafiolatm.centroformacion.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "curso_lista")
data class ListaCursosItem(
    @SerializedName("id")
    @PrimaryKey
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("previewDescription")
    val previewDescription: String,
    @SerializedName("start")
    val start: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("weeks")
    val weeks: Int
)