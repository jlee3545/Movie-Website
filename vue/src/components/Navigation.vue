<template>
    <div id="nav">
        &nbsp;|&nbsp;<router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'people'}"> Browse Movies by People </router-link> &nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'watchlist'}"> My Watch List </router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
    </div>
</template>

<style>
#nav{
    display: flex;
    justify-content: space-around;
    font-size: 2rem;
    margin: 1rem;
    margin-right: 0rem;
    margin-left:0rem;
    color:#fff;
}

#nav a{
    color: #fff;
    text-decoration: none;
}

#nav a:hover{
    color: rgb(211, 211, 253);
}
</style>