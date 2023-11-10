<template>
  <div>
    <h1>Watch List</h1>
    <MovieCard v-for="movie in $store.state.watchList"
        v-bind:key = "movie.id"
        v-bind:movie = "movie"/>
  </div>

</template>

<script>
import APIService from '../services/APIService.js';
import MovieCard from '../components/MovieCard.vue'
export default {
    components:{MovieCard},
    created(){
    APIService.getWishList().then(response=>{
      this.$store.commit('SET_WATCH_LIST', response.data)
    })
    }

}
</script>

<style>

</style>