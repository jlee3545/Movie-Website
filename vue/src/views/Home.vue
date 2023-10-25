<template>
  <div class="home">
    <div>
    <GenreList/>
    </div>
    <all-movies-list/>
  </div>
</template>

<script>
import GenreList from "../components/GenreList"
import AllMoviesList from "../components/AllMoviesList.vue"
import APIService from '../services/APIService.js';
export default {
  name: "home",
  components:{GenreList, AllMoviesList},
  created(){
    APIService.getMovie(this.$route.params.id).then((response) => {
      this.$store.commit("SET_MOVIE", response.data);
    })
    }
};
</script>
