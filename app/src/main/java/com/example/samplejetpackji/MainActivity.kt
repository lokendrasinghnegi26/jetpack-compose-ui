package com.example.samplejetpackji

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplejetpackji.navigation.MainNavigation
import com.example.samplejetpackji.ui.theme.SampleJetpackJiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SampleJetpackJiTheme {
                val name = remember { mutableStateOf("") }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainNavigation()
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun TextInput(
    text: String,
    label: String,
    onChange: (String) -> Unit
) {
    TextField(

        value = text, onValueChange = {
            onChange(it)
        }, Modifier.padding(20.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent
        ),
        placeholder = { Text(text = label) }
    , maxLines = 1,
    )
}

@Composable
fun ButtonField(text: String, onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text(text = text)
    }
}

@Composable
fun TextField(text: String){
    Text(text = "user name $text")


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    var username by remember { mutableStateOf("") }

    SampleJetpackJiTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
            Greeting("Android")
//            TextInput(text = username, onChange = {
//                username = it
//            })

        }
    }
}

