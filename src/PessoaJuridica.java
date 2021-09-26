import java.time.LocalDate;

public class PessoaJuridica extends Funcionario{

    private String cnpj;

    public PessoaJuridica(String nome, LocalDate dataAdmissao, String cnpj) {
        super(nome, dataAdmissao);
        this.cnpj = cnpj;
    }
}
