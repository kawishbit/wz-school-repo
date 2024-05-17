<script>
function filterByValue(array, string) {
    return array.filter(o =>
        Object.keys(o).some(k => o[k]?.toString().toLowerCase().includes(string.toLowerCase())));
}
export default {
    data() {
        return {
            search: "",
            items: []
        }
    },
    async mounted() {
        this.items = await (await fetch("/api/spectacles")).json();
    },
    computed: {
        getItems() {
            return this.search ?
                filterByValue(this.items, this.search) : 
                this.items
        }
    },
    methods: {
    }
}
</script>

<template>
    <div class="container flex flex-col justify-start items-stretch">
        <label class="input input-bordered flex items-center gap-2">
            <input v-model="search"  type="text" class="grow" placeholder="Search" />
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" fill="currentColor" class="w-4 h-4 opacity-70"><path fill-rule="evenodd" d="M9.965 11.026a5 5 0 1 1 1.06-1.06l2.755 2.754a.75.75 0 1 1-1.06 1.06l-2.755-2.754ZM10.5 7a3.5 3.5 0 1 1-7 0 3.5 3.5 0 0 1 7 0Z" clip-rule="evenodd" /></svg>
        </label>
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
                </tr>
                </thead>
                <tbody>
                <!-- row 1 -->
                <tr v-for="(item,i) in getItems">
                    <th>{{i+1}}</th>
                    <td>{{item.spectacleCode}}</td>
                    <td>{{item.spectacleType}}</td>
                    <td>{{item.spectacleBrand}}</td>
                    <td>{{item.price}}</td>
                    <td>{{item.stock}}</td>
                    <td>{{item.distributor}}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>