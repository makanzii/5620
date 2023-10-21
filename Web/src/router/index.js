import { createRouter, createWebHistory } from 'vue-router'
import store from '@/store'

import HomePage from '@/views/HomePage.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: { path: '/home' }
    },
    {
      path: '/home',
      name: 'Home',
      component: HomePage,
      meta: { requiresAuth: true }
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('@/views/LoginPage.vue')
    },
    {
      path: '/forgot-password',
      name: 'ForgotPassword',
      component: () => import('@/views/ForgotPasswordPage.vue')
    },
    {
      // add "/" to the end of the path to prevent 404 error due to the dot in the token
      path: '/reset-password/:reset_password_token/',
      name: 'ResetPassword',
      component: () => import('@/views/ResetPasswordPage.vue'),
      meta: { requiresAuth: true }
    },
    {
      path: '/main',
      component: () => import('@/views/MainPage.vue'),
      meta: { requiresAuth: true },
      children: [
        {
          path: '',
          redirect: { path: '/main/dashboard' }
        },
        {
          path: 'dashboard',
          name: 'Dashboard',
          component: () => import('@/views/main/DashboardSection.vue')
        },
        {
          path: 'courses/',
          name: 'Courses',
          component: () => import('@/views/main/CoursesSection.vue'),
          children: [
            {
              path: ':course_id/',
              component: () => import('@/views/main/CourseDetail.vue')
            }
          ]
        },
        {
          path: 'messages',
          name: 'Messages',
          component: () => import('@/views/main/MessagesSection.vue')
        },
        {
          path: 'account',
          name: 'Account',
          component: () => import('@/views/main/AccountSection.vue')
        }
        // Add more sections as needed
      ]
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Check if the route requires authentication
  if (to.matched.some((route) => route.meta.requiresAuth)) {
    // Check if the user is authenticated
    if (window.$cookies.isKey('auth_token')) {
      // Check if the user info is already loaded
      if (store.state.user.user_id === null) {
        // User info is not loaded
        fetch(`${import.meta.env.VITE_ROOT_API}/users/me`, {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json',
            'X-CSRFToken': window.$cookies.get('csrftoken'),
            Authorization: window.$cookies.get('auth_token')
          }
        })
          .then((response) => {
            if (!response.ok) {
              return response.json().then((data) => {
                throw new Error(data.message)
              })
            }
            return response.json()
          })
          .then((data) => {
            console.log(data)
            store.commit('user/setUser', data)
          })
          .catch((error) => {
            console.error(error)
            window.$cookies.remove('auth_token')
            next('/login')
          })
      }
      next() // User is authenticated, proceed to the route
    } else {
      // User is not authenticated, redirect to the login page
      next('/login')
    }
  } else {
    // If the route does not require authentication, proceed as usual
    next()
  }
})

export default router
