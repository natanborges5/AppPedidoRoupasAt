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
        <!-- Navigation-->
        <c:import url="/WEB-INF/jsp/menu.jsp"/>
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <c:if test="${not empty produtoLista}">
                            <div class="col-md-6">
                                <img class="card-img-top mb-5 mb-md-0" src=${produtoLista.imgProduto}/>
                            </div>
                            <div class="col-md-6">
                                <h5 class="mb-4" style="color: #FF2D00;">${mensagem}</h5>
                                <div class="medium mb-1">Marca: ${produtoLista.marca}</div>
                                <h1 class="display-5 fw-bolder">${produtoLista.modelo}</h1>
                                <div class="fs-5 mb-5">
                                    <span>$${produtoLista.valor}</span>
                                </div>
                                <p class="lead">Descricao: ${produtoLista.descricao}</p>
                                <p class="lead">Cor: ${produtoLista.cor}</p>
                                <p class="lead">Tamanho: ${produtoLista.tamanho}</p>
                                <p class="lead">Material: ${produtoLista.material}</p>
                                <p class="lead">Peso: ${produtoLista.peso}</p>
                                <c:if test="${empty user}">
                                    <div class="d-flex">
                                        <form action="/login" method="get">
                                            <button class="btn btn-outline-dark flex-shrink-0" type="submit">
                                                <i class="bi-cart-fill me-1"></i>
                                                Entre na sua conta para comprar
                                            </button>
                                        </form>
                                    </div>
                                </c:if>
                                <c:if test="${not empty user}">
                                    <div class="d-flex">
                                        <form action="/produto/${produtoLista.id}/adicionar" method="post">
                                            <button class="btn btn-outline-dark flex-shrink-0" type="submit">
                                                <i class="bi-cart-fill me-1"></i>
                                                Adicionar ao carrinho
                                            </button>
                                        </form>
                                        <c:if test="${user.admin == true}">
                                            <form action="/produto/${produtoLista.id}/excluir" method="get">
                                                <button class="btn btn-outline-dark flex-shrink-0" type="submit">
                                                    <i class="bi-cart-fill me-1"></i>
                                                    Remover Produto
                                                </button>
                                            </form>
                                        </c:if>
                                    </div>
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
