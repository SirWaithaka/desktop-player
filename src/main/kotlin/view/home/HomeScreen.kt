package view.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Text(
        text = "Welcome, Starting up ...",
        style = MaterialTheme.typography.h6.copy(fontSize = 14.sp),
        color = MaterialTheme.colors.onSurface,
        modifier = Modifier.padding(16.dp),
    )
}
