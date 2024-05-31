<template>
    <v-card outlined>
        <v-card-title>
            CheckTransactionHistory
        </v-card-title>

        <v-card-text>
            <UUID offline label="AccountId" v-model="value.accountId" :editMode="editMode" @change="change"/>
            <Date label="StartDate" v-model="value.startDate" :editMode="editMode"/>
            <Date label="EndDate" v-model="value.endDate" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="checkTransactionHistory"
            >
                CheckTransactionHistory
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
        name: 'CheckTransactionHistoryCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.accountId = {};
            this.value.startDate = '2024-05-31';
            this.value.endDate = '2024-05-31';
        },
        watch: {
        },
        methods: {
            checkTransactionHistory() {
                this.$emit('checkTransactionHistory', this.value);
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

