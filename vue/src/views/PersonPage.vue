<template>
  <div><person-details-card/>
  <actor-movie-list/>
  </div>
</template>

<script>
import ActorMovieList from '../components/ActorMovieList.vue'
import PersonDetailsCard from '../components/PersonDetailsCard.vue'
import APIService from "../services/APIService.js"
export default {
components:{PersonDetailsCard, ActorMovieList},
created(){
    APIService.getPersonById(this.$route.params.id).then(response=>{
      this.$store.commit('SET_PERSON', response.data)
    })
   }
}
</script>

<style>

</style>