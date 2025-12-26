package ui.ft.ccit.faculty.transaksi.pelanggan;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ui.ft.ccit.faculty.transaksi.pelanggan.model.Pelanggan;
import java.util.List;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {
    private final PelangganService service;

    public PelangganController(PelangganService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pelanggan> list() { return service.findAll(); }

    @GetMapping("/{id}")
    public Pelanggan get(@PathVariable String id) { return service.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pelanggan create(@RequestBody Pelanggan p) { return service.save(p); }

    @PutMapping("/{id}")
    public Pelanggan update(@PathVariable String id, @RequestBody Pelanggan p) {
        p.setIdPelanggan(id);
        return service.save(p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) { service.delete(id); }
}