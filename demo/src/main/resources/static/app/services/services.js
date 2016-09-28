'use strict';
angular.module('myApp.services', ['ngRoute', 'ngResource'])

        /*.factory('fabrica', function () {
         var data = {
         listado: []
         };
         return {
         getListado: function () {
         return data.listado;
         },
         addTodo: function (todo) {
         data.listado.push(todo);
         }};
         });*/
        .factory('Post', function ($resource) {
            return $resource('/tiendas');
        })

        .factory('PostServicio', function ($resource) {
            console.info("Entro en la PostServicio");
            return $resource('/tiendas/:nombreTienda/servicio', {nombreTienda: "@nombreTienda"});
            
        })

        .factory('GetServices', function ($resource) {
            return $resource('/tiendas/:nombreTienda/servicios', {nombreTienda: "@nombreTienda"},
                    {get: {method: 'GET', isArray: true}});
        })

        .factory('GetHorarioService', function ($resource) {
            return $resource('/tiendas/:nombreTienda/servicios/:servicio/horarios', {nombreTienda: "@nombreTienda", servicio: "@servicio"},
                    {get: {method: 'GET', isArray: true}});
        })

        .factory('Delete', function ($resource) {
            console.info("Entro en la factory");
            return $resource('/tiendas/:id', {id: '@id'},
                    {delete: {method: 'DELETE'}});
        })

        .factory('Get', function ($resource) {
            return $resource('/tiendas', {},
                    {get: {method: 'GET', isArray: true}});
        })

        .factory('GetUser', function ($resource) {
            return $resource('/users', {},
                    {get: {method: 'GET', isArray: true}});
        })

        .factory('PostUser', function ($resource) {
            return $resource('/users');
        })


        ;


