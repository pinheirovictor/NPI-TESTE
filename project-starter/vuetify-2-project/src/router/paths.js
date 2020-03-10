import store from '../store'
import LoginPage from '../views/Login'
import Home from '../views/Home'
import Register from "../views/Register";
import CursoRegister from "../views/CursoRegister";
import AlunoRegister from "../views/AlunoRegister";
import MostrarCursos from "../views/MostrarCursos";

export default [


    /* Geral */
    {
        path: '/home',
        name: 'Home',
        component: Home
    },
    {
        path: '/register',
        name: 'Register',
        component: Register
    },
    {
        path: '/cursoregister',
        name: 'CursoRegister',
        component: CursoRegister
    },
    {
        path: '/alunoregister',
        name: 'AlunoRegister',
        component: AlunoRegister
    },
    {
        path: '/mostrarcursos',
        name: 'MostrarCursos',
        component: MostrarCursos
    },

    {
        path: '/login',
        meta: {
            public: true,
        },
        props: true,
        name: 'Login',
        component: LoginPage
    },


    {
        path: '/logout',
        meta: { breadcrumb: true },
        name: 'Logout',
        beforeEnter (to, from, next) {
            store.dispatch('auth/login', false)
        },
        redirected: 'auth/login'
    },

];
