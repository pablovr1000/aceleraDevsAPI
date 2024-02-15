package acelera.devs.pablo.api.model.produto;

import acelera.devs.pablo.api.model.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
