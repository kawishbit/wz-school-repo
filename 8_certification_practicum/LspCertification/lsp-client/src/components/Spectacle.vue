<script>

import ky from 'ky'
export default {
    data() {
        return {
            spectacles: []
        }
    },
    async mounted() {
        await this.getItems()
    },
    methods: {
        async getItems() {
            this.spectacles = await ky.get('/api/spectacles').json()
        },
        async deleteItem(id) {
            await ky.delete('/api/spectacles/'+id)
            await this.getItems();
        }
    }
}
</script>

<template>
    <div class="container flex flex-col justify-start items-stretch">
        <div class ="flex flex-row justify-start items-center">
            <button class="btn btn-neutral" @click="this.$router.push({name: 'spectacle-create'})">Create</button>
        </div>
        <div class="overflow-x-auto mt-5">
            <table class="table">
                <!-- head -->
                <thead>
                <tr>
                    <th></th>
                    <th>Code</th>
                    <th>Lens Type</th>
                    <th>Lens Brand</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th>Distributor</th>
                    <th>Action</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <!-- row 1 -->
                <tr v-for="(item,i) in spectacles">
                    <th>{{i+1}}</th>
                    <td>{{item.spectacleCode}}</td>
                    <td>{{item.spectacleType}}</td>
                    <td>{{item.spectacleBrand}}</td>
                    <td>{{item.price}}</td>
                    <td>{{item.stock}}</td>
                    <td>{{item.distributor}}</td>
                    <td><button @click="this.$router.push({name:'spectacle-id', params:{id:item.spectacleId}})" class="btn btn-neutral">Edit</button></td>
                    <td><button @click="deleteItem(item.spectacleId)"  class="btn btn-neutral">Delete</button></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>