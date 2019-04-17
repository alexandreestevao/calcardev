// Code goes here
var myApp = angular.module('myApp', []);
myApp.controller('clienteController', ['$scope', '$http', function($scope, $http) {
	
	getClientes();

  function getClientes(){
	  
	  //Buttons Settings
	  $scope.submit = true;
	  $scope.update = false;
	  $scope.cancel = false;
	  $scope.clienteid = true;	  
	  
	  //Retorna uma lista de clientes
	  //$http GET function
	  $http({
		  
	    method: 'GET',
	    url: 'http://localhost:8080/api/cliente/all'

	  }).then(function successCallback(response) {
	    $scope.clientes = response.data;

	  }, function errorCallback(response) {
	    alert("Erro. Favor tentar novamente!");

	  });
  }



  //Criar um novo cliente
  $scope.criarCliente = function() {
	  
    //$http POST function
    $http({
    	
      method: 'POST',
      url: 'http://localhost:8080/api/cliente',
      data: $scope.cliente      

    }).then(function successCallback(response) {
      $scope.clientes.push(response.data);
      alert("Dados Enviados com Sucesso!")
      

    }, function errorCallback(response) {
      alert("Erro na tentativa de criar um cliente. Favor tentar novamente!");

    }); 
    

  };


  //Alterar Cliente
  $scope.alterarCliente = function() {
	  
	 //$http POST function
	    $http({
	    	
	      method: 'POST',
	      url: 'http://localhost:8080/api/cliente',
	      data: $scope.cliente      

	    }).then(function successCallback(response) {
	      $scope.clientes.push(response.data);
	      alert("Cliente Alterado com Sucesso!")
	      

	    }, function errorCallback(response) {
	      alert("Erro na tentativa de criar um cliente. Favor tentar novamente!");

	    }); 

  };


  //Excluir Cliente
  $scope.excluirCliente = function(cliente) {
	  console.log(cliente);

	//$http DELETE function
    $http({

      method: 'DELETE',
      url: 'http://localhost:8080/api/cliente/' + cliente.id

    }).then(function successCallback(response) {
      alert("Cliente excluído com Sucesso!");
      getClientes();    
      var index = $scope.clientes.indexOf(cliente);
      $scope.clientes.splice(index, 1);

    }, function errorCallback(response) {
        getClientes();    
      alert("Cliente excluído com Sucesso!");

    });
    


  };

  //Set $scope on Edit button click
  $scope.alterarCliente = function(cliente) {

    $scope.cliente = cliente;
    $scope.submit = false;
    $scope.update = true;
    $scope.cancel = true;
    $scope.clienteid = false;

  };


  //Cancelar Alteracao
  $scope.cancelarAlteracao = function() {
    $scope.cliente = null;
    $scope.submit = true;
    $scope.update = false;
    $scope.cancel = false;
    $scope.clienteid = true;
  };
 


}]);