import java.time.LocalDate;

public class Gerente extends PessoaFisica implements Demitidor {

    public Gerente(String nome, LocalDate dataAdmissao) {
        super(nome, dataAdmissao);
    }

    @Override
    public double consultarCC() {
        return super.consultarCC()*1.12;
    }

    @Override
    public void demitir(Funcionario funcionario) {
        if (funcionario instanceof Gerente) {
            System.out.println(this.getNome() + ", você não tem permissão para demitir esse funcionário!");
        } else System.out.println(this.getNome() + " demitiu " + funcionario.getNome());
    }

    public void reajustarSalario(PedidoReajuste pedidos) throws Exception {
        if (pedidos.getPedidos() == null) {
            throw new Exception("Nenhuma requisição de ajuste salarial!");
        }
        Funcionario selecionado = pedidos.getPedidos().get(0);

        if (selecionado instanceof Gerente) {
            pedidos.getPedidos().remove(0);
            throw new Exception(this.getNome() + ", você não tem permissão para reajustar esse salário!");
        }

        double sorte = Math.random() * 100;
        if (sorte > 50) {
            System.out.print(selecionado.getNome() + ", você recebeu aumento!");
            System.out.print(String.format(" -- Salario anterior: RS%.2f", selecionado.getSalarioBase()));
            selecionado.setSalarioBase(getSalarioBase() + 50.0);
            System.out.println(String.format(" -- Novo salário: RS%.2f", selecionado.getSalarioBase()));
        } else {
            System.out.println(selecionado.getNome() + ", você não recebeu aumento.");
        }

        pedidos.getPedidos().remove(0);
    }

    @Override
    public String toString() {
        return String.format("Funcionario %s possui salário base de RS%.2f  mais a bonificação de", this.getNome(), this.getSalarioBase());
    }
}

