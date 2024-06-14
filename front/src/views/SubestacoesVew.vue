<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { useRouter } from 'vue-router'
import axios from 'axios'
import { getSubestacoes } from '../services/SubestacaoService'
import type { Subestacao } from '../models/SubestacaoModel'

const subestacoes = ref<Subestacao[]>([])
const router = useRouter()

onMounted(async () => {
  subestacoes.value = await getSubestacoes()
})

const alterarSubestacao = (id: number) => {
  router.push({ name: 'editarSubestacao', params: { id } })
}

const excluirSubestacao = async (id: number) => {
  try {
    await axios.delete(`http://localhost:8080/subestacao/delete/${id}`)
    subestacoes.value = subestacoes.value.filter((subestacao) => subestacao.id !== id)
  } catch (error) {
    console.error(`Erro ao excluir subestação com ID: ${id}`, error)
  }
}

const incluirSubestacao = () => {
  router.push({ name: 'adicionarSubestacao' })
}

const voltarParaLogin = () => {
  router.push('/')
}
</script>

<template>
  <div class="page">
    <div class="content">
      <h1>Lista de Subestações</h1>
      <table>
        <thead>
          <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Excluir</th>
            <th>Alterar</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="subestacao in subestacoes" :key="subestacao.id">
            <td>{{ subestacao.codigo }}</td>
            <td>{{ subestacao.nome }}</td>
            <td>
              <button @click="excluirSubestacao(subestacao.id)">Excluir</button>
            </td>
            <td>
              <button @click="alterarSubestacao(subestacao.id)">Alterar</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="button-group">
      <button class="action-button" @click="voltarParaLogin">Voltar para Login</button>
      <button class="action-button" @click="incluirSubestacao">Incluir Subestação</button>
    </div>
  </div>
</template>

<style scoped>
.page {
  display: grid;
  place-items: center;
  padding: 1rem;
  grid-template-rows: auto auto;
  height: 100vh;
  width: 100%;
  background: url('@/assets/electric-grid.jpg') no-repeat center center fixed;
  background-size: cover;
  justify-items: center;
  align-items: center;
}

.content {
  text-align: center;
  color: #000;
  background-color: rgba(255, 255, 255, 0.8);
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  width: 80%;
}

.button-group {
  display: flex;
  justify-content: space-evenly;
  width: 80%;
  margin-top: 1rem;
}

.action-button {
  padding: 10px 20px;
  background-color: #28a745;
  color: white;
  font-size: 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.action-button:hover {
  background-color: #218838;
}

h1 {
  margin-bottom: 1rem;
}

table {
  width: 100%;
  background-color: #ffffff;
  color: #000;
  border-collapse: collapse;
  display: grid;
  grid-template-columns: repeat(4, minmax(min-content, 1fr));
  grid-auto-rows: minmax(40px, auto);
}

thead,
tbody,
tr {
  display: contents;
}

th,
td {
  padding: 8px;
  text-align: center;
  border: 1px solid #ddd;
  white-space: nowrap;
}

th {
  background-color: #f2f2f2;
  font-weight: bold;
}

button {
  margin: 0.5rem;
}

.button-group {
  display: flex;
  justify-content: center;
  gap: 20px;
}
</style>
