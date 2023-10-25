<template>
<div id = "movies">
  <MovieCard v-for="movie in $store.state.movies"
        v-bind:key = "movie.id"
        v-bind:movie = "movie"/>
        </div>
</template>

<script>
import MovieCard from "../components/MovieCard.vue"
export default {
    components:{MovieCard}

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
</style>