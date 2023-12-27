<template>
  <div>
    <h1>Watch List</h1>
    <div class="movies">
      <MovieCard v-for="movie in $store.state.watchList"
        v-bind:key = "movie.id"
        v-bind:movie = "movie"/>
    </div>
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
h1{
  color: #fff;
  margin-top: 1rem;
}


</style>