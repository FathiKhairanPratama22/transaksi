package ui.ft.ccit.faculty.transaksi.pemasok;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.pemasok.model.Pemasok;
import ui.ft.ccit.faculty.transaksi.pemasok.model.PemasokRepository;

@Service
@SuppressWarnings("null")
@Transactional
public class PemasokService {
    private final PemasokRepository repository;

    public PemasokService(PemasokRepository repository) {
        this.repository = repository;
    }

    public List<Pemasok> findAll() {
        return repository.findAll();
    }

    public Pemasok findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Pemasok", id));
    }

    public Pemasok save(Pemasok pemasok) {
        return repository.save(pemasok);
    }

    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new DataNotFoundException("Pemasok", id);
        }
        repository.deleteById(id);
    }
}