<template>

<div class="card-container">
    <div class="card" style="width: 18rem;">
      <router-link v-bind:to="{ name: 'person', params: { id:person.personId } }">
        <img class="card-img-top"  :src="person.photo" alt="poster-image">
        <div class="card-body">
          <h5 class="card-title">{{person.name}}</h5>
        </div>
      </router-link>
    </div>
  </div>
</template>

<script>

export default {
    name: "personCard",
    props: { person: Object },
}
</script>

<style scoped>
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
  width: 100%;
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
  height: 8rem;
  display: flex;
  align-items: center;
  justify-content: center;
  position:absolute;
  border-top:solid;
  border-width: .1rem;
  top: 18.8rem;
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
  transform: scale(1.1);
  transition:1s;

}

</style>