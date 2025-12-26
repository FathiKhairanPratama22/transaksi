package ui.ft.ccit.faculty.transaksi.pelanggan;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.pelanggan.model.Pelanggan;
import ui.ft.ccit.faculty.transaksi.pelanggan.model.PelangganRepository;
import java.util.List;

@Service
@SuppressWarnings("null")
@Transactional
public class PelangganService {
    private final PelangganRepository repository;
    public PelangganService(PelangganRepository repository) { this.repository = repository; }
    public List<Pelanggan> findAll() { return repository.findAll(); }
    public Pelanggan findById(String id) { return repository.findById(id).orElseThrow(() -> new DataNotFoundException("Pelanggan", id)); }
    public Pelanggan save(Pelanggan p) { return repository.save(p); }
    public void delete(String id) { repository.deleteById(id); }
}