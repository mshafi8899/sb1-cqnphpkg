package com.onedrive.filemanager.util

object AuthConfig {
    const val CLIENT_ID = "YOUR_CLIENT_ID"
    const val TENANT_ID = "YOUR_TENANT_ID"
    val SCOPES = arrayOf(
        "Files.ReadWrite.All",
        "User.Read"
    )
}