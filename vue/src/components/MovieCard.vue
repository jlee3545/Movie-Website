<template>
<div class = "card-container">
    <div class ="card">
    <router-link v-bind:to="{ name: 'movie', params: { id:movie.movieId } }" v-bind:movie="movie">
    <img :src="movie.posterPath" class="image-fit"/>
    </router-link>
  </div>
      <h2 class="movie-title">{{movie.title}} ({{movie.releaseDate.substring(0,4)}})</h2>
</div>
</template>

<script>

export default {
    name: "movieCard",
    props: { movie: Object },
}
</script>

<style>
.card-container{
    border: black 3px;
    border-width: 3px;
    width: 30rem ;
}
div.card{
  display: flex;
  justify-content: center;
}

.movie-title{
  width:100%;
  text-align: center;
  font-family: "Montserrat";
}

img{
  width: 20rem;
}

</style>