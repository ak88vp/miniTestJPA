package ak88.service;

import ak88.model.Classzz;
import ak88.repository.ClasszzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClasszzServiceImpl implements ClasszzService{
    @Autowired
    ClasszzRepository classzzRepository;
    @Override
    public Iterable<Classzz> findAll() {
        return classzzRepository.findAll();
    }

    @Override
    public Optional<Classzz> findById(Long id) {
        return classzzRepository.findById(id);
    }

    @Override
    public void save(Classzz classzz) {

    }

    @Override
    public void remove(Long id) {

    }
}
