<template>
  <div class="card-container">
    <div class="card">
      <router-link v-bind:to="{ name: 'movie', params: { id: movie.movieId } }">
        <img :src="movie.posterPath" class="image-fit" />
      </router-link>
    </div>
    <h2 class="movie-title">{{ movie.title }} ({{ movie.releaseDate.substring(0, 4) }})</h2>
    <div>
    <button v-on:click="isOnWatchList  ? deleteMovieFromWatchList() : addMovieToWatchList()">
    {{ isOnWatchList ? "Delete From WatchList":"Add to Watchlist"}}</button>
  </div>
  </div>
</template>

<script>
// import AddAndDeleteButtonVue from './AddAndDeleteButton.vue';
import APIService from '../services/APIService';

export default {
  name: "movieCard",
  props: { movie: Object },
  data() {
    return {
      currentMovie: {}
    }
  },
  // components: {AddAndDeleteButtonVue},
  methods: {
    addMovieToWatchList() {
      APIService.addToWishlist(this.movie.movieId).then(
        window.alert("Movie added to watchlist")
      )
    },

    deleteMovieFromWatchList() {
      APIService.deleteFromWishlist(this.movie.movieId).then(
        window.alert("Movie deleted from list")
      )
    }
  },
  computed: {
    isOnWatchList() {
      let movieIndex = 0;
      for (let i = 0; i < this.$store.state.movies.length; i++) {
        if (this.$store.state.movies[i].movieId == this.movie.movieId) {
          movieIndex = i;
        }
      }
      for (let i = 0; i < this.$store.state.watchList.length; i++) {
        if (this.$store.state.movies[movieIndex].movieId == this.$store.state.watchList[i].movieId) {
          return true;
        }
      }
      return false;
    }
  },
  // created() {

  //   this.currentMovie = this.movie;

  // }
}
</script>

<style>
.card-container {
  border: black 3px;
  border-width: 3px;
  width: 30rem;
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
</style>