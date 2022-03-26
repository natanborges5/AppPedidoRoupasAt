<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	  <title>Login</title>
	</head>
	<body>
	<section class="intro">
      <div class="bg-image h-100">
        <div class="mask d-flex align-items-center h-100" style="background-color: #f3f2f2;">
          <div class="container">
            <div class="row d-flex justify-content-center align-items-center">
              <div class="col-12 col-lg-9 col-xl-8">
                <div class="card" style="border-radius: 1rem;">
                  <div class="row g-0">
                    <div class="col-md-4 d-none d-md-block">
                      <img
                        src="https://mdbootstrap.com/img/Photos/Others/sidenav2.jpg"
                        alt="login form"
                        class="img-fluid" style="border-top-left-radius: 1rem; border-bottom-left-radius: 1rem;"
                      />
                    </div>
                    <div class="col-md-8 d-flex align-items-center">
                      <div class="card-body py-5 px-4 p-md-5">

                        <form action="/login" method="post">
                          <h3 class="fw-bold mb-4" style="color: #92aad0;">Entre na sua conta</h3>
                          <h5 class="mb-4" style="color: #FF2D00;">${mensagem}</h5>
                          <p class="mb-4" style="color: #45526e;">Para entrar na sua conta preencha todos os campos.</p>

                          <div class="form-outline mb-4">
                            <label class="form-label" for="form2Example1">Email</label>
                            <input type="email" id="email" class="form-control" name="email" value="natan@gmail.com" />
                          </div>

                          <div class="form-outline mb-4">
                            <label class="form-label" for="form2Example2">Senha</label>
                            <input type="password" id="senha" class="form-control" name="senha" />
                          </div>

                          <div class="d-flex justify-content-end pt-1 mb-4">
                            <button class="btn btn-primary btn-rounded" type="submit" style="background-color: #92aad0;">Login</button>
                          </div>
                          <hr>
                          <a class="link float-end" href="/usuario">Não possui conta? Crie aqui.</a>
                        </form>

                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
	</body>
</html>
