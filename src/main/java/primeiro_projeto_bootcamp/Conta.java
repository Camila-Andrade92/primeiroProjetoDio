package primeiro_projeto_bootcamp;

public abstract class Conta implements IConta {

    protected static final int AGENCIA_PADRAO=35;
    protected static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected int digitoConta;
    protected Cliente cliente;

    public int getDigitoConta() {
        return digitoConta;
    }
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo=saldo-valor;
    }

    @Override
    public void depositar(double valor) {
        saldo=saldo+valor;

    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        this.sacar(valor);
        contaDestino.depositar(valor );

    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    public int getNumero() {
        return numero;
    }
    protected void imprimirInformacoesComuns() {
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número da conta: "+ this.numero);
        System.out.printf("O saldo da conta é : %.2f \n", this.saldo);
    }

}
