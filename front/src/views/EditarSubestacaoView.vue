<script setup lang="ts">
import { useRoute } from 'vue-router'
import SubestacaoForm from '../components/SubestacaoForm.vue'

const route = useRoute()
const subestacaoId = Number(route.params.id) // Convertendo o ID para número
</script>

<template>
  <SubestacaoForm :isEditing="true" :subestacaoId="subestacaoId" />
</template>
