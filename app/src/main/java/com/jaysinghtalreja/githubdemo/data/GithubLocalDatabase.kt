package com.jaysinghtalreja.githubdemo.data

import android.content.Context
import androidx.room.*
import com.jaysinghtalreja.githubdemo.BuildConfig
import com.jaysinghtalreja.githubdemo.data.sourceofdata.dao.BeerDao
import com.jaysinghtalreja.githubdemo.data.sourceofdata.entity.Beer

@Database(
    entities = [
        Beer::class,
    ],
    version = BuildConfig.VERSION_CODE,
    exportSchema = false
)
@TypeConverters(TypeConverter::class)
abstract class GithubLocalDatabase : RoomDatabase() {

    /**
     * See [BeerDao]
     */
    abstract fun beerDao() : BeerDao


    companion object {

        // For Singleton instantiation
        @Volatile
        internal var instance: GithubLocalDatabase? = null
            private set

        private const val DATABASE_NAME: String = "githubdatabase"

        /**
         * Build and return an instance of [GithubDatabase]
         */
        fun getInstance(context: Context): GithubLocalDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): GithubLocalDatabase {
            return Room.databaseBuilder(context, GithubLocalDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
