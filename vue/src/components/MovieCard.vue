<template>
  <div class="card-container">
    <div class="card" style="width: 12rem;">
      <router-link v-bind:to="{ name: 'movie', params: { id: movie.movieId } }">
        <img class="card-img-top" :src="movie.posterPath" alt="poster-image" onerror="this.src='https://eticketsolutions.com/demo/themes/e-ticket/img/movie.jpg'">
        <div class="card-body">
          <h5 class="card-title">{{ movie.title }} ({{ movie.releaseDate.substring(0, 4) }})</h5>
        </div>
      </router-link>
    </div>
  </div>
</template>

<script>
// import AddAndDeleteButtonVue from './AddAndDeleteButton.vue';
// import APIService from '../services/APIService';

export default {
  name: "movieCard",
  props: { movie: Object },
  data() {
    return {
      currentMovie: {}
    }
  },
  // components: {AddAndDeleteButtonVue},
  // created() {

  //   this.currentMovie = this.movie;

  // }
}
</script>

<style>
.card-container {
  border: black 3px;
  border-width: 3px;
  width: auto;
}

div.card {
  display: flex;
  justify-content: center;
}

.movie-title {
  width: 100%;
  text-align: center;
  font-family: "Montserrat";
}

img {
  width: 20rem;
  border-radius: .2rem;
}

.card-body a{
  text-decoration: none;
  color: black;
}

a{
  text-decoration: none;
  margin:0px;
  padding: 0px;
}

.card-body{
  text-align: center;
  background-color: rgba(0, 0, 0, 0.603);
  height: 5rem;
  display: flex;
  align-items: center;
  justify-content: center;
  position:absolute;
  border-top:solid;
  border-width: .1rem;
  top: 12.8rem;
  border-top: black;
  color: rgb(236, 236, 236);
  width:100%;
}
.card .card-body:hover{
  color:rgba(240, 248, 255, 0);
  background-color: rgba(240, 248, 255, 0);
  transition:1s;
}


.card{
  margin:1rem;
  border: solid black;
  border-width: .1rem;
}

.card:hover{
  transform: scale(1.2);
  transition:1s;
}

.card-title{
  font-size:1rem;
}
</style>