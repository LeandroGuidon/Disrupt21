<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section>
		<form action="update" method="post">
			<fieldset>
				<legend>Atualização de Dados Cadastrais</legend>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="idNm">Nome</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="txtNm" id="idNm" placeholder="Digite seu nome"
						 required="required" value="${objPersonagem.nome}">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-10 col-sm-10">
						<button type="submit" class="btn btn-info btn-lg">Atualizar</button>	
					</div>
				</div>
				
			</fieldset>
		</form>
	</section>

</body>
</html>