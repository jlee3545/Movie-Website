
<template>
    <div>
    <div id = "person">
        <person-card v-for="person in $store.state.people"
        v-bind:key = "person.personId"
        v-bind:person = "person"/>
    </div>
    </div>
</template>

<script>
import PersonCard from '../components/PersonCard.vue';

export default {
    components:{PersonCard}
}
</script>

<style scoped>

  #person{
    display: inline-flex;
    justify-content:space-around;
    flex-wrap: wrap;
    border: black;
    border-width: 3px;
  }


</style>