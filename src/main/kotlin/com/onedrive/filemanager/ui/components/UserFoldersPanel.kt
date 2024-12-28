package com.onedrive.filemanager.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.onedrive.filemanager.viewmodel.FileManagerViewModel

@Composable
fun UserFoldersPanel(
    modifier: Modifier = Modifier,
    viewModel: FileManagerViewModel
) {
    val userFolders by viewModel.userFolders.collectAsState()
    
    Surface(
        modifier = modifier,
        tonalElevation = 1.dp
    ) {
        Column {
            Text(
                text = "User Folders",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
            
            FileList(
                files = userFolders,
                onFileClick = { /* Handle file click */ }
            )
        }
    }
}