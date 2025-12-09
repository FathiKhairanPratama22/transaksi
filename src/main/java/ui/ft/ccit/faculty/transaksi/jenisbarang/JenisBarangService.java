package ui.ft.ccit.faculty.transaksi.jenisbarang;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
@Service
@Transactional
public class JenisBarangService {
    private final JenisBarangRepository repository;

    public JenisBarangService(JenisBarangRepository repository) {
        this.repository = repository;
    }

    public List<JenisBarang> findAll() {
        return repository.findAll();
    }

    public JenisBarang findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("JenisBarang", String.valueOf(id)));
    }

    public JenisBarang save(JenisBarang jenisBarang) {
        return repository.save(jenisBarang);
    }

    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new DataNotFoundException("JenisBarang", String.valueOf(id));
        }
        repository.deleteById(id);
    }
}
