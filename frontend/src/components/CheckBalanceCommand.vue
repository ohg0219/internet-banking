<template>
    <v-card outlined>
        <v-card-title>
            CheckBalance
        </v-card-title>

        <v-card-text>
            <UUID offline label="AccountId" v-model="value.accountId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="checkBalance"
            >
                CheckBalance
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
        name: 'CheckBalanceCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.accountId = {};
        },
        watch: {
        },
        methods: {
            checkBalance() {
                this.$emit('checkBalance', this.value);
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

