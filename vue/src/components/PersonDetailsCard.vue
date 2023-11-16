<template>
  <div id="movie-container">
      <div id="poster"><img :src="$store.state.currentPerson.photo" class="image-fit" /></div>
      <div id="movie-info">
        <div id="button-and-title">
          <div>
            <h1 id="movie-title">{{$store.state.currentPerson.name}}</h1>
          </div>
        </div>
        <p><b>Born on: </b>{{$store.state.currentPerson.birthday}}</p>
        <p v-if="$store.state.currentPerson.deathday != null"><b>Died on: </b>{{$store.state.currentPerson.deathday}}</p>
        <p><b>Biography:</b></p>
        <p>{{$store.state.currentPerson.biography}}</p>
      </div>
      </div>
</template>



<script>
export default {
    name:"personDetails",
}
</script>

<style>
p {
  font-size: 1.5rem;
  font-family: "Montserrat"
}

#movie-container {
  display: flex;
  margin: 4rem;
  margin-top: 1rem;
  border: solid;
  border-color: black;
  background-color: aliceblue;
  align-content: center;
}

#movie-info {
  padding: 2rem;
}

#movie-title {
  color: black;
  padding: 0px;
}

#poster img {
  padding: 0px;
}


#button-and-title {
  display: flex;
  justify-content: space-between;
  margin: 0px;
  padding: 0px;
  align-content: center;
}

@media screen and (max-width: 500px) {
  #movie-container {
    flex-wrap: wrap;
  }
}
</style>