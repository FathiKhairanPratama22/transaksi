package ui.ft.ccit.faculty.transaksi.transaksi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transaksi")
public class Transaksi {
    @Id
    @Column(name = "kode_transaksi", length = 4)
    private String kodeTransaksi;

    @Column(name = "tgl_transaksi")
    private LocalDateTime tglTransaksi = LocalDateTime.now();

    @Column(name = "id_pelanggan", length = 4)
    private String idPelanggan;

    @Column(name = "id_karyawan", length = 4)
    private String idKaryawan;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "kode_transaksi")
    private List<DetailTransaksi> details;

    // Getter & Setter
    public String getKodeTransaksi() { return kodeTransaksi; }
    public void setKodeTransaksi(String kodeTransaksi) { this.kodeTransaksi = kodeTransaksi; }
    public LocalDateTime getTglTransaksi() { return tglTransaksi; }
    public void setTglTransaksi(LocalDateTime tglTransaksi) { this.tglTransaksi = tglTransaksi; }
    public String getIdPelanggan() { return idPelanggan; }
    public void setIdPelanggan(String idPelanggan) { this.idPelanggan = idPelanggan; }
    public String getIdKaryawan() { return idKaryawan; }
    public void setIdKaryawan(String idKaryawan) { this.idKaryawan = idKaryawan; }
    public List<DetailTransaksi> getDetails() { return details; }
    public void setDetails(List<DetailTransaksi> details) { this.details = details; }
}