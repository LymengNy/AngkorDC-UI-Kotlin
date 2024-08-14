package com.example.finalproject.models

data class MovieModel(
    val id: Int = 0,
    val title: String = "",
    val desc: String = "",

    val image: String = "",
)

var movieList  = listOf(
    MovieModel(
        id = 1,
        title = "The Dark mother",
        desc = "Romance Comedy",

        image = "https://m.media-amazon.com/images/M/MV5BMDZhMmFiYzYtZGNjNS00N2MzLWIwNTItMzhjMjdhMmJlODJiXkEyXkFqcGdeQXVyMTU2Mjk4MDkw._V1_.jpg",
    ),
    MovieModel(
        id = 2,
        title = "The Clock Spripit Awaking ",
        desc = "Drama Horror",

        image = "https://m.media-amazon.com/images/M/MV5BZjE0ZDQ0MmMtZTAxZi00Zjk1LThjYjQtMjdmYzk3NTc4NzdhXkEyXkFqcGdeQXVyNzcxMzE5MzE@._V1_.jpg",
    ),
    MovieModel(
        id = 3,
        title = "ស្រលាញ់បង​ល្អពេក",
        desc = "Comedy Romance",

        image = "https://pbs.twimg.com/media/F6mAt2CbAAAD_K0?format=jpg&name=large",
    ),
    MovieModel(
        id = 4,
        title = "jobsoy",
        desc = "Romance Comedy",

        image = "https://admin.angkordc.com/uploads/movie/1621441797-jobsoy.jpg",
    ),
    MovieModel(
        id = 5,
        title = "2 Brother",
        desc = "Romace Comedy",

        image = "https://admin.angkordc.com/uploads/movie/1621441837-2brotherg.jpg",
    ),
    MovieModel(
        id = 6,
        title = "កំពូលអ្នកសុំទានជួបស្នេហ",
        desc = "Romace Comedy",

        image = "https://admin.angkordc.com/uploads/movie/1621442320-beggar.jpg",
    ),
    MovieModel(
        id = 7,
        title = "សំណេីចស្នេហ៍និស្សិតពេទ្យ",
        desc = "Romace Comedy",

        image = "https://admin.angkordc.com/uploads/movie/1621441651-college%20student.jpg",
    ),
    MovieModel(
        id = 8,
        title = "ហ្វូតូកូពី",
        desc = "Horror",

        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSk68JRKVGs2gFa1EDc5sGdq_uvMpe9Cbss-OK73YZlBw&s",
    ),
    MovieModel(
        id = 9,
        title = "ខ្សែចងក",
        desc = "Horror Comedy",

        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPeXS90FgIcfNEQqosY7NFph2srI9_vMusGQ95icJhqw&s",
    ),
    MovieModel(
        id = 10,
        title = "លោកគ្រូប្រពន្ធល្អ",
        desc = "Romace Comedy",

        image = "https://admin.angkordc.com/uploads/movie/1660190735-Single%20Dad%20poster%20coming%20soon%20size%20900x700.jpg",
    ),
    MovieModel(
        id = 11,
        title = "សាកសព7 ថ្ងៃ",
        desc = "Horror",

        image = "https://admin.angkordc.com/uploads/movie/1662083449-coming%20soon%20website%20900x700%20final.jpg  ",
    ),
    MovieModel(
        id = 12,
        title = "ឪកាសស្នេហ៍គេដូចមុន",
        desc = "Romace Drama",

        image = "https://admin.angkordc.com/uploads/movie/1621420574-3.jpg",
    ),
    MovieModel(
        id = 13,
        title = "លោកគ្រូប្រពន្ធល្អ",
        desc = "Romace Comedy",

        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDoGwYAFHSw1h0PIo1pB56qmZ6-Zzr34VZDaG_yN99iDFrwxYHgJouGQjJk0-DRUCxv7k&usqp=CAU"),
    MovieModel(
        id = 14,
        title = "សាកសព7 ថ្ងៃ",
        desc = "Horror",

        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaiyAxqdCNg0GmEXX7-zYJUNyPbfDdwGQESse9p2jPNc7XuI6iDIZwKE4J2kL19Q7INjg&usqp=CAU ",
    ),
    MovieModel(
        id = 15,
        title = "ឪកាសស្នេហ៍គេដូចមុន",
        desc = "Romace Drama",

        image = "https://admin.angkordc.com/uploads/movie/1621420574-3.jpg",
    ),
    MovieModel(
        id = 16,
        title = "Dark mother",
        desc = "Romance Comedy",

        image = "https://m.media-amazon.com/images/M/MV5BMDZhMmFiYzYtZGNjNS00N2MzLWIwNTItMzhjMjdhMmJlODJiXkEyXkFqcGdeQXVyMTU2Mjk4MDkw._V1_.jpg",
    ),
    MovieModel(
        id = 17,
        title = "The Clock Spripit Awaking ",
        desc = "Drama Horror",

        image = "https://m.media-amazon.com/images/M/MV5BZjE0ZDQ0MmMtZTAxZi00Zjk1LThjYjQtMjdmYzk3NTc4NzdhXkEyXkFqcGdeQXVyNzcxMzE5MzE@._V1_.jpg",
    ),
    MovieModel(
        id = 18,
        title = "ស្រលាញ់បង​ល្អពេក",
        desc = "Comedy Romance",

        image = "https://pbs.twimg.com/media/F6mAt2CbAAAD_K0?format=jpg&name=large",
    ),
    MovieModel(
        id = 19,
        title = "jobsoy",
        desc = "Romance Comedy",

        image = "https://admin.angkordc.com/uploads/movie/1621441797-jobsoy.jpg",
    ),
    MovieModel(
        id = 20,
        title = "2 Brother",
        desc = "Romace Comedy",

        image = "https://admin.angkordc.com/uploads/movie/1621441837-2brotherg.jpg",
    ),
    MovieModel(
        id = 21,
        title = "កំពូលអ្នកសុំទានជួបស្នេហ",
        desc = "Romace Comedy",

        image = "https://admin.angkordc.com/uploads/movie/1621442320-beggar.jpg",
    ),
    MovieModel(
        id = 22,
        title = "សំណេីចស្នេហ៍និស្សិតពេទ្យ",
        desc = "Romace Comedy",

        image = "https://admin.angkordc.com/uploads/movie/1621441651-college%20student.jpg",
    ),
    MovieModel(
        id = 23,
        title = "ហ្វូតូកូពី",
        desc = "Horror",

        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSk68JRKVGs2gFa1EDc5sGdq_uvMpe9Cbss-OK73YZlBw&s",
    ),
    MovieModel(
        id = 24,
        title = "ខ្សែចងក",
        desc = "Horror Comedy",

        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPeXS90FgIcfNEQqosY7NFph2srI9_vMusGQ95icJhqw&s",
    ),
    MovieModel(
        id = 25,
        title = "លោកគ្រូប្រពន្ធល្អ",
        desc = "Romace Comedy",

        image = "https://admin.angkordc.com/uploads/movie/1660190735-Single%20Dad%20poster%20coming%20soon%20size%20900x700.jpg",
    ),
    MovieModel(
        id = 26,
        title = "សាកសព7 ថ្ងៃ",
        desc = "Horror",

        image = "https://admin.angkordc.com/uploads/movie/1662083449-coming%20soon%20website%20900x700%20final.jpg  ",
    ),
    MovieModel(
        id = 27,
        title = "ឪកាសស្នេហ៍គេដូចមុន",
        desc = "Romace Drama",

        image = "https://admin.angkordc.com/uploads/movie/1621420574-3.jpg",
    ),
    MovieModel(
        id = 28,
        title = "លោកគ្រូប្រពន្ធល្អ",
        desc = "Romace Comedy",

        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDoGwYAFHSw1h0PIo1pB56qmZ6-Zzr34VZDaG_yN99iDFrwxYHgJouGQjJk0-DRUCxv7k&usqp=CAU"),
    MovieModel(
        id = 29,
        title = "សាកសព7 ថ្ងៃ",
        desc = "Horror",

        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaiyAxqdCNg0GmEXX7-zYJUNyPbfDdwGQESse9p2jPNc7XuI6iDIZwKE4J2kL19Q7INjg&usqp=CAU ",
    ),
    MovieModel(
        id = 30,
        title = "ឪកាសស្នេហ៍គេដូចមុន",
        desc = "Romace Drama",

        image = "https://admin.angkordc.com/uploads/movie/1621420574-3.jpg",
    ),

)
