package br.at.natan.AppPedidoRoupas.Model.Execption;

public class ValoresInvalidosEx extends Exception{
    private static final long serialVersionUID = 1L;
    public ValoresInvalidosEx(String msg){
        super(msg);
    }
}
