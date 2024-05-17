import {createWebHistory, createRouter} from 'vue-router'

import Home from './components/Home.vue'
import Admin from './components/Admin.vue'
import Order from './components/Order.vue'
import Distributor from './components/Distributor.vue'
import DistributorEdit from './components/DistributorEdit.vue'
import Spectacle from './components/Spectacle.vue'
import SpectacleEdit from './components/SpectacleEdit.vue'
import DistributorCreate from "./components/DistributorCreate.vue";
import SpectacleCreate from "./components/SpectacleCreate.vue";

const routes = [
    {path: '/', name:'home', component: Home},
    {
        path: '/admin', name:'admin', component: Admin,
        children: [
            {path: '', name: 'admin-default', component: Distributor},
            {path: 'distributor', name: 'distributor', component: Distributor},
            {path: 'distributor-create', name: 'distributor-create', component: DistributorCreate},
            {path: 'distributor/:id', name: 'distributor-id', component: DistributorEdit},
            {path: 'spectacle', name: 'spectacle', component: Spectacle},
            {path: 'spectacle/:id', name: 'spectacle-id', component: SpectacleEdit},
            {path: 'spectacle-create', name: 'spectacle-create', component: SpectacleCreate}
        ]
    },
    {path: '/order', name: 'order', component: Order},
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router