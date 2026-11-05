package practica_01.service;

import practica_01.domain.Suculenta;
import practica_01.repository.SuculentaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SuculentaService {

    private final SuculentaRepository suculentaRepository;

    public SuculentaService(SuculentaRepository suculentaRepository) {
        this.suculentaRepository = suculentaRepository;
    }

    // Listar todas las suculentas
    @Transactional(readOnly = true)
    public List<Suculenta> listarSuculentas() {
        return suculentaRepository.findAll();
    }

    // Buscar una suculenta por ID
    @Transactional(readOnly = true)
    public Optional<Suculenta> buscarSuculenta(Integer id) {
        return suculentaRepository.findById(id);
    }

    // Guardar o actualizar una suculenta
    @Transactional
    public void guardarSuculenta(Suculenta suculenta) {
        suculentaRepository.save(suculenta);
    }

    // Eliminar una suculenta
    @Transactional
    public void eliminarSuculenta(Integer id) {
        suculentaRepository.deleteById(id);
    }
}
