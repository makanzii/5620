<script>
import HeaderComponent from "@/components/HeaderComponent.vue";

export default {
  components: {
    HeaderComponent,
  },
  data() {
    return {
      noHeaderViews: ["Login", "ForgotPassword", "ResetPassword"]
    }
  },
  computed: {
    pageName() {
      if (this.$route.name === "Task") {
        return this.taskName;
      }
      return this.$route.name;
    }
  },
  mounted() {
    fetch(`${import.meta.env.VITE_ROOT_API}/csrf-token`)
      .then(response => response.json())
      .then(data => {
        this.$cookies.set("csrf_token", data.csrf_token);
      })
      .catch(error => console.error(error));
  }
};
</script>

<template>
  <HeaderComponent v-if="!noHeaderViews.includes(pageName)">{{ pageName }}</HeaderComponent>
  <router-view class="router-view"></router-view>
</template>

<style scoped>
.router-view {
  height: 100%;
}

@media (prefers-color-scheme: dark) {
  .router-view {
    background-color: var(--dark-background);
  }
}
</style>
