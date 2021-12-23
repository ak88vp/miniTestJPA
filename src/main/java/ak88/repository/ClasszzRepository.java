package ak88.repository;

import ak88.model.Classzz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasszzRepository extends JpaRepository<Classzz,Long> {
}
