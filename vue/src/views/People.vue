<template>
<div>
  <people-list/>
     </div>
</template>

<script>
import APIService from '../services/APIService.js';
import PeopleList from '../components/PeopleList.vue';
export default {
   components: {
    PeopleList
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