package com.example.moviesearch

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.moviesearch.MoviesData.Result
public var worldTitle = ""
public var mList = listOf<Result>()
@Composable
fun HomeScreen (
    onNavigateToResultScreen: (String) ->Unit,
    movieResultViewModel:MovieResultViewModel = viewModel(),
    //val movieResultViewModel = viewModel(modelClass = MovieResultViewModel::class.java)
    //movieResultViewModel.
){
    var text by remember { mutableStateOf("") }
    Column(modifier= Modifier
        .fillMaxSize()
        .padding(8.dp)
    ,
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally)
    {
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
        Text(text = "Movie Search", fontSize = 65.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, modifier = Modifier
            .fillMaxWidth()
            )}

        //val state by movieResultViewModel.moviesS.collectAsState()
        OutlinedTextField (
            value = text,
            onValueChange = { text = it
                            worldTitle=it},
            modifier = Modifier.fillMaxWidth(),
            )

            IconButton(onClick = {//Need to send displaylist to resultscreen
                if(text!="") {
                    movieResultViewModel.getMovieList(text)
                    onNavigateToResultScreen(text)
                }
            },modifier = Modifier.size(60.dp)) {
                Icon(
                    imageVector = Icons.Outlined.ArrowForward,
                    contentDescription = "Next",
                    modifier = Modifier.fillMaxSize()
                )
            }




    }
}

