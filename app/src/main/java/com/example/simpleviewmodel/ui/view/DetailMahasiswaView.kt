package com.example.simpleviewmodel.ui.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simpleviewmodel.model.Mahasiswa

@Composable
fun DetailMahasiswaView(
    dataMhs: Mahasiswa,
    modifier: Modifier,
    onClickButton: () -> Boolean
){
    val listDataMhs = listOf(
        Pair("Nama", dataMhs.nama),
        Pair("Gender", dataMhs.gender),
        Pair("Alamat", dataMhs.alamat),
        Pair("Email", dataMhs.email),
        Pair("NoTelpon", dataMhs.nohp)
    )

    Column(
        modifier =  modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        listDataMhs.forEach { data ->
            DetailMhs(judul = data.first,
                Isi = data.second)
        }
        Button(onClick = {onClickButton() }) {
            Text(text = "Kembali")
        }
    }
}

@Composable
fun DetailMhs(
    judul: String, Isi : String
){
    Column (
        modifier = Modifier.fillMaxWidth().padding(10.dp),
    ){
        Row(

        ) {
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = Isi,
                modifier = Modifier.weight(2f))
        }

    }

}