package com.jaysinghtalreja.githubdemo.data.sourceofdata.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.jaysinghtalreja.githubdemo.data.sourceofdata.entity.Beer

@Dao
interface BeerDao {

    @Query("SELECT * from beers")
    fun getAllBeers() : LiveData<List<Beer>>

    @Insert
    suspend fun insert(listBeer : List<Beer>)

    @Transaction
    suspend fun insertAll(listBeer: List<Beer>) {
        nuke()
        insert(listBeer)
    }

    @Query("DELETE from beers")
    suspend fun nuke()
}