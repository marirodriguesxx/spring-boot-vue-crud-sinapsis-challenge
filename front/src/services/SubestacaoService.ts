import axios from 'axios'
import type { Subestacao } from '../models/SubestacaoModel'

const API_URL = 'http://localhost:8080/subestacao/all'

export const getSubestacoes = async (): Promise<Subestacao[]> => {
  try {
    const response = await axios.get<Subestacao[]>(API_URL)
    console.log('Dados recebidos do backend:', response.data)
    return response.data
  } catch (error) {
    console.error('Erro ao buscar subestações:', error)
    return []
  }
}
