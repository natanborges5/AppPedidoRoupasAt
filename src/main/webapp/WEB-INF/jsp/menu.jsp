<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="/">Netclothes</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/">Home</a></li>
                        <c:if test="${empty user}">
                            <li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
                            <li class="nav-item"><a class="nav-link" href="/usuario/cadastro">Cadastro</a></li>
                        </c:if>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Produtos</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="/roupas">Roupas</a></li>
                                <li><a class="dropdown-item" href="/calcados">Calcados</a></li>
                                <li><a class="dropdown-item" href="/acessorios">Acessorios</a></li>
                            </ul>
                        </li>
                        <c:if test="${not empty user}">
                            <li class="nav-item"><a class="nav-link" href="/usuario/perfil">${user.email}</a></li>
                            <li class="nav-item"><a class="nav-link" href="/usuarios">Usuarios</a></li>
                            <li class="nav-item"><a class="nav-link" href="/logout">Sair</a></li>
                        </c:if>
                    </ul>
                    <c:if test="${not empty user}">
                        <form class="d-flex" action="/carrinho">
                            <button class="btn btn-outline-dark" type="submit">
                                <i class="bi-cart-fill me-1"></i>
                                Carrinho
                                <span class="badge bg-dark text-white ms-1 rounded-pill">${user.pedidos.size()}</span>
                            </button>
                        </form>
                    </c:if>
                </div>
            </div>
        </nav>