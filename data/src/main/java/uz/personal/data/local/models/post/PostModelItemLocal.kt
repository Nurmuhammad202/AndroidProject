package uz.personal.data.local.models.post

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post_item")
data class PostModelItemLocal(
    val body: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val userId: Int
)