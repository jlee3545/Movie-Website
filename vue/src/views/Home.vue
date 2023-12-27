<template>
<div id = "welcome" class="fade-in-text">
  <h1>Welcome to PopFlix!</h1>
  <p>Use the navigation bar to browse movies and add to your watch list. Enjoy your shows!</p>
</div>
</template>

<script>
export default {
  name: "home",


};
</script>

<style scoped>
#welcome{
  background-color: black;
  height: 100vw;
}

h1{
  margin-top: 0rem;
  padding-top: 10rem;
  font-size: 5rem;
}

.fade-in-text {
  font-family: "Barlow";
  font-size: 150px;
  animation: fadeIn 5s;
}

p{
  text-align: center;
  width: auto;
  color: white;
}
</style>
