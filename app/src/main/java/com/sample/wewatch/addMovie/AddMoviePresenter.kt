package com.sample.wewatch.addMovie

import com.sample.wewatch.model.LocalDataSource
import com.sample.wewatch.model.Movie

class AddMoviePresenter(
    private var viewInterface: AddMovieContract.ViewInterface,
    private var dataSource: LocalDataSource
) :
    AddMovieContract.PresenterInterface {
    override fun addMovie (title: String , releaseDate: String , posterPath: String ) {
        //1
        if (title.isEmpty()) {
            viewInterface.displayError ("Название фильма не может быть пустым")
        } else {
            //2
            val movie = Movie(title = title, releaseDate = releaseDate, posterPath = posterPath)
            dataSource.insert(movie)
            viewInterface.returnToMain()
        }
    }

}
