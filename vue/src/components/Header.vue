<template>
  <div id="container">
    <div id="name"><router-link v-bind:to="{ name: 'home' }"><img src="/Logo.png" alt="logo"/></router-link></div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>

    #container{
        margin: 0px;
        padding: 2rem;
        background-image: url("https://static.vecteezy.com/system/resources/previews/002/492/342/non_2x/35mm-film-reel-frames-free-vector.jpg");
        background-size: 47rem;
        height: 15rem;
        display: flex;
        align-content: center;
        justify-content: center;
        padding:0px;
    }

    #name{
      background-color: rgba(0, 0, 0, 0.075);
      width: 100%;
      margin:0px;
      color:#fff;
      height: 100%;
      display: flex;
      justify-content: left;
      align-items: center;
    }

    img{
      width:20rem;
    }

    img:hover{
      position: relative;
      transform: rotate(-5deg);
      transition:.5s;
    }
</style>