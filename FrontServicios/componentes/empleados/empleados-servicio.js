// mi componente - servicio
'use strict';
app.factory("empleadosServicio", ['$http', '$q', 'urls', function($http, $q, urls) {
    return {
        obtieneLista: function() {
            return $http({
                url: urls.servidor + 'prestadores',
                method: "GET",
            }).then(function(response) {
                return response.data;
            }, function(response) {
                return $q.reject(response);
            });
        },
        reguistrar: function(usuario) {
            return $http({
                url: urls.servidor + 'prestadores',
                method: "POST",
                data: ('{"nombre":"' + usuario.nombre + '","tipo":"' + usuario.tipo + '"}'),
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