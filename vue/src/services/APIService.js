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

    getAllPeople(){
        return axios.get("/people")
    },

    getMoviesByPersonId(id){
        return axios.get(`/person/${id}/movies`)
    },

    getPersonById(id){
        return axios.get(`/person/${id}`)
    },

    getActorsByMovieId(id){
        return axios.get(`/movies/${id}/actors`)
    }

}