package ui.ft.ccit.faculty.transaksi.karyawan;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
// IMPORT INI PENTING:
import ui.ft.ccit.faculty.transaksi.karyawan.model.Karyawan;
import ui.ft.ccit.faculty.transaksi.karyawan.model.KaryawanRepository;

import java.util.List;

@Service
@Transactional
public class KaryawanService {
    private final KaryawanRepository repository;

    public KaryawanService(KaryawanRepository repository) {
        this.repository = repository;
    }

    public List<Karyawan> findAll() { return repository.findAll(); }

    public Karyawan findById(String id) {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException("Karyawan", id));
    }

    public Karyawan save(Karyawan karyawan) { return repository.save(karyawan); }

    public void delete(String id) {
        if (!repository.existsById(id)) throw new DataNotFoundException("Karyawan", id);
        repository.deleteById(id);
    }
}