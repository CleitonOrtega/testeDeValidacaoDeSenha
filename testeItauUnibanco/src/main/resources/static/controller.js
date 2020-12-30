var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {
	
	$scope.cadastro = new Object();
	
$scope.salvar = function(){
	$http.post("http://localhost:8080/usuario", {
		'nome': $scope.nome,
		'senha': $scope.senha
	}).then(resposta => {
		Swal.fire('Criado com sucesso!','Cliente cadastrado!','success')
	}).catch(erro => {
		Swal.fire('Não Autorizado!', 'Atenção algo deu errado! o nome esta nulo ou a senha é invalida!Modelo de senha: AbTp9!fok (Não pode ter caracteres repetidos, Ao menos 1 Maiuscula,Ao menos 1 Minuscula,Ao menos 1 numero,Ao menos 1 caractere especial: !@#$%^&*()-+)','error')
	})
};
});