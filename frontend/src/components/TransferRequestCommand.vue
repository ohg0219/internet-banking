<template>
    <v-card outlined>
        <v-card-title>
            TransferRequest
        </v-card-title>

        <v-card-text>
            <UUID offline label="FromAccountId" v-model="value.fromAccountId" :editMode="editMode" @change="change"/>
            <UUID offline label="ToAccountId" v-model="value.toAccountId" :editMode="editMode" @change="change"/>
            <Money offline label="Amount" v-model="value.amount" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="transferRequest"
            >
                TransferRequest
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'TransferRequestCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.fromAccountId = {};
            this.value.toAccountId = {};
            this.value.amount = {};
        },
        watch: {
        },
        methods: {
            transferRequest() {
                this.$emit('transferRequest', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

