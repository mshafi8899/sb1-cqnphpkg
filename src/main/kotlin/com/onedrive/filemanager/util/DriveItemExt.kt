package com.onedrive.filemanager.util

import com.microsoft.graph.models.DriveItem

fun DriveItem.isFolder(): Boolean = folder != null
fun DriveItem.displayName(): String = name ?: "Unnamed"
fun DriveItem.parentId(): String? = parentReference?.id