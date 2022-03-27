package primeiro_projeto_bootcamp;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco("Banco 01");
        banco.imprimirNomeDoBanco();

        banco.criarNovaconta("Camila","08899533610",'p');
        banco.criarNovaconta("Lucio","08899533027",'p');
        banco.criarNovaconta("Maria","08899533001",'p');
        banco.criarNovaconta("Miguel","08899533002",'c');

        banco.imprimirTodasAsContas();



        banco.transferencia(2,1,35,35,50);
        banco.depositar(1,34);
        banco.mostrarSaldo(1);
        banco.sacarDinheiro(1,35,15);
        banco.mostrarSaldo(1);

        Cliente camila = new Cliente("Camila", "08899755320");
        ContaCorrente conta = new ContaCorrente(camila);
        conta.imprimirExtrato();
        ContaPoupanca contaP =new ContaPoupanca(camila);
        contaP.imprimirExtrato();
    }
}
