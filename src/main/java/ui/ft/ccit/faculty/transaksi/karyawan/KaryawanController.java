package ui.ft.ccit.faculty.transaksi.karyawan;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
// PASTIKAN IMPORT INI ADA:
import ui.ft.ccit.faculty.transaksi.karyawan.model.Karyawan;

import java.util.List;

@RestController
@RequestMapping("/api/karyawan")
public class KaryawanController {

    private final KaryawanService service;

    // Jika KaryawanService berada di package yang sama, tidak butuh import.
    // Namun pastikan file KaryawanService.java sudah disimpan dengan benar.
    public KaryawanController(KaryawanService service) {
        this.service = service;
    }

    @GetMapping
    public List<Karyawan> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Karyawan get(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Karyawan create(@RequestBody Karyawan karyawan) {
        return service.save(karyawan);
    }

    @PutMapping("/{id}")
    public Karyawan update(@PathVariable String id, @RequestBody Karyawan karyawan) {
        karyawan.setIdKaryawan(id);
        return service.save(karyawan);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}