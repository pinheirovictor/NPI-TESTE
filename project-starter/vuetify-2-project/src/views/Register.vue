<template>
    <v-container fluid class="fill-height">
        <v-row align="center" justify="center">
            <v-col cols="12" sm="8" md="4" >
                <v-card class="elevation-12">
                    <v-toolbar color="primary" dark flat>
                        <v-toolbar-title>Cadastro</v-toolbar-title>
                    </v-toolbar>
                    <v-form @submit.prevent="onSubmit" ref="form" lazy-validation v-model="valid">
                        <v-card-text>
                            <p class="error--text text-center">{{error}}</p>
                            <v-text-field label="Nome" name="nome" prepend-icon="person" type="text" v-model="nome" required />
                            <v-text-field label="Email" name="email" prepend-icon="email" type="text" v-model="email" required />
                            <v-text-field id="password" label="Senha" name="password" prepend-icon="lock" type="password" v-model="password" required />
                            <v-switch v-model="habilitado" class="ma-4" label="Habilitado"></v-switch>
                        </v-card-text>
                        <v-card-actions>
                            <v-btn color="error" type="reset" large>Cancelar</v-btn>
                                <v-spacer /><v-btn color="primary" :loading="loading" type="submit" large>Cadastrar-se</v-btn>
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
        data: () => ({
            valid: true,
            loading: false,
            nome:'',
            email: '',
            password: '',
            habilitado: false,
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
                    usuarioRepository.save(usuario).then(() => {
                            this.$router.push('/home')
                    })
                }
                this.loading = false
            }
        }
    };
</script>

<style scoped lang="css">

</style>
