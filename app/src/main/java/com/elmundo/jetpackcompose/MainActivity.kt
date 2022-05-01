package com.elmundo.jetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elmundo.jetpackcompose.ui.theme.JetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme {
                MyComponent()
            }

        }
    }
}

@Composable
fun MyComponent() {
    //  modifier= Modifier.padding(top = 8.dp)
    //El orden de las cosas, primero se aplica el fondo y luego el padding
    Row(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(8.dp)) {
        MyImage()
        myTexts()
    }
}

@Composable
fun MyImage() {
    Image(
        painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Mi imagen de prueba",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
            .size(64.dp)
        //el clip(CircleShape debe ser primero antes de backgroun o cualquier otra cosa
        //shape y background no importa su orden
    )
}

@Composable
fun myTexts() {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText(
            "Hola Alvey",
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(16.dp))

        MyText(
            "¿Preparado?",
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2
        )
        MyText(
            "Iniciando el gran viaje",
            MaterialTheme.colors.primaryVariant,
            MaterialTheme.typography.body1)
        MyText(
            "Será largo",
            MaterialTheme.colors.primaryVariant,
            MaterialTheme.typography.body2
        )
    }

}

@Composable
fun MyText(text: String, color: Color, style: androidx.compose.ui.text.TextStyle) {
    Text(text, color = color, style = style)
}
@Preview()
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent() {
    JetPackComposeTheme {
        MyComponent()
    }

}

