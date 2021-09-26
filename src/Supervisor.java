import java.time.LocalDate;

public class Supervisor extends PessoaFisica implements Demitidor{

    public Supervisor(String nome, LocalDate dataAdmissao) {
        super(nome, dataAdmissao);
    }

    @Override
    public double consultarCC() {
        return super.consultarCC()*1.08;
    }

    @Override
    public void demitir(Funcionario funcionario) {
        if(funcionario instanceof Gerente || funcionario instanceof Supervisor){
            System.out.println(this.getNome()+", você não tem permissão para demitir esse funcionário!");
        } else System.out.println(this.getNome()+" demitiu "+ funcionario.getNome());
    }
}
