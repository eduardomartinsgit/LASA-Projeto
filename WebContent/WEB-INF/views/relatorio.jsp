<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Projeto TO Brasil - Eduardo Martins</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
		
	</head>
	<body>
		<div class="container table-responsive" >
			<form class="form-inline">
			  <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Selecione um filtro</label>
			  <select class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
			    <option selected>Choose...</option>
			    <option value="1">One</option>
			    <option value="2">Two</option>
			    <option value="3">Three</option>
			  </select>
			
			  <button type="submit" class="btn btn-primary my-1">Confirmar</button>
			</form>		
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
			  <tbody>
			        <c:forEach var="venda" items="${listaVendas }" >
			        	<c:forEach var="item" items="${venda.itens }" >
						    <tr>
						      <th scope="row">${venda.id_venda }</th>
						      <td>${venda.data }</td>
						      <td>${venda.loja }</td>
						      <td>${venda.pdv }</td>
						      <td>${item.id_item_venda }</td>
						      <td>${item.produto }</td>
						      <td>${item.preco_unitario }</td>
						      <td>${item.desconto }</td>
						      <td>${venda.status }</td>
						    </tr>
			        	</c:forEach>
      				</c:forEach>
			  </tbody>
			</table>
		</div>

	
	</body>
</html>
