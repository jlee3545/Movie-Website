<template>
<div>
  <MovieDetailsCard/>
</div>
</template>

<script>
import MovieDetailsCard from '../components/MovieDetailsCard.vue';
export default {
    name:"movie",
    props:["movie"],
    components:{MovieDetailsCard},
    // created(){
    // APIService.getMovie(this.$route.params.id).then((response) => {
    //   this.$store.commit("SET_MOVIE", response.data);
    // })
    // }
}
</script>

<style>

</style>