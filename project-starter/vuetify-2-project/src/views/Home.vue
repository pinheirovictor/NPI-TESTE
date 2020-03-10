<template>
    <div>
        <v-card-widget enableActions :title="'Página Inicial'">
            <div slot="widget-header-action">

            </div>
            <div slot="widget-content">
                <v-row>
                    <v-col cols="12">
                        <v-data-table
                                :headers="headers"
                                :items="usuarios"
                                :items-per-page="5"
                                class="elevation-1"
                        >
                            <template v-slot:item.habilitado="{ item }">
                                <v-switch value v-model="item.habilitado" disabled></v-switch>
                            </template>

                            <template v-slot:item.atualizar="{ item }">
                                <v-icon @click="atualizar()">edit</v-icon>
                            </template>

                            <template v-slot:item.deletar="{ item }">
                                <v-icon @click="deletar(item.id)">delete</v-icon>
                            </template>

                        </v-data-table>
                    </v-col>
                </v-row>
            </div>
        </v-card-widget>
    </div>
</template>

<script>
    // @ is an alias to /src
    import VCardWidget from "@/components/VWidget";
    import {RepositoryFactory} from "@/repositories/RepositoryFactory";

    const usuarioRepo = RepositoryFactory.get("usuario");

    export default {
        name: 'home',
        components: {
            VCardWidget
        },

        data: () => ({
            headers: [
                {
                    text: 'Nome',
                    align: 'left',
                    value: 'nome',
                },
                {
                    text: 'Email',
                    value: 'email'
                },
                {
                    text: 'Habilitado',
                    value: 'habilitado'
                },
                {
                    text: 'Editar',
                    value: 'atualizar'
                },
                {
                    text: 'Deletar',
                    value: 'deletar'
                }
            ],
            usuarios: []
        }),

        created() {
            usuarioRepo.getAll().then(res => {
                this.usuarios = res.data;
            }).catch(console.error);
        },

        computed: {},

        methods: {
            atualizar(usuario) {
                this.$router.push('/register')
            },

            deletar(id) {
                usuarioRepo.deletar(id).then(res => {
                    window.location.reload()
                }).catch(console.error);
            }

        }
    }
</script>
