package primeiro_projeto_bootcamp;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;

public class Banco {
    private String nome;
    private ArrayList<Conta> listaDecontas;

    public Banco(String nome) {
        this.nome=nome;
        this.listaDecontas= new ArrayList<Conta>();
    }
    public void imprimirNomeDoBanco(){
        System.out.println(this.nome);
    }

    public void depositar(int numeroContaDestino, double valor){

        for (Conta conta: listaDecontas) {

            if(conta.getNumero()==numeroContaDestino) {
                if (conta.getSaldo()>=valor) {
                    conta.depositar(valor);
                    System.out.println("Deposito realizado com sucesso. Saldo atual: "+ conta.getSaldo());
                }
                else{
                    System.out.println("Saldo para depósito insuficiente.");
                }
            }
        }
    }
    public void transferencia(int numeContaOrigem, int numeroContaDestino, int agenciaOrigem, int agenciaDestino, double valor){
        Conta contaorigem=null;
        Conta contadestino=null;
        for (Conta conta : listaDecontas) {
            if(conta.getNumero()==numeContaOrigem){
                contaorigem=conta;
            }
            else if(conta.getNumero()==numeroContaDestino){
                contadestino=conta;
            }
        }
        if (contadestino==null || contaorigem==null){
            System.out.println("Conta inexistente.");
        }
        else{
            contaorigem.transferir(contadestino,valor);
            System.out.println("Transferencia realizada com sucesso.");
            System.out.println("Saldo conta origem: "+contaorigem.getSaldo()+ " Saldo conta destino: "+contadestino.getSaldo());
        }
    }
    public void mostrarSaldo(int numeroDaConta){
        Conta contaConsultada = null;
        for (Conta conta:listaDecontas) {
            if(conta.getNumero() == numeroDaConta){
                contaConsultada=conta;
            }
        }
        System.out.println("O saldo da conta é: "+contaConsultada.getSaldo());
    }

    public void sacarDinheiro(int numeroConta, int numeroAgencia, double valor) {
        Conta contaSaque = null;

        for (Conta conta : listaDecontas) {
            if (conta.getNumero() == numeroConta)
                contaSaque = conta;
        }
        if(contaSaque.getSaldo()<valor){
            System.out.println("Valor para saque indisponível.");
        }
        else{
            System.out.println("Saque realizado com sucesso");
            contaSaque.sacar(valor);
        }

    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void criarNovaconta(String nome, String cpf, char tipoConta){
        Cliente cliente = new Cliente(nome,cpf);
        if (tipoConta == 'p'){
            ContaPoupanca novaContaP = new ContaPoupanca(cliente);
            this.listaDecontas.add(novaContaP);
        }
        else if(tipoConta =='c'){
            ContaCorrente novaContaC = new ContaCorrente(cliente);
            this.listaDecontas.add(novaContaC);
        }
    }
    public void imprimirTodasAsContas(){
        System.out.println("Lista das contas do banco: ");

        if(listaDecontas.size()==0){
            System.out.println("Não existem contas cadastradas.");
        }

        for (Conta conta:listaDecontas) {

            if( conta instanceof ContaCorrente) {
                System.out.println("Cliente: " + conta.getCliente().getNome() + " - " + "Agência: " + conta.getAgencia() +" - "+ "Número da conta: " + conta.numero +" - "+"Dígito conta: + "+conta.getDigitoConta()+" - "+ "CPF: " + conta.getCliente().getCpf() +" - "+ "Tipo da conta: conta corrente");
            }
            else{
                System.out.println("Cliente: " + conta.getCliente().getNome() +" - "+ "Agência: " + conta.getAgencia() +" - "+ "Número da conta: " + conta.numero + " - " + "Dígito conta: + "+conta.getDigitoConta()+" - "+ "CPF: " +conta.getCliente().getCpf() + " - "+"Tipo da conta: conta poupança");
            }

        }
    }
}
