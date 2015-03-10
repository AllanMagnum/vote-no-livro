<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width">
<title>Ranking de livros</title>
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/votenolivro.css">
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Ranking de livros</h1>
		</div>
	</div>

	<c:forEach items="${rankings}" var="ranking">
	<div class="container">
		<label for="livro">${ranking.livro}</label>
		<div id="livro" class="progress">
			<label for="qtde">  ${ranking.quantidade} votos</label>
			<div id="qtde" class="progress-bar progress-bar-success" role="progressbar"
				aria-valuenow="${ranking.quantidade}" aria-valuemin="0" aria-valuemax="${total}"
				style="width: ${ranking.quantidade}%">
				<span class="sr-only">ranking.quantidade% Complete (success)</span>
			</div>
		</div>
	</div>
	</c:forEach>
</body>
</html>