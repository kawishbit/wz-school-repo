<script>

import ky from 'ky'
export default {
    data() {
        return {
            distributors: []
        }
    },
    async mounted() {
        await this.getItems()
    },
    methods: {
        async getItems() {
            this.distributors = await ky.get('/api/distributors').json()
        },
        async deleteItem(id) {
            await ky.delete('/api/distributors/'+id)
            await this.getItems();
        }
    }
}
</script>

<template>
    <div class="container flex flex-col justify-start items-stretch">
        <div class ="flex flex-row justify-start items-center">
            <button class="btn btn-neutral" @click="$router.push({name: 'distributor-create'})">Create</button>
        </div>
        <div class="overflow-x-auto mt-5">
            <table class="table">
                <!-- head -->
                <thead>
                <tr>
                    <th></th>
                    <th>Code</th>
                    <th>Distributor Name</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Contact Person</th>
                    <th>Action</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <!-- row 1 -->
                <tr v-for="(item,i) in distributors">
                    <th>{{i+1}}</th>
                    <td>{{item.distributorCode}}</td>
                    <td>{{item.distributorName}}</td>
                    <td>{{item.address}}</td>
                    <td>{{item.emailAddress}}</td>
                    <td>{{item.phoneNumber}}</td>
                    <td>{{item.contactPerson}}</td>
                    <td><button @click="$router.push({name:'distributor-id', params:{id:item.distributorId}})" class="btn btn-neutral">Edit</button></td>
                    <td><button @click="deleteItem(item.distributorId)"  class="btn btn-neutral">Delete</button></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>