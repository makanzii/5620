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
