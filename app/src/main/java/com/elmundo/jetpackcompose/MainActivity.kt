package com.elmundo.jetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import com.elmundo.jetpackcompose.ui.theme.JetPackComposeTheme
import kotlin.math.exp

//Lista de mensajes
private val messages: List<MyMessage> = listOf(
    MyMessage("Hola Roberto", "¿Listo para ir el gran viaje? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus. "),
    MyMessage("Hola Rey", "¿Listo para ir de shop? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus." ),
    MyMessage("Hola Asiw", "¿Listo para ir de shop? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus."),
    MyMessage("Hola Saber", "¿Listo para ir de shop? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus."),
    MyMessage("Hola Israel", "¿Listo para ir de shop? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus."),
    MyMessage("Hola Tony", "¿Listo para ir de shop? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus."),
    MyMessage("Hola Sharon", "¿Listo para ir de shop? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus."),
    MyMessage("Hola Henry", "¿Listo para ir de shop? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus."),
    MyMessage("Hola Jasón", "¿Listo para ir de shop? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus."),
    MyMessage("Hola Connor", "¿Listo para ir de shop? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus."),
    MyMessage("Hola Fred", "¿Listo para ir de shop? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus."),
    MyMessage("Hola Cloe", "¿Listo para ir de shop? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris facilisis, ipsum mattis hendrerit dictum, neque eros tempus lorem, at lacinia tellus orci et metus."),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme {
                //Aqui se ejecuta y el que ejecuta son los mensajes precargados del privat val
                MyMessages(messages)
            }
        }
    }
}

//El tipo de dato para poder enlistarlo
data class MyMessage(val title: String, val body: String)

//Esta clase es la que dará mensajes. messages será otorgado a items para cargar el listado, generando los elementos en pantalla y eliminando los que no.
@Composable
fun MyMessages(messages: List<MyMessage>) {
    LazyColumn {
        items(messages) { message ->
            MyComponent(message)
        }
    }
}

//El message de tipo MyMessage está hecho para recibir después en el metodo MyMessages los mensajes en el Lazy Colum, los items son recibidos del listado y cada item, message es asignado a cada MyComponent
@Composable
fun MyComponent(message: MyMessage) {
    //  modifier= Modifier.padding(top = 8.dp)
    //El orden de las cosas, primero se aplica el fondo y luego el padding
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
    ) {
        MyImage()
        myTexts(message)
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

//El MyMessage es un tipo de dato y se les otorgado porque de él se le pondrá a los demás elementos
@Composable
fun myTexts(message: MyMessage) {
    //esta variable debe ser recordado, osea, que funciona guardando el valor de la var
    var expanded by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier
        .padding(start = 8.dp)
        .clickable {
            expanded = !expanded
        }) {
        MyText(
            message.title,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1,

        )
        Spacer(modifier = Modifier.height(16.dp))

        MyText(
            message.body,
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2,
            //Aqui
            if(expanded) Int.MAX_VALUE else 1


        )
        /*
        MyText(
            "Iniciando el gran viaje",
            MaterialTheme.colors.primaryVariant,
            MaterialTheme.typography.body1
        )
        MyText(
            "Será largo",
            MaterialTheme.colors.primaryVariant,
            MaterialTheme.typography.body2
        )*/
    }

}
//Digamos que es una plantilla para un mensaje
//Añade el lines Int.MAX VALUE
@Composable
fun MyText(text: String, color: Color, style: androidx.compose.ui.text.TextStyle, lines:Int=Int.MAX_VALUE) {
    Text(text, color = color, style = style, maxLines = lines)
}

//@Preview()
@Preview(showSystemUi = true) //Para visualizar como si fuese telefono
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent() {
    JetPackComposeTheme {
        MyMessages(messages) //Ejecuta el metodo para visualizar

        //Añadir scroll al componente
        /*val scrollState= rememberScrollState()
        Column(modifier= Modifier.verticalScroll(scrollState)) {
            MyMessages(messages)
        }*/

    }

}

