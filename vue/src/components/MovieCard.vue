<template>
  <div class="card-container">
    <!-- <div class="card">
      <router-link v-bind:to="{ name: 'movie', params: { id: movie.movieId } }">
        <img :src="movie.posterPath" class="image-fit" />
      </router-link>
    </div>
    <h2 class="movie-title">{{ movie.title }} ({{ movie.releaseDate.substring(0, 4) }})</h2>
    <AddAndDeleteButtonVue v-bind:id="movie.movieId"/> -->

    <div class="card" style="width: 18rem;">
      <router-link v-bind:to="{ name: 'movie', params: { id: movie.movieId } }">
        <img class="card-img-top" :src="movie.posterPath" alt="poster-image">
        <div class="card-body">
          <h5 class="card-title">{{ movie.title }} ({{ movie.releaseDate.substring(0, 4) }})</h5>
        </div>
      </router-link>
    </div>
  </div>
</template>

<script>
// import AddAndDeleteButtonVue from './AddAndDeleteButton.vue';
// import APIService from '../services/APIService';

export default {
  name: "movieCard",
  props: { movie: Object },
  data() {
    return {
      currentMovie: {}
    }
  },
  // components: {AddAndDeleteButtonVue},
  // created() {

  //   this.currentMovie = this.movie;

  // }
}
</script>

<style>
.card-container {
  border: black 3px;
  border-width: 3px;
  width: auto;
}

div.card {
  display: flex;
  justify-content: center;
}

.movie-title {
  width: 100%;
  text-align: center;
  font-family: "Montserrat";
}

img {
  width: 20rem;
}

a{
  text-decoration: none;
  color: black;
}

.card-body{
  text-align: center;
  background-color: rgba(0, 0, 0, 0);
  height: 8rem;
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  border-top:solid;
  border-width: .1rem;
}

.card{
  margin:1rem;
  border: solid black;
  border-width: .1rem;
}
</style>