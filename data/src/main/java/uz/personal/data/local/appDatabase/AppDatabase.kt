package uz.personal.data.local.appDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.personal.data.local.RoomDaoInterface
import uz.personal.data.local.models.post.PostModelItemLocal
import uz.personal.data.local.models.user.UsersItemLocal

@Database(
    entities = [UsersItemLocal::class, PostModelItemLocal::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): RoomDaoInterface

    companion object {
        private var dbINSTANCE: AppDatabase? = null

        fun getDataDB(context: Context): AppDatabase {
            if (dbINSTANCE == null) {
                dbINSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "OndaRoom"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return dbINSTANCE!!
        }
    }
}