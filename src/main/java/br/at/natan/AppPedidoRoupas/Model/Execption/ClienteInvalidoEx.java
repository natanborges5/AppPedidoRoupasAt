package br.at.natan.AppPedidoRoupas.Model.Execption;

public class ClienteInvalidoEx extends Exception{
    private static final long serialVersionUID = 1L;
    public ClienteInvalidoEx(String msg){
        super(msg);
    }
}
