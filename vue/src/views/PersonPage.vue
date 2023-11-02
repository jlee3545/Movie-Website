<template>
  <div><person-details-card/>
  </div>
</template>

<script>
import PersonDetailsCard from '../components/PersonDetailsCard.vue'
import APIService from "../services/APIService.js"
export default {
components:{PersonDetailsCard},
created(){
    APIService.getPersonById(this.$route.params.id).then(response=>{
      this.$store.commit('SET_PERSON', response.data)
    })
   }
}
</script>

<style>

</style>