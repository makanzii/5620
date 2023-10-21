import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import VueCookies from 'vue-cookies'
import store from './store'

const app = createApp(App)

app.use(router)
app.use(VueCookies, { expires: '7d' })
app.use(store)

app.mount('#app')
