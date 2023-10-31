<template>
<div>
  <person-card v-for="person in $store.state.people"
        v-bind:key = "person.personId"
        v-bind:person = "person"/>
     </div>
</template>

<script>
import APIService from '../services/APIService.js';
import PersonCard from '../components/PersonCard.vue';
export default {
   
   components: {
    PersonCard
   },
   created(){
    APIService.getAllPeople().then(response=>{
      this.$store.commit('SET_PEOPLE', response.data)
    })
   }
    
    }

</script>

<style>

</style>