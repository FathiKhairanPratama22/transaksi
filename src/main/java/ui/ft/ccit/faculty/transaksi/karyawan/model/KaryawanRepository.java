package ui.ft.ccit.faculty.transaksi.karyawan.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, String> {
    // JpaRepository menggunakan String karena ID Karyawan adalah String (K001, dsb)
}