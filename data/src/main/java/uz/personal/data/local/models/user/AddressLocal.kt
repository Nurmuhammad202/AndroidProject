package uz.personal.data.local.models.user

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class AddressLocal(
    @ColumnInfo(name = "city")
    val city: String,
    @Embedded val geo: GeoLocal,
    val street: String,
    val suite: String,
    val zipcode: String
)