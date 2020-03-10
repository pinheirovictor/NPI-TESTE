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
                                :items="cursos"
                                :items-per-page="5"
                                class="elevation-1"
                        >
                            <template v-slot:item.editar="{ item }">
                                <v-icon>edit</v-icon>
                            </template>

                            <template v-slot:item.deletar="{ item }">
                                <v-icon>delete</v-icon>
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
    const cursoRepo = RepositoryFactory.get("curso");

    export default {
        name: 'mostrarcursos',
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
                    text: 'Turno',
                    value: 'turno'
                },
                {
                    text: 'Sigla',
                    value: 'sigla'
                },
                {
                    text: 'Editar',
                    value: 'editar'
                },
                {
                    text: 'Deletar',
                    value: 'deletar'
                }
            ],
            cursos :[

            ]
        }),

        created() {
            cursoRepo.getAll().then(res => {
                this.cursos = res.data;
            }).catch(console.error);
        },

        computed: {

        },

        methods: {

        }
    }
</script>
