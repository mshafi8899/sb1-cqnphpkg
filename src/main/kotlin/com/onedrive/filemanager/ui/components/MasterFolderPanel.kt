package com.onedrive.filemanager.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.onedrive.filemanager.viewmodel.FileManagerViewModel

@Composable
fun MasterFolderPanel(
    modifier: Modifier = Modifier,
    viewModel: FileManagerViewModel
) {
    val files by viewModel.masterFiles.collectAsState()
    
    Surface(
        modifier = modifier,
        tonalElevation = 1.dp
    ) {
        Column {
            Text(
                text = "Master Folder",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
            
            FileList(
                files = files,
                onFileClick = { /* Handle file click */ }
            )
        }
    }
}