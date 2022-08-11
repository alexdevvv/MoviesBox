package com.example.moviesbox.presentation
import android.util.Log
import androidx.lifecycle.LiveData
import io.reactivex.disposables.CompositeDisposable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesbox.data.MovieRepositoryImpl
import com.example.moviesbox.data.Retrofit.RetrofitHelper
import com.example.moviesbox.data.model.Genre
import com.example.moviesbox.data.model.TopMovie
import com.example.moviesbox.domain.GetGenresUseCase
import com.example.moviesbox.domain.GetTopMoviesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
//import io.reactivex.android.schedulers.AndroidSchedulers

class HomeMoviesViewModel : ViewModel() {
    private val api = RetrofitHelper.apiService
    private val repository = MovieRepositoryImpl(api)
    private val getGenresUseCase = GetGenresUseCase(repository)
    private val getTopMoviesUseCase = GetTopMoviesUseCase(repository)
    private val genresLiveData = MutableLiveData<List<Genre>>()
    private val topMoviesLiveData = MutableLiveData<List<TopMovie>>()
    private var disposable = CompositeDisposable()

    fun getGenresLiveData(): LiveData<List<Genre>> {
        return genresLiveData
    }

    fun getTopMovieLivedata(): LiveData<List<TopMovie>>{
        return topMoviesLiveData
    }



    fun getGenreResponse(){
        disposable.add(
            getGenresUseCase.getGenres()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ genres ->
                    Log.e("XXX", genres.genres.toString())
                }
                ){
                    Log.e("XXX", it.message.toString())
                })

    }

    fun getTopMovies(){
        disposable.add(
            getTopMoviesUseCase.getTopMovie()
                .subscribeOn(Schedulers.io())
                .map { it.results }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    topMoviesLiveData.postValue(it)
                }){
                    Log.e("XXX", it.message.toString())
                }
        )
    }

}