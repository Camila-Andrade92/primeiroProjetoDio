package primeiro_projeto_bootcamp;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        this.agencia=super.AGENCIA_PADRAO;
        this.numero = super.SEQUENCIAL++;
        this.digitoConta = (agencia+numero)%10;
        this.cliente = cliente;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("***EXTRATO CONTA CORRENTE***");
        super.imprimirInformacoesComuns();

    }


}
