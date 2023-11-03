<template>
<div>
  <MovieDetailsCard/>
  <PeopleList/>
</div>
</template>

<script>
import APIService from '../services/APIService.js'
import PeopleList from '../components/PeopleList.vue'
import MovieDetailsCard from '../components/MovieDetailsCard.vue';
export default {
    name:"movie",
    props:["movie"],
    components:{MovieDetailsCard, PeopleList},
    created(){
    APIService.getMovie(this.$route.params.id).then((response) => {
      this.$store.commit("SET_MOVIE", response.data);
    })
    APIService.getActorsByMovieId(this.$route.params.id).then((response) => {
      this.$store.commit("SET_PEOPLE", response.data);
    })
    }
}
</script>

<style>

</style>