package practica_01.repository;

import practica_01.domain.Suculenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuculentaRepository
        extends JpaRepository<Suculenta, Integer> {

}