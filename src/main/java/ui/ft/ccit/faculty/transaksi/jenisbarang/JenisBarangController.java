package ui.ft.ccit.faculty.transaksi.jenisbarang;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jenis-barang")
public class JenisBarangController {
    private final JenisBarangService service;

    public JenisBarangController(JenisBarangService service) {
        this.service = service;
    }

    @GetMapping
    public List<JenisBarang> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public JenisBarang get(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public JenisBarang create(@RequestBody JenisBarang jenisBarang) {
        return service.save(jenisBarang);
    }

    @PutMapping("/{id}")
    public JenisBarang update(@PathVariable Integer id, @RequestBody JenisBarang jenisBarang) {
        jenisBarang.setIdJenisBarang(id.byteValue());
        return service.save(jenisBarang);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    
}
