package primeiro_projeto_bootcamp;

public interface IConta {
    default void sacar(double valor){
    }
    default void depositar(double valor){
    }
    default void transferir(Conta contaDestino, double valor){
    }
    void imprimirExtrato();
}
