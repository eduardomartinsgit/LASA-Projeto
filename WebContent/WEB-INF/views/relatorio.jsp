<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html ng-app="projetoApp">
	<head>
		<meta charset="UTF-8">
		<title>Projeto TO Brasil - Eduardo Martins</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>	
		<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.17/angular.min.js"></script>
	</head>
	<script type="text/javascript">
	
		var projetoApp = angular.module("projetoApp", []);
		projetoApp.controller("relatorioController", function($scope, $http) {
	
			$http.get("rest/relatorio/obterVendas")
		    	.then(function(response) {
		    		$scope.vendas = response.data;
		    });
			
		});
		
	</script>
	<body ng-controller="relatorioController">
	
		<div class="jumbotron">
		    <div class="container">
		        <h1>LASA-Projeto</h1>
		        <p>Página com um mini relatório das vendas e de seu processamento.</p>
		    </div>
		</div>
		<div class="container table-responsive" >
			<div class="form-group row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">Informações do Item: </label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputPassword" ng-model="searchKeyword">
			    </div>
			</div>
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th scope="col">id_venda</th>
			      <th scope="col">Data</th>
			      <th scope="col">Loja</th>
			      <th scope="col">Pdv</th>
			      <th scope="col">id_item_venda</th>
			      <th scope="col">Produto</th>
			      <th scope="col">Preço Unitário</th>
			      <th scope="col">Desconto</th>
			      <th scope="col">Status</th>
			    </tr>
			  </thead>
			  <tbody ng-repeat="venda in vendas| orderBy:'+id_venda'  ">
				    <tr ng-repeat="item in venda.itens | filter: searchKeyword ">
				      <th scope="row">{{venda.id_venda }}</th>
				      <td>{{venda.data }}</td>
				      <td>{{venda.loja }}</td>
				      <td>{{venda.pdv }}</td>
				      <td>{{item.id_item_venda }}</td>
				      <td>{{item.produto }}</td>
				      <td>{{item.preco_unitario }}</td>
				      <td>{{item.desconto }}</td>
				      <td>{{venda.status }}</td>
				    </tr>
			  </tbody>
			</table>
		</div>

	
	</body>
</html>
