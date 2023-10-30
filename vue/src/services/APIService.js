import axios from 'axios';

export default{
    getMovies(){
        return axios.get("/movies")
    },

    getMovie(id){
        return axios.get(`/movie/${id}`)
    },

    getGenres(){
        return axios.get("/genres")
    },

    getMoviesByGenreId(id){
        return axios.get(`/genre/${id}/movies`)
    },

    getGenreById(id){
        return axios.get(`/genre/${id}`)
    },

    

}