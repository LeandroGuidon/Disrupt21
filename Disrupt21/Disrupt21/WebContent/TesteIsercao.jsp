<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="Cadastrar" method="POST">
			<fieldset>
				<legend>Parâmetros</legend>
				<div>
					<label>Nome</label><br/>
					<input type="text" name="txtNm">
					<p>${param.msgStatus3}</p>
				</div>
				<div>
					<label>Ano</label><br/>
					<input type="number" name="txtAno">
					<p>${param.msgStatus2}</p>
				</div>
				<div>
					<label>Tipo</label><br/>
					<input type="number" name="txtTipo">
					<p>${param.msgStatus5}</p>
				</div>
				<div>
					<label>Missao</label><br/>
					<input type="text" name="txtMissao">
					<p>${param.msgStatus4}</p>
				</div>
				<div>
					<p>${param.msgStatus}</p>
					<button type="submit">Enviar</button>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>