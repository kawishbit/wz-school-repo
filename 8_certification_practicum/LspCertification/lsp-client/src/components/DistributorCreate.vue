<script>
import ky from 'ky'
import DistributorForm from "./DistributorForm.vue";
export default {
    components: {DistributorForm},
    methods: {
        async createData(data) {
            await ky.post('/api/distributors', {
                json: data
            })

            this.$router.push({name: 'distributor'})
        }
    }
}
</script>

<template>
    <div>
        <distributor-form @submit="createData"/>
    </div>
</template>