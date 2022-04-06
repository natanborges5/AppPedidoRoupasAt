<!DOCTYPE html>
<html lang="pt-br">
<head>
	<title>VenturaHR Cadastro</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="/formreg/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/formreg/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/formreg/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/formreg/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/formreg/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/formreg/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/formreg/css/util.css">
	<link rel="stylesheet" type="text/css" href="/formreg/css/main.css">
<!--===============================================================================================-->
</head>
<body>

	<div class="bg-contact3" style="background-image: url('/formreg/images/bg-01.jpg');">
		<div class="container-contact3">
			<div class="wrap-contact3">
				<form action="/login" method="post" class="contact3-form validate-form">
					<span class="contact3-form-title">
						Login Netclothes
					</span>
					<h5 class="mb-4" style="color: #FF2D00;">${mensagem}</h5>

					<div class="wrap-input3 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input3" type="email" name="email" placeholder="Email" required>
						<span class="focus-input3"></span>
					</div>
					<div class="wrap-input3 validate-input" data-validate="Senha is required">
                        <input class="input3" type="password" name="senha" placeholder="Senha" required>
                        <span class="focus-input3"></span>
                    </div>
					<div class="container-contact3-form-btn">
						<button class="contact3-form-btn">
							Login
						</button>
						<a class="link float-end" href="/usuario/cadastro">Nao possui conta? Aperte aqui.</a>
					</div>
				</form>
			</div>
		</div>
	</div>


	<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
	<script src="/formreg/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="/formreg/vendor/bootstrap/js/popper.js"></script>
	<script src="/formreg/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="/formreg/vendor/select2/select2.min.js"></script>
	<script>
		$(".selection-2").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect1')
		});
	</script>
<!--===============================================================================================-->
	<script src="/formreg/js/main.js"></script>

	<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-23581568-13');
</script>

</body>
</html>
