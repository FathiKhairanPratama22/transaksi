🛒 Sistem Informasi Transaksi Penjualan Backend
Aplikasi ini adalah solusi backend terintegrasi untuk manajemen transaksi penjualan yang dikembangkan dengan standar industri menggunakan Spring Boot 3.3.4 dan Java 21. Proyek ini telah mengimplementasikan seluruh kriteria tugas besar dan fitur bonus yang diinstruksikan oleh dosen pengampu.

💎 Kriteria Nilai Bonus (Implemented)
Sesuai dengan instruksi tugas, fitur-fitur berikut telah berhasil diimplementasikan sepenuhnya:

⚡ 1. GitHub Actions CI/CD (100% Sukses)
Alur kerja otomatisasi (Pipeline) telah dikonfigurasi dan berjalan sukses tanpa hambatan:
Automated Build: Kompilasi artefak .jar otomatis menggunakan Maven di lingkungan Ubuntu.
Docker Delivery: Image aplikasi otomatis di-build dan di-push ke Docker Hub (fathi2205/transaksi-app) setiap kali ada perubahan pada branch master.
Status: Success (Centang Hijau).

🔐 2. Keamanan Berbasis Token (JWT)
Sistem keamanan API diimplementasikan menggunakan OAuth2 Resource Server dengan JSON Web Token (JWT):
Operasi baca data (GET) bersifat publik untuk keperluan pengujian dokumentasi.
Seluruh operasi modifikasi data (POST, PUT, DELETE) wajib menyertakan token autentikasi yang valid.

📖 3. Dokumentasi Swagger UI Terstruktur
Dokumentasi API disusun secara rapi menggunakan OpenAPI 3.0:
Pengelompokan endpoint berdasarkan domain bisnis (Barang, Pelanggan, Karyawan, Transaksi, dll).
Deskripsi operasional yang mendetail untuk setiap entry point API.

🏗️ Arsitektur & Logika Bisnis
Aplikasi ini mencakup manajemen data relasional yang kompleks sesuai studi kasus dunia nyata:
Full CRUD Support: Implementasi operasional lengkap (POST, PUT, DELETE, UPDATE, GET) pada seluruh entitas master data.
Relasi Database: Menggunakan JPA untuk mengatur relasi antar tabel (seperti Transaksi ke Detail Transaksi) guna menjaga integritas data.
Smart Stock Management: Sistem secara otomatis memvalidasi stok barang sebelum transaksi diproses dan melakukan pengurangan jumlah stok di database secara real-time setelah transaksi berhasil disimpan.

⚙️ Panduan Penggunaan
Menjalankan via Docker
Aplikasi telah dipaketkan dalam kontainer yang siap pakai:

Bash

# Build image
docker build -t transaksi-app .

# Jalankan kontainer
docker run -p 8080:8080 transaksi-app
Akses Swagger UI
Gunakan alamat berikut di browser untuk menguji fungsionalitas API: http://localhost:8080/swagger-ui/index.html

📁 Struktur Proyek Utama
.github/workflows/: Konfigurasi otomatisasi CI/CD.

src/main/java/ui/ft/ccit/faculty/transaksi/: Logika bisnis inti dan konfigurasi keamanan.

db/: Skema database MySQL.

Dikembangkan oleh Fathi Khairan Pratama sebagai bagian dari Tugas Besar.
