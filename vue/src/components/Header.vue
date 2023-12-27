<template>
  <div id="container">
    <div id="name">
      <div id="logo"> <router-link v-bind:to="{ name: 'home' }"><img src="/Logo-White.png" alt="logo" /></router-link>
      </div>
      <NavigationVue />
    </div>
  </div>
</template>

<script>
import NavigationVue from './Navigation.vue';
export default {
  components: { NavigationVue }
}
</script>

<style scoped>
#container {
  background-position-y: -5rem;
  background-size: cover;
  margin: 0px;
  padding: 2rem;
  height: auto;
  display: flex;
  align-content: flex-end;
  justify-content: right;
  padding: 0px;
}

#name {
  background-color: #fd000091;
  width: 100%;
  margin: 0px;
  color: #fff;
  height: 100%;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: baseline;
}

img {
  width: 5rem;
  margin: 2rem;
}

@media only screen and (max-width: 600px) {
  #name {
    display: block;
  }

  #logo{
    display: flex;
    justify-content: center;
  }
}
</style>