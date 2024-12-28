package com.onedrive.filemanager.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.microsoft.graph.models.DriveItem

@Composable
fun FileList(
    modifier: Modifier = Modifier,
    files: List<DriveItem>,
    onFileClick: (DriveItem) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(files) { file ->
            FileListItem(
                file = file,
                onClick = { onFileClick(file) }
            )
        }
    }
}