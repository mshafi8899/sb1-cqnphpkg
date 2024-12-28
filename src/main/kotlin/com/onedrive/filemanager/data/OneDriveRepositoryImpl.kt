package com.onedrive.filemanager.data

import com.microsoft.graph.models.DriveItem
import com.microsoft.graph.requests.GraphServiceClient
import com.onedrive.filemanager.data.auth.GraphAuthProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OneDriveRepositoryImpl(
    private val authProvider: GraphAuthProvider
) : OneDriveRepository {
    private lateinit var graphClient: GraphServiceClient<*>

    override suspend fun authenticate() {
        graphClient = authProvider.createGraphClient()
    }

    override suspend fun getMasterFolder(): DriveItem {
        return graphClient.me().drive()
            .root()
            .children()
            .buildRequest()
            .get()
            .currentPage
            .first()
    }

    // Other repository methods...
}