// mi componente - controlador
app.controller("empleadoController", ['$scope', 'empleadosServicio', function($scope, empleadosServicio) {
    var promise = empleadosServicio.obtieneLista();


    promise.then(function(data) {
        console.log(data);
        $scope.info = data;
    }, function(error) {
        console.log(error);
        $scope.loading = false;
    });

    $scope.reguistrar = function() {
        $scope.loading = true;
        var promise = empleadosServicio.reguistrar($scope.usuario);
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