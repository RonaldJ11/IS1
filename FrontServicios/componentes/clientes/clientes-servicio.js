// mi componente - servicio
'use strict';
app.factory("clientesServicio", ['$http', '$q', 'urls', function($http, $q, urls) {
    return {
        obtieneLista: function() {
            return $http({
                url: urls.servidor + 'clientes',
                method: "GET",
            }).then(function(response) {
                return response.data;
            }, function(response) {
                return $q.reject(response);
            });
        },
        registrar: function(usuario) {
            return $http({
                url: urls.servidor + 'clientes',
                method: "POST",
                data: ('{"nombres":"' + usuario.nombres + '"}'),
                headers: { 'Content-Type': 'application/json' }
            }).success(function(data) {
                mensajesFlash.clear();
                obtieneLista();
            }).error(function(data, status) {
                if (status == 400) {
                    mensajesFlash.show(data.mensaje, "danger");
                }
            })
        },

        registrarDireccion: function(direcciones) {
            return $http({
                url: urls.servidor + 'lugares',
                method: "POST",
                data: ('{"FK_cli_list":"' + JSON.stringify(direcciones.FK_cli_list) + '","tipo_lugar":"' + direcciones.tipo_lugar + '","direccion":"' + direcciones.direccion + '"}'),
                headers: { 'Content-Type': 'application/json' }
            }).success(function(data) {
                mensajesFlash.clear();
                obtieneLista();
            }).error(function(data, status) {
                if (status == 400) {
                    mensajesFlash.show(data.mensaje, "danger");
                }
            })
        }

    }

}]);