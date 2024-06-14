<script setup lang="ts">
import { ref, watch, onMounted } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'
import type { Subestacao } from '../models/SubestacaoModel'

interface Props {
  isEditing: boolean
  subestacaoId?: number
}

const props = defineProps<Props>()
const router = useRouter()

const codigo = ref('')
const nome = ref('')
const latitude = ref('')
const longitude = ref('')

const submitForm = async () => {
  if (props.isEditing) {
    const url = `http://localhost:8080/subestacao/update/${props.subestacaoId}`
    const params = new URLSearchParams({
      codigo: codigo.value,
      nome: nome.value,
      latitude: latitude.value,
      longitude: longitude.value
    }).toString()

    try {
      await axios.put(`${url}?${params}`)
      router.push('/subestacoes')
    } catch (error) {
      console.error('Erro ao salvar subestação:', error)
    }
  } else {
    const url = `http://localhost:8080/subestacao/add`
    const data = {
      codigo: codigo.value,
      nome: nome.value,
      latitude: latitude.value,
      longitude: longitude.value
    }

    try {
      await axios.post(url, data)
      router.push('/subestacoes')
    } catch (error) {
      console.error('Erro ao adicionar subestação:', error)
    }
  }
}

const loadSubestacao = async () => {
  if (props.isEditing && props.subestacaoId !== undefined) {
    const url = `http://localhost:8080/subestacao/${props.subestacaoId}`
    try {
      const response = await axios.get(url)
      const subestacao: Subestacao = response.data
      codigo.value = subestacao.codigo
      nome.value = subestacao.nome
      latitude.value = subestacao.latitude.toString()
      longitude.value = subestacao.longitude.toString()
    } catch (error) {
      console.error('Erro ao buscar subestação:', error)
    }
  }
}

const voltar = () => {
  router.push('/subestacoes')
}

onMounted(loadSubestacao)
watch(() => props.subestacaoId, loadSubestacao)
</script>

<template>
  <div class="page">
    <div class="content">
      <h1>{{ isEditing ? 'Editar Subestação' : 'Adicionar Nova Subestação' }}</h1>
      <form @submit.prevent="submitForm" class="form">
        <div>
          <label for="codigo">Código:</label>
          <input type="text" v-model="codigo" id="codigo" required />
        </div>
        <div>
          <label for="nome">Nome:</label>
          <input type="text" v-model="nome" id="nome" required />
        </div>
        <div>
          <label for="latitude">Latitude:</label>
          <input type="text" v-model="latitude" id="latitude" required />
        </div>
        <div>
          <label for="longitude">Longitude:</label>
          <input type="text" v-model="longitude" id="longitude" required />
        </div>
        <div class="button-group">
          <button type="button" class="back-button" @click="voltar">Voltar</button>
          <button type="submit" @click="voltar">
            {{ isEditing ? 'Salvar Alterações' : 'Adicionar' }}
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped>
.page {
  display: grid;
  place-items: center;
  height: 100vh;
  width: 100%;
  background: url('@/assets/electric-grid.jpg') no-repeat center center fixed;
  background-size: cover;
  padding: 1rem;
}

.content {
  display: grid;
  gap: 1rem;
  text-align: center;
  color: black;
  background-color: rgba(255, 255, 255, 0.8);
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
  margin-bottom: 1rem;
}

.form div {
  margin-bottom: 1rem;
}

.form label {
  display: block;
  margin-bottom: 0.5rem;
}

.form input {
  width: 100%;
  padding: 0.5rem;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.form .button-group {
  display: flex;
  justify-content: space-between;
  gap: 1rem;
}

button {
  display: flex;
  background-color: #007bff;
  padding: 10px 20px;
  font-size: 16px;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}

.back-button {
  background-color: #007bff;
}

.back-button:hover {
  background-color: #0056b3;
}
</style>
