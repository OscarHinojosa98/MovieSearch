package com.example.moviesearch

import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesearch.MoviesData.Movies
import com.example.moviesearch.MoviesData.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieResultViewModel: ViewModel(){
    val moviesS : MutableState<List<Result>> = mutableStateOf(listOf())
    var mIt =mutableListOf<Result>()
    //val moviesS : StateFlow<List<Result>> = _moviesS
    //get() = _moviesS

    init {
        getMovieList(worldTitle)
    }


    //var movieListResponse:List<Result> by mutableStateOf(listOf())
    //var errorMessage:String by mutableStateOf("")
    //var mIt =mutableListOf<Result>()


    //add "title" and "showtype" parameters to use for input in result screen
    fun getMovieList(titleInput:String)/*:List<Result>*/{
        viewModelScope.launch {
            val retService = RetrofitInstance
                .getRetrofitInstance()
                .create(MovieService::class.java)
            //try {
                val movieList = retService.getSearchResults(titleInput,"us","movie","en").body()!!.result//.listIterator()

                for (i in movieList) {
                    mIt.add(i)

                }

                moviesS.value = mIt


                //if (movieList != null) {
                //movieListResponse=mIt

                //}
            //}
            //catch (e:Exception){
            //    errorMessage = e.message.toString()
            //}

        }
        //return movieListResponse
    }
}

class MovieResultState {

}

