<template>
  <div>
    <h1>{{$store.state.movie.title}}</h1>
    <img :src="$store.state.movie.posterPath" class="image-fit"/>
    <p>{{$store.state.movie.overview}}</p>
    <p>{{$store.state.movie.releaseDate}}</p>
    <p>{{$store.state.movie.length}} minutes</p>
    <p>{{$store.state.movie.directorId}}</p>
    <add-and-delete-button-vue/>

  </div>

</template>

<script>
import APIService from '../services/APIService';
import AddAndDeleteButtonVue from './AddAndDeleteButton.vue';

export default {
    props: { movie: Object },
    components: {AddAndDeleteButtonVue},
    methods:{
      isOnWatchList(){
        for(let i = 0; i < this.$store.state.watchList.length; i++){
          if (this.$store.state.movie.movieId == this.$store.state.watchList[i].movieId){
            return true;
          }
         
        }
         return false;
      },

    


    },
    created(){
    APIService.getWishList().then(response=>{
      this.$store.commit('SET_WATCH_LIST', response.data)
    })

    
    }
}
</script>

<style>

</style>