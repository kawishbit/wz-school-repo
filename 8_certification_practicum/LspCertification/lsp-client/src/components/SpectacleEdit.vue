<script>
import ky from 'ky'
import SpectacleForm from "./SpectacleForm.vue";
import DistributorForm from "./DistributorForm.vue";
export default {
    components: {DistributorForm, SpectacleForm},
    data() {
        return {
            spectacleId: "",
            spectacleData: {
                spectacleCode: "",
                spectacleType: "",
                spectacleBrand: "",
                price: "",
                stock: "",
                distributorId: "",
            }
        }
    },
    async mounted() {
        this.spectacleId = this.$route.params.id;
        await this.getData()
    },
    methods: {
        async getData() {
            this.spectacleData = await ky.get('/api/spectacles/'+this.spectacleId).json();
        },
        async updateData(data) {
            await ky.put('/api/spectacles/'+this.spectacleId, {
                json: data
            })

            this.$router.push({name: 'spectacle'})
        }
    }
}
</script>

<template>
    <div>
        <spectacle-form :form-data="spectacleData"  @submit="updateData"/>
    </div>
</template>