package acelera.devs.pablo.api.model.venda;

import acelera.devs.pablo.api.model.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByCliente(Cliente cliente);
    List<Venda> findByDataCompraBetween(Date dataInicial, Date dataFinal);
}
