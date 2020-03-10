<template>
    <v-container fluid class="fill-height">
        <v-row align="center" justify="center">
            <v-col cols="12" sm="8" md="4">
                <v-card class="elevation-12">
                    <v-toolbar color="primary" dark flat>
                        <v-toolbar-title>Cadastro de Curso</v-toolbar-title>
                    </v-toolbar>
                    <v-form @submit.prevent="onSubmit" ref="form" lazy-validation v-model="valid">
                        <v-card-text>
                            <p class="error--text text-center">{{error}}</p>
                            <v-text-field label="Nome" name="nome" prepend-icon="school" type="text" v-model="nome"
                                          required/>
                            <v-text-field label="Turno" name="turno" prepend-icon="timer" type="text" v-model="turno"
                                          required/>
                            <v-text-field label="Sigla" name="sigla" prepend-icon="brightness_auto" type="text"
                                          v-model="sigla" required/>
                        </v-card-text>
                        <v-card-actions>
                            <v-btn color="error" type="reset" large>Cancelar</v-btn>
                            <v-spacer/>
                            <v-btn color="primary" type="submit" :loading="loading" large>Cadastrar</v-btn>
                        </v-card-actions>

                    </v-form>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
    import {mapGetters, mapState} from 'vuex'
    import cursoRepository from "../repositories/cursoRepository";

    export default {
        data: () => ({
            valid: true,
            loading: false,
            nome: '',
            turno: '',
            sigla: '',
            error: '',
            requiredRule: [
                v => !!v || 'Campo obrigatório'
            ],
        }),
        created() {

        },
        methods: {
            onSubmit() {
                this.loading = true
                if (this.$refs.form.validate()) {
                    let curso = {
                        nome: this.nome,
                        turno: this.turno,
                        sigla: this.sigla
                    }
                    cursoRepository.save(curso).then(() => {
                            this.$router.push('/mostrarcursos')
                        })
                }
                this.loading = false
            }
        },
        computed: {}
    };
</script>

<style scoped lang="css">

</style>
