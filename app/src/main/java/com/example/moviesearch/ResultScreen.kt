package com.example.moviesearch

import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.base.R
import coil.compose.rememberAsyncImagePainter
import com.example.moviesearch.MoviesData.ChosenMovie
import com.example.moviesearch.MoviesData.Result
import kotlin.coroutines.coroutineContext
public lateinit var chosenMovie:Result
@Composable
fun ResultScreen(
    onNavigateToMovieScreen: () ->Unit,
    onNavigateToHomeScreen: () ->Unit,
    modifier: Modifier = Modifier,
    textToDisplay:String = "",//,
    movieResultViewModel:MovieResultViewModel = viewModel()
){/*
    val state =  movieResultViewModel.moviesS.value
    Card(modifier = Modifier
        .padding(8.dp, 4.dp)
        .fillMaxWidth()
        .height(110.dp),
        shape = RoundedCornerShape(8.dp), elevation = 4.dp)
    {
        Row(modifier = Modifier
            .padding(4.dp)
            .fillMaxSize()) {
            Image(painter= rememberAsyncImagePainter(
                state[0].posterURLs.original,
                contentScale = ContentScale.Fit,
                placeholder= painterResource(id = R.drawable.notification_action_background)
                //transformations=CircleCropTransformation)
            ),
                contentDescription = mList[0].overview,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.2f)
            )
            Column(modifier=Modifier
                .padding(4.dp)
                .fillMaxHeight()
                .weight(0.8f)) {
                Text(
                    text= "${state[0].title} (${state[0].year})",
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text= state[0].overview,
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )



            }

        }
    }
*/

    val state = movieResultViewModel.moviesS.value
  Column(modifier = Modifier.fillMaxSize()) {
      var locContext = LocalContext.current

      //var displayList = movieResultViewModel.getMovieList(textToDisplay)
      //MovieList(movieList = displayList)
      Row(modifier = Modifier.weight(0.9f)) {
          MovieList(movieList = state)
      }
      Row(verticalAlignment = Alignment.Bottom,
      horizontalArrangement = Arrangement.SpaceEvenly,
      modifier = Modifier
          .fillMaxWidth()
          .weight(0.1f)){
          IconButton(onClick = {
              onNavigateToHomeScreen()
          }
              ,modifier = Modifier.size(60.dp)
          ) {
              Icon(
                  imageVector = Icons.Outlined.ArrowBack,
                  contentDescription = "Previous",
                  modifier = Modifier.fillMaxSize()
              )
          }
          IconButton(onClick = {//Need to send displaylist to resultscreen
              //val toast = Toast.makeText(locContext,state[0].title,Toast.LENGTH_SHORT)

              chosenMovie = displayMovie
              //toast.show()
              onNavigateToMovieScreen()
              }
          ,modifier = Modifier.size(60.dp)
                  ) {
              Icon(
                  imageVector = Icons.Outlined.ArrowForward,
                  contentDescription = "Next",
                  modifier = Modifier.fillMaxSize()
              )
          }
  }}

  /*  
  Column(){
      Text(
          text = textToDisplay,
          fontWeight = FontWeight.Bold,
          fontSize = 50.sp,
          color = Color.Gray

      )
  }*/
}
@Composable
fun MovieList(movieList: List<Result>){
    LazyColumn{
        itemsIndexed(items=movieList){index, item ->
            MovieItem(resultMovie = item)


        }

    }
}
