import java.time.LocalDate;

public class PessoaFisica extends Funcionario{

    private String cpf;
    private String nit;

    public PessoaFisica(String nome, LocalDate dataAdmissao) {
        super(nome, dataAdmissao);
    }
}
