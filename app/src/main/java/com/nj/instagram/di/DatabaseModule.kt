package com.nj.instagram.di

import android.content.Context
import androidx.room.Room
import com.nj.instagram.data.db.InstagramDataBase
import com.nj.instagram.data.db.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): InstagramDataBase {
        return Room.databaseBuilder(context,InstagramDataBase::class.java,"Instagram_db").build()
    }

    @Provides
    @Singleton
    fun providesUserDao(db: InstagramDataBase) =db.userDao()
}