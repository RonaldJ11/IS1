// mi componente - controlador
app.controller("clientesController", ['$scope', 'clientesServicio', function($scope, clientesServicio) {
    var promise = clientesServicio.obtieneLista();


    promise.then(function(data) {
        console.log(data);
        $scope.info = data;
    }, function(error) {
        console.log(error);
        $scope.loading = false;
    });

    $scope.registrar = function() {
        $scope.loading = true;
        var promise = clientesServicio.registrar($scope.usuario);
        promise.then(function(data) {
            console.log(data);
            location.reload()
                // $scope.loading = false;
        }, function(error) {
            console.log(error);
        });
    }


    $scope.registrarDireccion = function() {
        $scope.loading = true;
        var promise = clientesServicio.registrarDireccion($scope.direccion);
        promise.then(function(data) {
            console.log(data);
            location.reload()
                // $scope.loading = false;
        }, function(error) {
            console.log(error);
        });
    }


    $scope.listaServicio = function(index, content) {
        if (index != -1) {
            $scope.servicios = $scope.info[index].servicios
            $scope.idList = content

            console.log($scope.servicios);
        }
    }
}]);