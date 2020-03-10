<template>
    <v-container fluid class="fill-height">
        <v-row align="center" justify="center">
            <v-col cols="12" sm="8" md="4" >
                <v-card class="elevation-12">
                    <v-toolbar color="primary" dark flat>
                        <v-toolbar-title>Cadastro de Curso</v-toolbar-title>
                    </v-toolbar>
                    <v-form @submit.prevent="onSubmit" ref="form" lazy-validation v-model="valid">
                        <v-card-text>
                            <p class="error--text text-center">{{error}}</p>
                            <v-text-field label="Matricula do Aluno" name="matAluno" prepend-icon="person" type="number" v-model="matAluno" required />
                            <v-text-field label="Matricula do Curso" name="matCurso" prepend-icon="school" type="text" v-model="matCurso" required />
                        </v-card-text>
                        <v-card-actions>
                            <v-btn color="error" type="reset" large>Cancelar</v-btn>
                            <v-spacer /><v-btn color="primary" type="submit" large>Cadastrar</v-btn>
                        </v-card-actions>

                    </v-form>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
    import { mapGetters, mapState } from 'vuex'
    import usuarioRepository from "../repositories/usuarioRepository";

    export default {
        props: ["to", "invalidToken"],
        data: () => ({
            valid: true,
            loading: false,
            email: '',
            password: '',
            error: '',
            requiredRule: [
                v => !!v || 'Campo obrigatório'
            ],
        }),
        created() {
            if (this.invalidToken) {
                this.error = 'Sua sessão expirou. Faça login novamente'
            }
        },
        methods: {
            onSubmit () {
                this.loading = true
                if (this.$refs.form.validate()) {
                    let usuario = {
                        nome: this.nome,
                        email: this.email,
                        password: this.password,
                        habilitado: this.habilitado
                    }
                    usuarioRepository.save(usuario)
                        .then(() => {
                            this.$router.push('/home')
                        })
                }
                this.loading = false
            }
        },
        computed: {
            ...mapState({
                token: state => state.auth.token
            })
        }
    };
</script>

<style scoped lang="css">

</style>
