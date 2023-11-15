<template>
  <ul>
    <router-link v-bind:to="{ name: 'genre', params: { id:genre.genreId } }" v-for="genre in $store.state.genres" v-bind:key="genre.genreId">
    <li >{{genre.name}}</li>
    </router-link>
  </ul>
</template>

<script>
import APIService from '../services/APIService.js';

export default {
    name:"genre-list",
    created(){
    APIService.getGenres().then(response=>{
      this.$store.commit('SET_GENRES', response.data)
    })
  }

}
</script>

<style scoped>
  ul {
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
  }

  li{
    list-style:none;
    color:antiquewhite;
    font-family: "Montserrat";
    font-size: 1.5rem;
    padding: 1rem;
  }

  ul a{
    text-decoration: none;
  }

  li:hover{
    color: rgb(211, 211, 253);
  }

</style>