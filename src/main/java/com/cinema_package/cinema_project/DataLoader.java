// package com.cinema_package.cinema_project;

// import javax.annotation.PostConstruct;

// import org.springframework.stereotype.Component;

// @Component
// public class DataLoader {
//     private MovieRepository movieRepository;

//     // @Autowired
//     public DataLoader(MovieRepository movieRepository) {
//         this.movieRepository = movieRepository;
//     }

//     @PostConstruct
//     public void loadData() {
//         // clear the database first
//         //movieRepository.deleteAll();

//         // load data here
//         movieRepository.save(new Movie(1, 120, 2023-01-01, "Mulan", "Christopher", "Action", "China", 18, "Mulan", 180));
//         //movieRepository.save(new Movie(2, 120, "2023-01-01", "Titanic", "Christopher", "Romance", "England", 18, "Titanic", 180));
       
//     }
// }
