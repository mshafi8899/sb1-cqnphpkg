package com.onedrive.filemanager.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.onedrive.filemanager.ui.components.panels.MasterFolderPanel
import com.onedrive.filemanager.ui.components.panels.UserFoldersPanel
import com.onedrive.filemanager.viewmodel.FileManagerViewModel
import org.koin.java.KoinJavaComponent.inject

@Composable
@Preview
fun App() {
    val viewModel: FileManagerViewModel by inject(FileManagerViewModel::class.java)
    
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {
                MasterFolderPanel(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    viewModel = viewModel
                )
                
                Spacer(modifier = Modifier.width(16.dp))
                
                UserFoldersPanel(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    viewModel = viewModel
                )
            }
        }
    }
}