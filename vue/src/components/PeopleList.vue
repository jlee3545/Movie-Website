
<template>
    <div>
    <div id = "movies">
        <person-card v-for="person in $store.state.people"
        v-bind:key = "person.personId"
        v-bind:person = "person"/>
    </div>
    </div>
</template>

<script>
import PersonCard from '../components/PersonCard.vue';
import APIService from '../services/APIService.js';

export default {
    components:{PersonCard},
    created(){
    APIService.getAllPeople().then(response=>{
      this.$store.commit('SET_PEOPLE', response.data)
    })
    }

}
</script>

<style>

  #movies{
    display: inline-flex;
    justify-content:space-around;
    flex-wrap: wrap;
    border: black;
    border-width: 3px;
  }


</style>