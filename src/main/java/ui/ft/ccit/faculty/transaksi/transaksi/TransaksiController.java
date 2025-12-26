package ui.ft.ccit.faculty.transaksi.transaksi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ui.ft.ccit.faculty.transaksi.transaksi.model.Transaksi;
import java.util.List;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {

    private final TransaksiService service;

    public TransaksiController(TransaksiService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transaksi> list() { return service.findAll(); }

    @GetMapping("/{id}")
    public Transaksi get(@PathVariable String id) { return service.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaksi create(@RequestBody Transaksi transaksi) {
        return service.save(transaksi);
    }

    @PutMapping("/{id}")
    public Transaksi update(@PathVariable String id, @RequestBody Transaksi transaksi) {
        transaksi.setKodeTransaksi(id);
        return service.save(transaksi);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}