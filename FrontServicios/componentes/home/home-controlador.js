// mi componente - controlador
app.controller("homeComponent", ['$scope', 'homeService', function($scope, miComponenteServicio) {
    var promise = miComponenteServicio.obtieneLista();
    promise.then(function(data) {
        $scope.info = data.entradas;
    }, function(error) {
        $scope.loading = false;
    });

}]);