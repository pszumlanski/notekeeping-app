package com.example.cleanarchitecturenoteapp.feature_note.presentation.add_edit_note

import androidx.compose.animation.Animatable
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun AddEditNoteScreen(
    navController: NavController,
    noteColor: Int,
    viewModel: AddEditNoteViewModel = hiltViewModel()
) {
    val titleState = viewModel.noteTitle.value
    val contentState = viewModel.noteContent.value

    val scaffoldState = rememberScaffoldState()

    val noteBackgroundAnimatable = remember {
        Animatable(
            Color(if(noteColor != -1) noteColor else viewModel.noteColor.value)
        )
    }
    val scope = rememberCoroutineScope()
    
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(AddEditNoteEvent.SaveNote)
            },
            backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = "Save note")
            }
        },
        scaffoldState = scaffoldState
    ) {

    }
}