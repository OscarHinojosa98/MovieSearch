package com.example.moviesearch

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun MovieScreen(
    onNavigateBackToResultScreen: (String) ->Unit
){
    var hboTrue = false
    var huluTrue = false
    var appleTrue = false
    var netflixTrue = false
    var disneyTrue = false
    var primeTrue = false
    Column() {
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .weight(0.1f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center)
        {
            Text(
                text= "${chosenMovie.title} (${chosenMovie.year})",
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp


            )
        }
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .weight(0.6f)
            //verticalAlignment = Alignment.Top
                    ) {
            Image(painter= rememberAsyncImagePainter(chosenMovie.posterURLs.`780`,
                contentScale = ContentScale.Fit,
                //onLoading = CircularProgressIndicator()
                //placeholder=painterResource(R.drawable.)
                //transformations=CircleCropTransformation)
            ),
                    contentDescription = chosenMovie.overview,
                modifier = Modifier
                    .fillMaxSize()

            )

        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
        modifier=Modifier.fillMaxWidth()
            .weight(0.3f)) {
            if (chosenMovie.streamingInfo.us!=null) {
                if (chosenMovie.streamingInfo.us!!.netflix != null && netflixTrue == false) {
                    Column() {
                        Text(text = "Netflix")
                        netflixTrue = true
                        var temp = chosenMovie.streamingInfo.us!!.netflix
                        for (i in temp!!.indices) {
                            if (temp[i].leaving==0) { //only using in this if case
                                if (temp[i].type == "subscription") {
                                    Text(text = "Subs")
                                }
                                if (temp[i].type == "buy") {
                                    Text(text = "Buy: ${temp[i].price}")
                                }
                                if (temp[i].type == "rent") {
                                    Text(text = "Rent: ${temp[i].price}")
                                }
                                if (temp[i].type == "addon") {
                                    Text(text = "Addon: ${temp[i].addOn}")
                                }
                            }
                        }
                    }
                }
                if (chosenMovie.streamingInfo.us!!.hbo != null && hboTrue == false) {
                    Column() {
                        Text(text = "HBO")
                        hboTrue = true
                        var temp = chosenMovie.streamingInfo.us!!.hbo
                        for (i in temp.indices) {
                            if (temp[i].type == "subscription") {
                                Text(text = "Subs")
                            }
                            if (temp[i].type == "buy") {
                                Text(text = "Buy: ${temp[i].price}")
                            }
                            if (temp[i].type == "rent") {
                                Text(text = "Rent: ${temp[i].price}")
                            }
                            if (temp[i].type == "addon") {
                                Text(text = "Addon: ${temp[i].addOn}")
                            }
                        }
                    }
                }
                if (chosenMovie.streamingInfo.us!!.hulu != null && huluTrue == false) {
                    Column() {
                        Text(text = "Hulu")
                        huluTrue = true
                        var temp = chosenMovie.streamingInfo.us!!.hulu
                        for (i in temp.indices) {
                            if (temp[i].type == "subscription") {
                                Text(text = "Subs")
                            }
                            if (temp[i].type == "buy") {
                                Text(text = "Buy: ${temp[i].price}")
                            }
                            if (temp[i].type == "rent") {
                                Text(text = "Rent: ${temp[i].price}")
                            }
                            if (temp[i].type == "addon") {
                                Text(text = "Addon: ${temp[i].addOn}")
                            }
                        }
                    }
                }
                if (chosenMovie.streamingInfo.us!!.apple != null && appleTrue == false) {
                    Column() {
                        Text(text = "Apple")
                        appleTrue = true
                        var temp = chosenMovie.streamingInfo.us!!.apple
                        for (i in temp.indices) {
                            if (temp[i].type == "subscription") {
                                Text(text = "Subs")
                            }
                            if (temp[i].type == "buy") {
                                Text(text = "Buy: ${temp[i].price.amount}")
                            }
                            if (temp[i].type == "rent") {
                                Text(text = "Rent: ${temp[i].price.amount}")
                            }
                            //removed addon due to text issues

                        }
                    }
                }
                if (chosenMovie.streamingInfo.us!!.disney != null && disneyTrue == false) {
                    Column() {
                        Text(text = "Disney")
                        disneyTrue = true
                        var temp = chosenMovie.streamingInfo.us!!.disney
                        for (i in temp!!.indices) {
                            if (temp[i].type == "subscription") {
                                Text(text = "Subs")
                            }
                            if (temp[i].type == "buy") {
                                Text(text = "Buy: ${temp[i].price}")
                            }
                            if (temp[i].type == "rent") {
                                Text(text = "Rent: ${temp[i].price}")
                            }
                            if (temp[i].type == "addon") {
                                Text(text = "Addon: ${temp[i].addOn}")
                            }
                        }
                    }
                }
                if (chosenMovie.streamingInfo.us!!.prime != null && primeTrue == false) {
                    Column() {
                        Text(text = "Amazon")
                        disneyTrue = true
                        var temp = chosenMovie.streamingInfo.us!!.disney
                        for (i in temp!!.indices) {
                            if (temp[i].type == "subscription") {
                                Text(text = "Subs")
                            }
                            if (temp[i].type == "buy") {
                                Text(text = "Buy: ${temp[i].price}")
                            }
                            if (temp[i].type == "rent") {
                                Text(text = "Rent: ${temp[i].price}")
                            }
                            if (temp[i].type == "addon") {
                                Text(text = "Addon: ${temp[i].addOn}")
                            }
                        }
                    }
                }

            }
            else {
                Column() {
                    Text(text = "Information Not Available")
                }
            }
        }
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(8.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = {//Need to send displaylist to resultscreen
                //displayMovie=null
                onNavigateBackToResultScreen(worldTitle)
            }, modifier = Modifier.size(80.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Previous",
                    modifier = Modifier.fillMaxSize()
                )

            }
        }

    }
}