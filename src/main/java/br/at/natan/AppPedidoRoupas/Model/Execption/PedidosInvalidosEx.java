package br.at.natan.AppPedidoRoupas.Model.Execption;

public class PedidosInvalidosEx extends Exception {
    private static final long serialVersionUID = 1L;
    public PedidosInvalidosEx(String msg){
        super(msg);
    }
}
