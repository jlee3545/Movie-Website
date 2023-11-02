<template>
  <div>
    <h2>{{$store.state.currentPerson.name}}</h2>
    <img :src="$store.state.currentPerson.photo" class="image-fit"/>
    <p>Born on {{$store.state.currentPerson.birthday}}</p>
    <p v-if="$store.state.currentPerson.deathday != null">Died on: {{$store.state.currentPerson.deathday}}</p>
    <p>{{$store.state.currentPerson.biography}}</p>
  </div>
</template>

<script>
export default {
    name:"personDetails",
}
</script>

<style>

</style>