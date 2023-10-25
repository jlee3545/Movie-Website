<template>
  <div>
    <h1>{{$store.state.movie.title}}</h1>
    <img :src="$store.state.movie.posterPath" class="image-fit"/>
  </div>

</template>

<script>
export default {
    props: { movie: Object },
}
</script>

<style>

</style>