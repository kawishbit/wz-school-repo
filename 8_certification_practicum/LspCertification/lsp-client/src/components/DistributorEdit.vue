<script>
import ky from 'ky'
import DistributorForm from "./DistributorForm.vue";
export default {
    components: {DistributorForm},
    data() {
        return {
            distributorId: "",
            distributorData: {
                distributorCode: "",
                distributorName: "",
                address: "",
                emailAddress: "",
                phoneNumber: "",
                contactPerson: "",
            }
        }
    },
    async mounted() {
        this.distributorId = this.$route.params.id;
        await this.getData()
    },
    methods: {
        async getData() {
            this.distributorData = await ky.get('/api/distributors/'+this.distributorId).json();
        },
        async updateData(data) {
            await ky.put('/api/distributors/'+this.distributorId, {
                json: data
            })

            this.$router.push({name: 'distributor'})
        }
    }
}
</script>

<template>
    <div>
        <distributor-form :form-data="distributorData" @submit="updateData"/>
    </div>
</template>