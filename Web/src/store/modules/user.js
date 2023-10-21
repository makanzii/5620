// initial state
const state = () => ({
  user_id: null,
  username: null,
  email: null,
  phone_number: null,
  user_type: null
})

// getters
const getters = {}

// actions
const actions = {}

// mutations
const mutations = {
  setUser(state, user) {
    state.user_id = user.user_id
    state.username = user.username
    state.email = user.email
    state.phone_number = user.phone_number
    state.user_type = user.user_type
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
