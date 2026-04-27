package com.jayr.mvvmsafari.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.jayr.mvvmsafari.data.models.StudentModel

@Composable
fun HomeScreen(
    modifier: Modifier
){
//    states
    var nameInput by remember { mutableStateOf(TextFieldValue("")) }
    var courseInput by remember { mutableStateOf(TextFieldValue("")) }
    var ageInput by remember { mutableStateOf(TextFieldValue("")) }
    var student by remember { mutableStateOf(StudentModel()) }

//     ui
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        OutlinedTextField(
            value = nameInput,
            onValueChange = {nameInput = it},
            label = { Text(text="Student name") }
        )
        OutlinedTextField(
            value = ageInput,
            onValueChange = {ageInput = it},
            label = { Text(text="Student age") }
        )
        OutlinedTextField(
            value = courseInput,
            onValueChange = {courseInput = it},
            label = { Text(text="Student course") }
        )

        OutlinedButton(
            onClick = {
                student = StudentModel(
                    name=nameInput.text,
                    age = ageInput.text.toInt(),
                    course = courseInput.text
                )
            }
        ) {
            Text(text="create student")
        }
        HorizontalDivider()

        Text(
            text = student.name
        )
        Text(
            text = student.age.toString()
        )
        Text(
            text = student.course
        )
    }
}