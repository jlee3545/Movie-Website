<template>
  <div>
    <h1>Showing All {{$store.state.genre.name}} Movies</h1>
    <MovieCard/>
  </div>
</template>

<script>
import APIService from '../services/APIService.js';
import MovieCard from '../components/MovieByGenreList.vue'
export default {
    components:{MovieCard},
    created(){
    APIService.getMoviesByGenreId(this.$route.params.id).then((response) => {
      this.$store.commit("SET_MOVIES", response.data);
    })
    APIService.getGenreById(this.$route.params.id).then((response) => {
      this.$store.commit("SET_GENRE", response.data);
    })
}
}
</script>

<style>

</style>