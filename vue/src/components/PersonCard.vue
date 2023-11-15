<template>
<div class = "card-container">
    <div class ="card">
    <router-link v-bind:to="{ name: 'person', params: { id:person.personId } }" v-bind:person="person">
    <img :src="person.photo" class="image-fit"/>
    </router-link>
  </div>
      <h2 class="movie-title">{{person.name}}</h2>
</div>
</template>

<script>

export default {
    name: "personCard",
    props: { person: Object },
}
</script>

<style scoped>
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