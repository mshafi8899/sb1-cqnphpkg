package com.onedrive.filemanager.viewmodel

import com.microsoft.graph.models.DriveItem
import com.onedrive.filemanager.data.OneDriveRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FileManagerViewModel(
    private val repository: OneDriveRepository
) {
    private val _masterFiles = MutableStateFlow<List<DriveItem>>(emptyList())
    val masterFiles: StateFlow<List<DriveItem>> = _masterFiles

    private val _userFolders = MutableStateFlow<List<DriveItem>>(emptyList())
    val userFolders: StateFlow<List<DriveItem>> = _userFolders

    suspend fun authenticate() {
        repository.authenticate()
    }

    suspend fun refreshMasterFolder() {
        val masterFolder = repository.getMasterFolder()
        _masterFiles.value = listOf(masterFolder)
    }

    // Implement other view model methods...
}