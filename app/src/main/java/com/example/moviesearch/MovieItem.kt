package com.example.moviesearch

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.base.R
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.moviesearch.MoviesData.Result
//public var selectedMovie : String = ""
public lateinit var displayMovie : Result
@Composable
fun MovieItem(resultMovie:Result /*, selectedItem: (Result) -> Unit,index: MutableState<Int>*/){
    val selectedMovie = remember{ mutableStateOf("") }
    Card(modifier = Modifier
        .padding(8.dp, 4.dp)
        .fillMaxWidth()
        .height(110.dp)
        .selectable(
                selected = selectedMovie.value == resultMovie.overview,
            onClick = {
                displayMovie=resultMovie
                    //selectedMovie = resultMovie.overview
                //selectedMovie = selectedItem
                selectedMovie.value =
                if (selectedMovie.value != resultMovie.overview) {
                    resultMovie.overview
                    } else {
                        ""
                    }
            }

        ),
        backgroundColor =
        if (selectedMovie.value == resultMovie.overview)
            MaterialTheme.colors.secondary
        else
            Color.White,
        shape = RoundedCornerShape(8.dp), elevation = 4.dp
            )
    {
     Row(modifier = Modifier
         .padding(4.dp)
         .fillMaxSize()) {
         Image(painter= rememberAsyncImagePainter(resultMovie.posterURLs.`780`,
             contentScale = ContentScale.Fit,
             //onLoading = CircularProgressIndicator()
             //placeholder=painterResource(R.drawable.)
             //transformations=CircleCropTransformation)
             ),
         contentDescription = resultMovie.overview,
         modifier = Modifier
             .fillMaxHeight()
             .weight(0.2f)
         )
         Column(modifier=Modifier
             .padding(4.dp)
             .fillMaxHeight()
             .weight(0.8f)) {
             Text(
                 text= "${resultMovie.title} (${resultMovie.year})",
                 style = MaterialTheme.typography.subtitle1,
                 fontWeight = FontWeight.Bold
             )
             Text(
                 text= resultMovie.overview,
                 style = MaterialTheme.typography.body1,
                 maxLines = 2,
                 overflow = TextOverflow.Ellipsis
             )



         }

     }
    }
}