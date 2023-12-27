<template>
    <div id="nav">
        <div class="nav-link" > <router-link v-bind:to="{ name: 'movies' }" v-if="$store.state.token != ''">
                <div><font-awesome-icon icon="fa-solid fa-film" size="xl" /></div> Browse by Genre
            </router-link>
        </div>
        <div class="nav-link" v-if="$store.state.token != ''"> <router-link v-bind:to="{ name: 'people' }" >
                <div><font-awesome-icon :icon="['fas', 'person']" size="xl" /></div>Browse by People
            </router-link>
        </div>
        <div class="nav-link"> <router-link v-bind:to="{ name: 'watchlist' }" v-if="$store.state.token != ''">
                <div><font-awesome-icon icon="fa-solid fa-eye" size="xl" /></div> My Watch List
            </router-link>
        </div>
        <div class="nav-link" v-if="$store.state.token == ''"> <router-link v-bind:to="{ name: 'login' }" >
                <div><font-awesome-icon icon="fa-solid fa-right-from-bracket" size="xl" /></div>Login
            </router-link>
        </div>
        <div class="nav-link" v-if="$store.state.token != ''"> <router-link v-bind:to="{ name: 'logout' }" >
                <div><font-awesome-icon icon="fa-solid fa-right-from-bracket" size="xl" /></div> Logout
            </router-link>
        </div>
    </div>
</template>

<style>
#nav {
    display: flex;
    justify-content: space-around;
    font-size: 1rem;
    margin: 1rem;
    margin-top: 0rem;
    margin-right: 0rem;
    margin-left: 0rem;
    color: #fff;
    width: 50%;
}

#nav a {
    color: #fff;
    text-decoration: none;
}

#nav a:hover {
    color: rgb(211, 211, 253);
}

.nav-link div {
    display: flex;
    justify-content: center;
}
.nav-link{
    width:25%;
    text-align: center;
}

@media only screen and (max-width: 600px) {
  #nav {
    width:auto;
    font-size: .80rem;
    }
}
</style>