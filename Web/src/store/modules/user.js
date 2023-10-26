// initial state
const state = () => ({
  id: null,
  username: null,
  email: null,
  role: null,
  dob: null
})

// getters
const getters = {}

// actions
const actions = {}

// mutations
const mutations = {
  setUser(state, user) {
    state.id = user.id
    state.username = user.username
    state.email = user.email
    state.role = user.role
    state.dob = user.dob
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
