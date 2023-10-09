package com.samigehi.koin.app.di

import android.content.Context
import androidx.room.Room
import com.samigehi.koin.data.database.ContactDatabase
import com.samigehi.koin.data.interfaces.ContactDataSource
import com.samigehi.koin.data.source.local.LocalSource
import com.samigehi.koin.data.source.remote.RemoteSource
import com.samigehi.koin.data.source.remote.api.ApiService
import com.samigehi.koin.domain.interfaces.ContactRepository
import com.samigehi.koin.domain.interfaces.usecases.CreateContactUseCase
import com.samigehi.koin.domain.interfaces.usecases.DeleteContactUseCase
import com.samigehi.koin.domain.interfaces.usecases.GetAllContactsUseCase
import com.samigehi.koin.domain.interfaces.usecases.UpdateContactUseCase
import com.samigehi.koin.domain.repositories.ContactRepositoryImpl
import com.samigehi.koin.domain.repositories.DataSourceImpl
import com.samigehi.koin.domain.usecases.contact.CreateContact
import com.samigehi.koin.domain.usecases.contact.DeleteContact
import com.samigehi.koin.domain.usecases.contact.GetContacts
import com.samigehi.koin.domain.usecases.contact.UpdateContact
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesContactsLocalDataSource(@ApplicationContext context: Context): ContactDataSource {
        return LocalSource(
            Room.databaseBuilder(context, ContactDatabase::class.java, ContactDatabase.DATABASE_NAME).build().contactDao
        )
    }

    @Provides
    @Singleton
    fun providesLocalDataSource(@ApplicationContext context: Context): LocalSource {
        return LocalSource(
            Room.databaseBuilder(context, ContactDatabase::class.java, ContactDatabase.DATABASE_NAME).build().contactDao
        )
    }

    @Provides
    @Singleton
    fun providesRemoteDataSource(@ApplicationContext context: Context): RemoteSource {
        return RemoteSource(ApiService.Factory.create())
    }

    @Provides
    @Singleton
    fun providesDataSource(@ApplicationContext context: Context): DataSourceImpl {
        return DataSourceImpl(providesLocalDataSource(context), RemoteSource(providesApiService()))
    }


    @Provides
    @Singleton
    fun providesContactRepository(dataSource: ContactDataSource): ContactRepository {
        return ContactRepositoryImpl(contactDataSource = dataSource)
    }

    @Provides
    @Singleton
    fun providesApiService(): ApiService {
        return ApiService.Factory.create()
    }

    @Provides
    @Singleton
    fun providesGetContactsUseCase(repository: ContactRepository): GetAllContactsUseCase {
        return GetContacts(contactRepository = repository)
    }

    @Provides
    @Singleton
    fun providesCreateContactUseCase(repository: ContactRepository): CreateContactUseCase {
        return CreateContact(contactRepository = repository)
    }

    @Provides
    @Singleton
    fun providesDeleteContactUseCase(repository: ContactRepository): DeleteContactUseCase {
        return DeleteContact(contactRepository = repository)
    }

    @Provides
    @Singleton
    fun providesUpdateContactUseCase(repository: ContactRepository): UpdateContactUseCase {
        return UpdateContact(contactRepository = repository)
    }

}