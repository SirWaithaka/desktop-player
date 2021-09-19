package view.player

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun ImageScreen() {
    Image(
        imageFromResource("adele.jpeg"),
        contentDescription = "image",
        modifier = Modifier.size(75.dp).padding(8.dp),
        contentScale = ContentScale.Crop
    )
}
