package br.at.natan.AppPedidoRoupas.Model.Service;

import br.at.natan.AppPedidoRoupas.Model.Domain.Acessorios;
import br.at.natan.AppPedidoRoupas.Model.Domain.Calcados;
import br.at.natan.AppPedidoRoupas.Model.Repository.AcessorioRepository;
import br.at.natan.AppPedidoRoupas.Model.Repository.CalcadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class CalcadoService {
    @Autowired
    private CalcadoRepository calcadoRepository;
    public Collection<Calcados> obterLista() {return (Collection<Calcados>) calcadoRepository.findAll(Sort.by(Sort.Direction.ASC,"descricao")); }
}
