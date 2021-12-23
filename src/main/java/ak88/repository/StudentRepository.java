package ak88.repository;

import ak88.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Page<Student> findByNameContaining(String name, Pageable pageable);
    Page<Student> findAll(Pageable pageable);
    Page<Student> findAllByScoreGreaterThanEqual(Pageable pageable,int score);
}
