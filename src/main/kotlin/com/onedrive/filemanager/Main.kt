package com.onedrive.filemanager

import androidx.compose.ui.window.application
import com.onedrive.filemanager.ui.App
import com.onedrive.filemanager.di.initKoin

fun main() {
    initKoin()
    application {
        App()
    }
}