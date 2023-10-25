
<template>
    <div>
    <div id = "movies">
        <movie-card v-for="movie in $store.state.movies"
        v-bind:key = "movie.id"
        v-bind:movie = "movie"/>
    </div>
    </div>
</template>

<script>
import MovieCard from '../components/MovieCard.vue';
import APIService from '../services/APIService.js';

export default {
    components:{MovieCard},
    created(){
    APIService.getMovies().then(response=>{
      this.$store.commit('SET_MOVIES', response.data)
    })
    }

}
</script>

<style>

  #movies{
    display: inline-flex;
    justify-content:space-around;
    flex-wrap: wrap;
    border: black;
    border-width: 3px;
  }


</style>