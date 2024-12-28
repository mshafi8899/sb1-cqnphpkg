package com.onedrive.filemanager.di

import com.onedrive.filemanager.data.OneDriveRepository
import com.onedrive.filemanager.data.OneDriveRepositoryImpl
import com.onedrive.filemanager.data.auth.GraphAuthProvider
import com.onedrive.filemanager.viewmodel.FileManagerViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}

val appModule = module {
    single { GraphAuthProvider() }
    single<OneDriveRepository> { OneDriveRepositoryImpl(get()) }
    single { FileManagerViewModel(get()) }
}