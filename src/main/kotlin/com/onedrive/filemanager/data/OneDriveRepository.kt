package com.onedrive.filemanager.data

import com.microsoft.graph.models.DriveItem
import kotlinx.coroutines.flow.Flow

interface OneDriveRepository {
    suspend fun authenticate()
    suspend fun getMasterFolder(): DriveItem
    suspend fun getUserFolders(): List<DriveItem>
    suspend fun createUserFolder(name: String): DriveItem
    suspend fun assignFileToUser(fileId: String, userId: String)
    suspend fun unassignFileFromUser(fileId: String, userId: String)
    fun observeFileChanges(): Flow<DriveItem>
}