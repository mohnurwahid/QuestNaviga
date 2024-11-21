package com.example.simpleviewmodel.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormMahasiswaView(
    modifier: Modifier = Modifier,
    listGender: List<String>,
    onSubmitClick: (MutableList<String>) -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noTelpon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var memilihJK by remember { mutableStateOf("") }

    val listData : MutableList<String> = mutableListOf(
        nama, memilihJK, alamat, email, noTelpon
    )

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment =  Alignment.CenterHorizontally
    ){
        Text("Biodata",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier.padding(16.dp))

        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = { Text("nama")},
            placeholder = { Text("Masukkan Nama Anda")}
        )

        Row {
            listGender.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically ) { RadioButton(
                    selected = memilihJK == item,
                    onClick = {
                        memilihJK = item
                    }
                )
                    Text(item)

                }
            }
        }

        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = { Text("email")},
            placeholder = { Text("Masukkan email Anda")}
        )

        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = noTelpon,
            onValueChange = {noTelpon = it},
            label = { Text("NoTelpon")},
            placeholder = { Text("Masukkan NoTelpon Anda")}
        )

        TextField(
            modifier = Modifier .fillMaxWidth() .padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text("alamat")},
            placeholder = { Text("Masukkan alamat Anda")}
        )

        Button (onClick = {
            onSubmitClick(listData)
        }) {
            Text("Submit")
        }
    }
}