<template>
  <div>
    <h1>{{$store.state.movie.title}}</h1>
    <img :src="$store.state.movie.posterPath" class="image-fit"/>
    <p>{{$store.state.movie.overview}}</p>
    <p>{{$store.state.movie.releaseDate}}</p>
    <p>{{$store.state.movie.length}} minutes</p>
    <p>{{$store.state.movie.directorId}}</p>

  </div>

</template>

<script>
export default {
    props: { movie: Object },
}
</script>

<style>

</style>