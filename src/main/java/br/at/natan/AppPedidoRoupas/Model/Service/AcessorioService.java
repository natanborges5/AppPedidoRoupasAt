package br.at.natan.AppPedidoRoupas.Model.Service;

import br.at.natan.AppPedidoRoupas.Model.Domain.Acessorios;
import br.at.natan.AppPedidoRoupas.Model.Repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AcessorioService {
    @Autowired
    private AcessorioRepository acessorioRepository;
    public Collection<Acessorios> obterLista() {return (Collection<Acessorios>) acessorioRepository.findAll(Sort.by(Sort.Direction.ASC,"descricao")); }
}
