/**
 *  PDFViewerContainer.kt
 *  PulseFeed
 *
 *  Created by Ibrahim Mohammed on 05/03/2026.
 */

package com.pulsefeed.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import android.net.Uri

@Composable
fun PDFViewerContainer(
    fileUri: Uri,
    isPresented: MutableState<Boolean>
) {
    PDFPageViewer(
        documentUri = fileUri,
        isPresented = isPresented,
        modifier = Modifier.fillMaxSize()
    )
}
