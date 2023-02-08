package com.example.restapplication.ui.screens


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.restapplication.model.User


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun homeScreen(users: List<User>?){

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Top App Bar")
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 10.dp
            )
        }, content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (users != null) {
                    for (item in users) {
                        Text(text = "Nome: " + item.name)
                        Text(text = "Email: " + item.email)
                        Text(text = "Gender: " + item.gender)
                        Text(text = "Status: " + item.status)
                        Spacer(modifier = Modifier.height(5.dp))
                    }
                }
            }
        })
}
