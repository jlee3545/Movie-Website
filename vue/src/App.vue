<template>
  <div id="app">
    <Header/>
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
import Header from './components/Header.vue'
export default {
  components:{Header}
}
</script>


<style>
@import url('https://fonts.googleapis.com/css2?family=Averia+Serif+Libre:ital,wght@0,300;1,300&family=Caprasimo&family=DM+Sans:opsz,wght@9..40,200;9..40,300;9..40,500&family=Homemade+Apple&family=Lexend:wght@200;300&family=Montserrat:wght@300;400&family=Young+Serif&display=swap');

h1{
  font-family: "Montserrat";
  text-align: center;
  font-size: 3rem;
  color:rgba(240, 255, 255, 0.705);
}

h2{
  color: rgba(240, 255, 255, 0.705);;
}

#app{
  background: rgb(14, 14, 53);
  width: 100vw;
}
</style>
