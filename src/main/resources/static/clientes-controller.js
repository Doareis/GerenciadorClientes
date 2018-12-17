angular.module("clientes").controller("ClientesController", function($scope, $http) {

    $scope.clientes = [];
    $scope.cliente = {
        nome: "",
        limiteCredito: 0,
        risco: ""
    };

    carregaClientes();

    function carregaClientes() {
        $http.get('cliente/lista')
            .then(
                function(res) {
                    $scope.clientes = res.data;
                }, error);
    }

    $scope.adicionaCliente = function() {
        $http.post('cliente/adiciona', $scope.cliente).then(success, error);
    }

    $scope.removeCliente = function(idCliente) {
        $http.delete('cliente/remove/' + idCliente).then(success, error);
    }

    function success(res) {
         carregaClientes();
         limpaFormulario();
     }

     function limpaFormulario() {
        $scope.cliente.nome = '';
        $scope.cliente.limiteCredito = '';
        $scope.cliente.risco = '';
     }

     function error(res) {
          var mensagem = "Error: " + res.status + " (" + res.data.message + ")";
          console.log(mensagem);
      }
});

angular.module("clientes").directive('somenteNumeros', function(){
    return {
        require: 'ngModel',
        link: function(scope, element, attrs, modelCtrl) {

            modelCtrl.$parsers.push(function (valor) {
                var novoValor = valor ? valor.replace(/[^\d.-]/g,'') : null;

                if (novoValor != valor) {
                    modelCtrl.$setViewValue(novoValor);
                    modelCtrl.$render();
                }

                return novoValor;
            });
        }
    };
});

angular.module("clientes").filter('porcentagem', ['$filter', function ($filter) {
  return function (input, decimais) {
    return $filter('number')(input * 100, decimais) + '%';
  };
}]);