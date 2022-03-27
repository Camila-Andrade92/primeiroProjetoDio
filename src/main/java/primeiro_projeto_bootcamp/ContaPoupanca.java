package primeiro_projeto_bootcamp;

public class ContaPoupanca extends Conta {


    public ContaPoupanca(Cliente cliente){
        this.agencia = super.AGENCIA_PADRAO;
        this.numero = super.SEQUENCIAL++;
        this.digitoConta = (agencia+numero)%10;
        this.cliente = cliente;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("***EXTRATO CONTA POUPANCA***");
        super.imprimirInformacoesComuns();
    }
}
