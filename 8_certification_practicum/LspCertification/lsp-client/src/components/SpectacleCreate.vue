<script>
import ky from 'ky'
import SpectacleForm from "./SpectacleForm.vue";
export default {
    components: {SpectacleForm},
    methods: {
        async createData(data) {
            await ky.post('/api/spectacles', {
                json: data
            })

            this.$router.push({name: 'spectacle'})
        }
    }
}
</script>

<template>
    <div>
        <spectacle-form @submit="createData"/>
    </div>
</template>