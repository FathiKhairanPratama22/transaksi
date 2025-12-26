package ui.ft.ccit.faculty.transaksi.transaksi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detail_transaksi")
@IdClass(DetailTransaksiId.class) // Karena Primary Key komposit (kode_transaksi + id_barang)
public class DetailTransaksi {
    @Id
    @Column(name = "kode_transaksi", length = 4)
    private String kodeTransaksi;

    @Id
    @Column(name = "id_barang", length = 4)
    private String idBarang;

    private Short jumlah;

    // Getter & Setter
    public String getKodeTransaksi() { return kodeTransaksi; }
    public void setKodeTransaksi(String kodeTransaksi) { this.kodeTransaksi = kodeTransaksi; }
    public String getIdBarang() { return idBarang; }
    public void setIdBarang(String idBarang) { this.idBarang = idBarang; }
    public Short getJumlah() { return jumlah; }
    public void setJumlah(Short jumlah) { this.jumlah = jumlah; }
}