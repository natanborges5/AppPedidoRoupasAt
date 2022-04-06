package br.at.natan.AppPedidoRoupas.Model.Service;

import br.at.natan.AppPedidoRoupas.Model.Domain.Roupas;
import br.at.natan.AppPedidoRoupas.Model.Repository.RoupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class RoupaService {
    @Autowired
    private RoupaRepository roupaRepository;
    public Collection<Roupas> obterLista() {return (Collection<Roupas>) roupaRepository.findAll(Sort.by(Sort.Direction.ASC,"descricao")); }

}
