package pe.idat.nuevoproyecto


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Login(navController: NavHostController) {
    var ec1 by rememberSaveable { mutableStateOf("") }
    var ec2 by rememberSaveable { mutableStateOf("") }
    var selectedSexo by rememberSaveable { mutableStateOf("Hombre") }
    var deporteChecked by rememberSaveable { mutableStateOf(false) }
    var pinturaChecked by rememberSaveable { mutableStateOf(false) }
    var otroChecked by rememberSaveable { mutableStateOf(false) }
    var showBooks by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Información",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                style = TextStyle(
                    fontSize = 30.sp,
                    color = Color.Black
                )
            )

            OutlinedTextField(
                value = ec1,
                onValueChange = { ec1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("DNI", color = Color.Black) },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            OutlinedTextField(
                value = ec1,
                onValueChange = { ec1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Nombre", color = Color.Black) },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            OutlinedTextField(
                value = ec1,
                onValueChange = { ec1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Apellidos", color = Color.Black) },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            MySpace(16)

            OutlinedTextField(
                value = ec2,
                onValueChange = { ec2 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Email", color = Color.Black) },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            OutlinedTextField(
                value = ec1,
                onValueChange = { ec1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Contraseña", color = Color.Black) },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            MySpace(16)

            Text(text = "Sexo", fontSize = 20.sp, color = Color.Black)
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedSexo == "Hombre",
                    onClick = { selectedSexo = "Hombre" }
                )
                Text(text = "Hombre")
                Spacer(modifier = Modifier.width(16.dp))
                RadioButton(
                    selected = selectedSexo == "Mujer",
                    onClick = { selectedSexo = "Mujer" }
                )
                Text(text = "Mujer")
            }

            MySpace(16)

            Text(text = "Hobbies", fontSize = 20.sp, color = Color.Black)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = deporteChecked,
                    onCheckedChange = { deporteChecked = it }
                )
                Text(text = "Deporte")
                Spacer(modifier = Modifier.width(16.dp))
                Checkbox(
                    checked = pinturaChecked,
                    onCheckedChange = { pinturaChecked = it }
                )
                Text(text = "Pintura")
                Spacer(modifier = Modifier.width(16.dp))
                Checkbox(
                    checked = otroChecked,
                    onCheckedChange = {
                        otroChecked = it
                        showBooks = it
                    }
                )
                Text(text = "Otro")
            }

            MySpace(16)

            Button(
                onClick = {
                    // Toggle books visibility
                    showBooks = !showBooks
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "Check")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Acceder")
            }

            if (showBooks) {
                BookList()
            }
        }
    }
}


@Composable
fun MySpace(espacio: Int) {
    Spacer(modifier = Modifier.size(espacio.dp))
}
@Composable
fun BookList() {
    val books = listOf(
        Book("Medicina Interna de Harrison", "Un libro de referencia en medicina interna.", "01/01/2018"),
        Book("Principios de Medicina Interna", "Fundamentos y principios de la medicina.", "12/05/2019"),
        Book("Tratado de Cardiología", "Un estudio profundo sobre cardiología.", "23/08/2020"),
        Book("Manual Merck de Diagnóstico y Terapia", "Guía completa para el diagnóstico y tratamiento.", "17/11/2021"),
        Book("Atlas de Anatomía Humana", "Ilustraciones detalladas del cuerpo humano.", "29/02/2016"),
        Book("Pediatría de Nelson", "Referencias y guías en pediatría.", "14/07/2017"),
        Book("Neurología Clínica", "Estudios y avances en neurología.", "08/10/2015"),
        Book("Medicina de Urgencias", "Protocolo y tratamiento en urgencias.", "05/03/2014"),
        Book("Oncología Clínica", "Tratamientos y estudios sobre el cáncer.", "19/06/2013"),
        Book("Dermatología Fitzpatrick", "Guía completa sobre enfermedades de la piel.", "27/09/2012")
    )

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(books) { book ->
            BookCard(book)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun BookCard(book: Book) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = book.title,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = book.description)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Fecha de publicación: ${book.publishDate}",
                style = TextStyle(color = Color.Gray)
            )
        }
    }
}

data class Book(val title: String, val description: String, val publishDate: String)

