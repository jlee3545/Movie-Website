<template>
  <div>
    <button    
    v-on:click="isOnWatchList?deleteMovieFromWatchList():addMovieToWatchlist()">{{isOnWatchList?"Delete From WatchList":"Add to Watchlist"}}</button>
       {{isOnWatchList}}
  </div>
</template>

<script>

import APIService from '../services/APIService';
export default {
    props: { movie: Object },
    methods:{
      addMovieToWatchlist(){
        APIService.addToWishlist(this.$route.params.id).then(
          window.alert("Movie added to watchlist")
        )
      },

      deleteMovieFromWatchList(){
        APIService.deleteFromWishlist(this.$route.params.id).then(
          window.alert("Movie deleted from list")
        )
      }
      },
      computed:{
    //    isOnWatchList(){
    //     for(let i = 0; i < this.$store.state.watchList.length; i++){
    //       if (this.$store.state.movie.movieId == this.$store.state.watchList[i].movieId){
    //         return true;
    //       }
         
    //     }
    //      return false;
    //   }

    isOnWatchList(){
        let movieIndex = 0;
        for(let i=0; i<this.$store.state.movies.length; i++){
             
           if(this.$store.state.movies[i].movieId == this.movie.movieId){
                movieIndex = i;
           }
           
        }
        for(let i = 0; i < this.$store.state.watchList.length; i++){
          if (this.$store.state.movies[movieIndex].movieId == this.$store.state.watchList[i].movieId){
            return true;
          }
         
        }
         return false;
        
    }
}
}
</script>

<style>

</style>