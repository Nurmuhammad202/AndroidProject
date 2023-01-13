package uz.personal.data.local.models.user

import androidx.room.ColumnInfo

data class CompanyLocal(
    val bs: String,
    @ColumnInfo(name = "catchPhrase")
    val catchPhrase: String,
    val nameCompany: String
)