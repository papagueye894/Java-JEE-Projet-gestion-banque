<%@page import="web.CreditModel"%>
<% 
	CreditModel model=(CreditModel)request.getAttribute("creditModel");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Credit bancaire</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">Simulation du credit</div>
			<div class="panel-body">
				<form action="calculMensualite.do" method="post">
					<div class="form-group">
						<label class="control-label">Montant</label>
						<input class="form-control" type="text" name="montant" value="<%=model.getMontant()  %>" />
					</div>
					<div class="form-group">
						<label class="control-label">Taux</label>
						<input class="form-control" type="text" name="taux" value="<%=model.getTaux()  %>" />
					</div>
					<div class="form-group">
						<label class="control-label">Duree</label>
						<input class="form-control" type="text" name="duree" value="<%=model.getDuree()  %>" />
					</div> <br>
					<button type="submit" class="btn btn-danger">Calculer</button>
				</form>
			</div>
			<div>
				<label>Mensualite:</label>
				<label><%=model.getMensualite()%>	</label>
			</div>
		</div>
	</div>  
	<p></p>
</body>
</html>