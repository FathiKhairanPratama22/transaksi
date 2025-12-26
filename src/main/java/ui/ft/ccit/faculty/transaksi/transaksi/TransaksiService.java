package ui.ft.ccit.faculty.transaksi.transaksi;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.barang.model.Barang;
import ui.ft.ccit.faculty.transaksi.barang.view.BarangService;
import ui.ft.ccit.faculty.transaksi.transaksi.model.Transaksi;
import ui.ft.ccit.faculty.transaksi.transaksi.model.TransaksiRepository;
import ui.ft.ccit.faculty.transaksi.transaksi.model.DetailTransaksi;

import java.util.List;

@Service
@Transactional
public class TransaksiService {
    private final TransaksiRepository repository;
    private final BarangService barangService;

    public TransaksiService(TransaksiRepository repository, BarangService barangService) {
        this.repository = repository;
        this.barangService = barangService;
    }

    // FIX ERROR: Menambahkan metode findAll()
    public List<Transaksi> findAll() {
        return repository.findAll();
    }

    // FIX ERROR: Menambahkan metode findById()
    public Transaksi findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Transaksi", id));
    }

    // Metode simpan dengan LOGIKA POTONG STOK
    public Transaksi save(Transaksi transaksi) {
        if (transaksi.getDetails() != null) {
            for (DetailTransaksi detail : transaksi.getDetails()) {
                // PENTING: Baris ini untuk menghubungkan detail dengan induknya
                // Menghilangkan error "Column 'kode_transaksi' cannot be null"
                detail.setKodeTransaksi(transaksi.getKodeTransaksi());

                // 1. Ambil data barang dari database
                Barang barang = barangService.getById(detail.getIdBarang());
                
                // 2. Validasi stok (Dunia Nyata: tidak boleh jual jika stok kurang)
                if (barang.getStok() < detail.getJumlah()) {
                    throw new IllegalArgumentException("Stok barang " + barang.getNama() + " tidak mencukupi!");
                }

                // 3. Kurangi stok barang secara otomatis
                barang.setStok((short) (barang.getStok() - detail.getJumlah()));
                
                // 4. Update data barang di database
                barangService.update(barang.getIdBarang(), barang);
            }
        }
        // 5. Simpan transaksi beserta detailnya ke database
        return repository.save(transaksi);
    }

    // FIX ERROR: Menambahkan metode delete()
    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new DataNotFoundException("Transaksi", id);
        }
        repository.deleteById(id);
    }
}