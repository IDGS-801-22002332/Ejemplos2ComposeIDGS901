package org.utl.ejemplo2composeidgs901

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.utl.ejemplo2composeidgs901.ui.theme.Ejemplo2ComposeIDGS901Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
        SumaDosNumeros()
            //val navController = rememberNavController()
            //NavHost(navController = navController, startDestination = "inicio"){
                //composable("inicio"){PantallaInicio(navController)}
                //("detalle/{nombre}"){backStackEntry ->
                    //val nombre = backStackEntry.arguments?.getString("nombre") ?: "Invitado"
                    //PantallaDetalle(navController, nombre)
                //}
            //}
        }
    }
}

@Composable
fun PantallaInicio(navController: NavController){
    var nombre by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Pantalla de inicio")
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = {Text("Ingrese su nombre")},

            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
                val nombre = nombre.ifBlank { "Jesus" }
                navController.navigate("detalle/$nombre")
            }
        ) {
            Text("Ir a detalle con nombre")
        }
    }
}


@Composable
fun PantallaDetalle(navController: NavController, nombre:String){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Hola, $nombre")
        Button(onClick = { navController.navigate("inicio") }) {
            Text("Volver a inicio")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ejemplo2ComposeIDGS901Theme {
        Greeting("Android")
    }
}