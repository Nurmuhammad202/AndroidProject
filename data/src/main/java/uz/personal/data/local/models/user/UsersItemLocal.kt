package uz.personal.data.local.models.user

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UsersLocal")
data class UsersItemLocal(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @Embedded val address: AddressLocal,
    @Embedded val company: CompanyLocal,
    val email: String,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)