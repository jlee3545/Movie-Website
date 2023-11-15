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
export default {
  name: "home",
  components:{GenreList, AllMoviesList},

};
</script>
