package ru.geekbreins.sbertest.model.local.roomDB

import android.arch.persistence.room.*

@Dao
interface RoomTranslateDAO {

    @Query("SELECT * FROM roomtranslateentity WHERE textOriginal = :text")
    fun findTranslateEntityByOriginalText(text: String): RoomTranslateEntity

    @Query("SELECT * FROM roomtranslateentity")
    fun getAllTranslateEntities(): List<RoomTranslateEntity>

    @Query("DELETE FROM roomtranslateentity")
    fun deleteAllTranslateEntities()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomTranslateEntity: RoomTranslateEntity)

    @Update
    fun update(roomTranslateEntity: RoomTranslateEntity)

    @Delete
    fun delete(roomTranslateEntity: RoomTranslateEntity)

}