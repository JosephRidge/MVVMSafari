package com.jayr.mvvmsafari.ui.screens.hobby

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HobbyScreen(
    hobbyViewModel: HobbyViewModel = viewModel(),
    modifier: Modifier
){
//     states
    val hobby = hobbyViewModel.hobby.collectAsState()
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var name by remember{ mutableStateOf(TextFieldValue("")) }

//    ui
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ){
        OutlinedTextField(
            value = name,
            onValueChange = {name =it},
            label = {Text(text ="Hobby Name")},
            maxLines = 1
        )
        OutlinedTextField(
            value = description,
            onValueChange = {description =it},
            label = {Text(text ="Hobby Desciption")},
            minLines = 3
        )

        OutlinedButton(
            onClick = {
                hobbyViewModel.createHobby(
                    name=name.text,
                    description = description.text
                    )
            }
        ) {
            Text(text="create hobby")
        }
        HorizontalDivider()
        Text(text= hobby.value.name)
        Text(text= hobby.value.description)


    }
}