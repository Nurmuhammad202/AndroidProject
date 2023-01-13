package uz.personal.data.local.models.user

import androidx.room.ColumnInfo

data class GeoLocal(
    @ColumnInfo(name = "lat")
    val lat: String,
    val lng: String
)