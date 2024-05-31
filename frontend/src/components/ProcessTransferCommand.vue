<template>
    <v-card outlined>
        <v-card-title>
            ProcessTransfer
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
                    @click="processTransfer"
            >
                ProcessTransfer
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
        name: 'ProcessTransferCommand',
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
            processTransfer() {
                this.$emit('processTransfer', this.value);
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

