<template>
  <div>
    <div id="movie-container">
      <div id="poster"><img :src="$store.state.movie.posterPath" class="image-fit" /></div>
      <div id="movie-info">
        <div id="button-and-title">
          <div>
            <h1 id="movie-title">{{ $store.state.movie.title }}</h1>
          </div>
          <div id="button-container">
            <button v-on:click="addMovieToWatchlist" v-if="!isOnWatchList()" class="btn btn-success">Add to Watch
              List</button>
            <button v-on:click="deleteMovieFromWatchList" v-if="isOnWatchList()" class="btn btn-danger">Delete From Watch List</button>
          </div>
        </div>
        <p><b>Release Date: </b> {{ $store.state.movie.releaseDate }}</p>
        <p><b>Movie Length: </b>{{ $store.state.movie.length }} minutes</p>
        <p><b>Directed By: </b>Christopher Nolan</p>
        <p><b>Description:</b></p>
        <p>{{ $store.state.movie.overview }}</p>
      </div>
    </div>

    <!-- <add-and-delete-button-vue/> -->


  </div>
</template>

<script>
import APIService from '../services/APIService';
// import AddAndDeleteButtonVue from './AddAndDeleteButton.vue';

export default {
  props: { movie: Object },
  // components: {AddAndDeleteButtonVue},
  data() {
    return {
      onList: false
    }
  },
  methods: {
    isOnWatchList() {
      for (let i = 0; i < this.$store.state.watchList.length; i++) {
        if (this.$store.state.movie.movieId == this.$store.state.watchList[i].movieId) {
          return true;
        }
      }
      return false;
    },
    addMovieToWatchlist() {
      APIService.addToWishlist(this.$route.params.id).then(
        window.alert("Movie added to watchlist")
      )
    },

    deleteMovieFromWatchList() {
      APIService.deleteFromWishlist(this.$route.params.id).then(
        window.alert("Movie deleted from list")
      )
    }
  },
  created() {
    APIService.getWishList().then(response => {
      this.$store.commit('SET_WATCH_LIST', response.data)
    })
  }
}
</script>

<style scoped>
p {
  font-size: 1rem;
  font-family: "Montserrat"
}

#movie-container {
  display: flex;
  margin: 4rem;
  margin-top: 1rem;
  border: solid;
  border-color: black;
  background-color: aliceblue;
  align-content: center;
}

#movie-info {
  padding: 2rem;
}

#movie-title {
  color: black;
  padding: 0px;
  font-size: 2rem;
}

#poster img {
  height: 100%;
  padding: 0px;
}


#button-and-title {
  display: flex;
  justify-content: space-between;
  margin: 0px;
  padding: 0px;
  align-content: center;
}

@media screen and (max-width: 500px) {
  #movie-container {
    flex-wrap: wrap;
  }
}
</style>