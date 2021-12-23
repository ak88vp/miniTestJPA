package ak88.service;

import ak88.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService extends IGeneralService<Student> {
    Page<Student> findAll(Pageable pageable);
    Page<Student> findByNameContaining(String name, Pageable pageable);
}
