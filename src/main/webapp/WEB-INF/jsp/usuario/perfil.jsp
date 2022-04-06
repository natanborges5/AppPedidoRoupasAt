<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Netclothes Perfil</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Navigation-->
        <c:import url="/WEB-INF/jsp/menu.jsp"/>
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <h1 class="display-5 fw-bolder">Seu Perfil na NetClothes</h1>
                    <c:if test="${not empty user}">
                            <div class="col-md-6">
                                <h5 class="mb-4" style="color: #FF2D00;">${mensagem}</h5>
                                <p class="lead">Email: ${user.email}</p>
                                <p class="lead">Nome: ${user.nome}</p>
                                <p class="lead">Nome: ${user.telefone}</p>
                                <c:if test="${user.admin == true}">
                                    <p class="lead">Conta: Administrador</p>
                                </c:if>
                                <c:if test="${user.admin == false}">
                                    <p class="lead">Conta: Cliente</p>
                                </c:if>
                            </div>
                    </c:if>
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="/js/scripts.js"></script>
    </body>
</html>
