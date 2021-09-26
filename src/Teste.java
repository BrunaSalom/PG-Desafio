import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) throws Exception {
        List<Funcionario> funcionarios = new ArrayList<>();
        Funcionario funcionario1 = new Funcionario("Bruna", LocalDate.now().minusMonths(24));
        Funcionario funcionario2 = new Funcionario("Joxick", LocalDate.now().minusMonths(11));
        Supervisor supervisor1 = new Supervisor("Marlene", LocalDate.now().minusMonths(10));
        Supervisor supervisor2 = new Supervisor("Odlareg", LocalDate.now().minusMonths(5));
        Gerente gerente1 = new Gerente("Dhuye", LocalDate.now().minusMonths(15));
        Gerente gerente2 = new Gerente("Zaprak", LocalDate.now().minusMonths(19));

        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);
        funcionarios.add(supervisor1);
        funcionarios.add(supervisor2);
        funcionarios.add(gerente1);
        funcionarios.add(gerente2);

        PedidoReajuste lista1 = new PedidoReajuste();

        gerente1.setHistoricoFerias(LocalDate.now().minusMonths(4), LocalDate.now().minusMonths(3));
        gerente2.setHistoricoFerias(LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(1));


        System.out.println("------------------");
//        Testando férias:
        for (Funcionario f : funcionarios) {
            try {
                f.pedirFerias(LocalDate.now().minusMonths(1), LocalDate.now().minusMonths(0));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("------------------");
//        Testando trabalhando:
        for (Funcionario f : funcionarios) {
            try {
                f.trabalhar();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("-----------------");
//        Testando pedir demissão:
        for (Funcionario f : funcionarios) {
            try {
                f.pedirDemissao();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("-----------------");
//        Testando demitir:
        supervisor2.demitir(funcionario1);
        supervisor2.demitir(supervisor1);
        supervisor2.demitir(gerente1);

        gerente2.demitir(funcionario1);
        gerente2.demitir(supervisor1);
        gerente2.demitir(gerente1);

        System.out.println("-----------------");
//        Testando aumento de salário:
        for (Funcionario f : funcionarios) {
            try {
                f.solicitarAumento(lista1,f);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        do {
            try {
                gerente1.reajustarSalario(lista1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (lista1.getPedidos().size() != 0);

        System.out.println("-----------------");
//        Testando consulta de salário:
        funcionarios.forEach(funcionario -> System.out.println(funcionario.consultarCC()));

        System.out.println("-----------------");
//        Testando consulta de histórico de férias:
        funcionarios.forEach(funcionario -> System.out.println(funcionario.getHistoricoFerias()));
    }
}
