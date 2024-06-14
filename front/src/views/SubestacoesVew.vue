<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { getSubestacoes } from '../services/SubestacaoService'
import type { Subestacao } from '../models/SubestacaoModel'

const subestacoes = ref<Subestacao[]>([])

onMounted(async () => {
  subestacoes.value = await getSubestacoes()
})

const alterarSubestacao = (id: number) => {
  console.log(`Alterar subestação com ID: ${id}`)
}

const excluirSubestacao = (id: number) => {
  console.log(`Excluir subestação com ID: ${id}`)
}

const incluirSubestacao = () => {
  console.log('Incluir nova subestação')
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
    <button class="add-button" @click="incluirSubestacao">Incluir Subestação</button>
  </div>
</template>
<style scoped>
.page {
  display: grid;
  place-items: center;
  padding: 1rem;
  grid-template-rows: min-content min-content;
  height: 100vh;
  width: 100%;
  background: url('@/assets/electric-grid.jpg') no-repeat center center fixed;
  background-size: cover;
  justify-items: center;
  align-items: center;
  padding: 1rem;
}

.content {
  text-align: center;
  padding: 1rem;
  background-color: rgba(255, 255, 255, 0.8);
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
  color: #000;
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
  white-space: nowrap; /* Evita quebra de linha */
}

th {
  background-color: #f2f2f2;
  font-weight: bold;
}

button {
  margin-right: 5px;
  margin: 1rem;
  padding: 5px 10px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}

.add-button {
  align-self: end;
  background-color: #28a745;
  padding: 10px 20px;
  font-size: 16px;
}

.add-button:hover {
  background-color: #218838;
}
</style>
