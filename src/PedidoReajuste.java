import java.util.ArrayList;
import java.util.List;

public class PedidoReajuste {

    private List<Funcionario> listaPedidos;

    public PedidoReajuste() {
        this.listaPedidos = new ArrayList<>();
    }

    public List<Funcionario> getPedidos() {
        return listaPedidos;
    }

    public void setPedidos(Funcionario funcionario) {
        listaPedidos.add(funcionario);
    }
}
