package com.cinema_package.cinema_project;

public class MovieNotFoundException extends RuntimeException{
    MovieNotFoundException(Integer id) {
        super("cannot find movie with id:" +id );
    }    
}
