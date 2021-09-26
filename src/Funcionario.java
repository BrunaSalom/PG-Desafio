import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario {

    private String endereco;
    private String nome;
    private String email;
    private String setor;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;
    private double salarioBase;
    private List<Ferias> historicoFerias;

    public Funcionario(String nome, LocalDate dataAdmissao) {
        this.endereco = "";
        this.nome = nome;
        this.email = "";
        this.setor = "";
        this.dataAdmissao = dataAdmissao;
        this.salarioBase = 2000.0;
        this.historicoFerias = new ArrayList<>();
    }

    //    ----------------------
//    Métodos:
    public double consultarCC() {
        return salarioBase;
    }

    public void pedirFerias(LocalDate dataInicio, LocalDate dataFim) throws Exception {
        if (LocalDate.now().minusMonths(11).isBefore(dataAdmissao)) {
            throw new Exception(this.nome + ", você não está na empresa a tempo o suficiente!");
        }
        if (historicoFerias.size() > 0) {
            Ferias ultimasFerias = historicoFerias.get(historicoFerias.size() - 1);
            if (ultimasFerias.getDataFim().isAfter(LocalDate.now())) {
                throw new Exception(this.nome + " já se encontra em período férias.");
            } else if (LocalDate.now().minusMonths(4).isBefore(ultimasFerias.getDataFim())) {
                throw new Exception(this.nome + ", você está fora de período para soliciação de férias.");
            }
        }
        System.out.println(this.nome + ", você pode sair de férias!");

        Ferias ferias = new Ferias();
        ferias.setDataInicio(dataInicio);
        ferias.setDataFim(dataFim);

        this.historicoFerias.add(ferias);
    }

    public void trabalhar() throws Exception {
        if (historicoFerias.size() > 0) {
            Ferias ultimasFerias = historicoFerias.get(historicoFerias.size() - 1);
            if (ultimasFerias.getDataFim().isAfter(LocalDate.now())) {
                throw new Exception(this.nome + " se encontra em período férias.");
            }
        }
        System.out.println(this.nome + " está trabalhando!");
    }

    public void pedirDemissao() {
        System.out.println(this.nome + " pediu demissão!");
    }

    public void solicitarAumento(PedidoReajuste lista, Funcionario funcionario) {
        lista.setPedidos(funcionario);
    }

    //    -----------------------
//    Getter e Setter:
    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public List<Ferias> getHistoricoFerias() {
        return historicoFerias;
    }

    public void setHistoricoFerias(LocalDate comeco, LocalDate fim) {
        Ferias novaFerias = new Ferias();
        novaFerias.setDataInicio(comeco);
        novaFerias.setDataFim(fim);
        historicoFerias.add(novaFerias);
    }
}
