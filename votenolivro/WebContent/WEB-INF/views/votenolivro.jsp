<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width">
<title>Vote no livro</title>
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/votenolivro.css">
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Vote no melhor livro</h1>
		</div>
	</div>
	<div class="container">
	<c:if test="${pagina <4}">
		<form class="form-group" action="votar?pagina=${pagina}" method="post">
	</c:if>
	<c:if test="${pagina >= 4}">
		<form class="form-group" action="finalizar" method="post">
	</c:if>
		<div class="row">
			<c:forEach items="${livros}" var="livro">
				<input name="id" type="hidden" value="${livro.id}"/>
				<div class="col-md-4">
					<nav class="navbar navbar-default">
						<ul class="list-group">
							<li class="list-group-item"><img
								src="resources/imagens/${livro.capa}" /></li>
							<li class="list-group-item">Titulo: "${livro.titulo}"</li>
							<li class="list-group-item">Autor: "${livro.autor}"</li>
							<li class="list-group-item"><input type="radio" name="voto" value="${livro.id}" checked /></li>
						</ul>
					</nav>
				</div>
				<!-- Fim .column -->
			</c:forEach>
			
				<div class="col-md-4">
					<input id="pagina" type="hidden" name="pagina" value="${pagina}">
					<c:if test="${pagina >= 4}">				
						<div class="form-group">
							<label for="nome">Nome completo</label> <input
								class="form-control" type="text" id="nome" name="nome" autofocus
								required>
						</div>
						<!-- Fim .form-group -->

						<div class="form-group">
							<label for="email">E-mail</label>
							<div class="input-group">
								<span class="input-group-addon">@</span> 
								<input class="form-control" type="email" id="email" name="email" autofocus required>
							</div>
							<!-- Fim .input-group -->
						</div>
						<!-- Fim .form-group -->
					</c:if>
					<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-thumbs-up"></span>
						<c:if test="${pagina >= 4}">
							Finalizar
						</c:if>
						<c:if test="${pagina < 4}">
							Votar
						</c:if>
					</button>
				</div>
				<!-- Fim .column -->
			
		</div>
		<!-- Fim .row -->
	</form>
	</div>
</body>
</html>