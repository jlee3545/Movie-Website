<template>
<div id = "movies">
  <MovieCard v-for="movie in $store.state.movies"
        v-bind:key = "movie.id"
        v-bind:movie = "movie"
        id = "movieCard"/>
        </div>
</template>

<script>
import MovieCard from "../components/MovieCard.vue"
import APIService from '../services/APIService'
export default {
    components:{MovieCard},
    created(){
    APIService.getMoviesByPersonId(this.$route.params.id).then(response=>{
      this.$store.commit('SET_MOVIES', response.data)
    })
    }


}
</script>

<style scoped>
  #movies{
    display: inline-flex;
    justify-content:space-around;
    flex-wrap: wrap;
    border: black;
    border-width: 3px;
  }

  #movieCard{
    width: 15rem;

  }

  #movieCard img{
    width: 10rem;
  }
</style>