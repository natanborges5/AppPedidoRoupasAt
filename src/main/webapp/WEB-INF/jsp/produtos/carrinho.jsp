<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Netclothes</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/menu.jsp"/>
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <c:if test="${not empty user and not empty produtoLista}">
                        <a href="/limpar" class="btn btn-outline-primary">Limpar Carrinho</a>
                    </c:if>
                    <h5 class="mb-4" style="color: #FF2D00;">${mensagem}</h5>
                    <h1 class="display-4 fw-bolder">Todos os nossos produtos</h1>
                    <p class="lead fw-normal text-white-50 mb-0">De uma olhada nos nossos produtos</p>
                </div>
            </div>
        </header>
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <c:if test="${not empty produtoLista}">
                    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                        <c:forEach var="e" items="${produtoLista}">
                            <div class="col mb-5">
                                <div class="card h-100">
                                    <!-- Product image-->
                                    <img class="card-img-top" src=${e.imgProduto} alt="Foto do produto "${e.marca} />
                                    <!-- Product details-->
                                    <div class="card-body p-4">
                                        <div class="text-center">
                                            <!-- Product name-->
                                            <h5 class="fw-bolder">${e.descricao}</h5>
                                            <p class="lead fw-normal text-black-50 mb-0">${e.marca}</p>
                                            <p class="lead fw-normal text-black-50 mb-0">${e.tamanho}</p>
                                            <!-- Product price-->
                                            $${e.valor}
                                        </div>
                                    </div>
                                    <!-- Product actions-->
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                        <div class="text-center">
                                            <a class="btn btn-outline-dark mt-auto" href="/produto/${e.id}">Ver detalhes</a>
                                        </div>
                                        <form action="/carrinho/${e.id}/excluir" method="get">
                                            <button class="btn btn-outline-dark flex-shrink-0" type="submit">
                                                <i class="bi-cart-fill me-1"></i>
                                                Remover do Carrinho
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
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
