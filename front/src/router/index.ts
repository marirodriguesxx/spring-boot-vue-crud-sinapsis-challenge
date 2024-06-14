import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import SubestacoesView from '../views/SubestacoesVew.vue'
import AdicionarSubestacaoView from '../views/AdicionarSubestacaoView.vue'
import EditarSubestacaoView from '../views/EditarSubestacaoView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/subestacoes',
      name: 'subestacoes',
      component: SubestacoesView
    },
    {
      path: '/subestacao/add',
      name: 'adicionarSubestacao',
      component: AdicionarSubestacaoView
    },
    {
      path: '/subestacao/edit/:id',
      name: 'editarSubestacao',
      component: EditarSubestacaoView,
      props: true
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue')
    }
  ]
})

export default router
