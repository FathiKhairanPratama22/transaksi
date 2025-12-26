🛒 Sistem Informasi Transaksi Penjualan Backend
Status Proyek:
Java Version: 21 (OpenJDK)
Framework: Spring Boot 3.3.4
CI/CD Status: 100% Success (GitHub Actions)
Docker Hub: Pushed to fathi2205/transaksi-app

💎 Kriteria Nilai Bonus (Implemented)
Aplikasi ini telah memenuhi seluruh kriteria bonus sesuai instruksi Bapak @azkamuhamco:

1. GitHub Actions CI/CD (100% Sukses)
Alur kerja otomatisasi telah dikonfigurasi sepenuhnya dan berjalan tanpa hambatan:
Automated Build: Kompilasi artefak .jar otomatis menggunakan Maven di lingkungan cloud.
Docker Delivery: Image aplikasi otomatis di-build dan di-push ke Docker Hub setiap kali ada perubahan pada branch master.
Status: Success (Centang Hijau) pada run terakhir.

2. Keamanan Berbasis Token (JWT)
Sistem keamanan API diimplementasikan menggunakan OAuth2 Resource Server dengan JSON Web Token (JWT):
Operasi baca data (GET) bersifat publik untuk keperluan pengujian dokumentasi.
Seluruh operasi modifikasi data (POST, PUT, DELETE) wajib menyertakan token autentikasi yang valid pada header.

3. Dokumentasi Swagger UI Terstruktur
Dokumentasi API disusun secara rapi menggunakan OpenAPI 3.0:
Pengelompokan endpoint berdasarkan domain bisnis (Barang, Pelanggan, Karyawan, Transaksi, dll).
Deskripsi operasional mendetail untuk setiap entry point API.

🏗️ Fitur & Logika Bisnis
Full CRUD Support: Implementasi operasional lengkap (POST, PUT, DELETE, GET) pada seluruh entitas master data.
Relasi Database: Menggunakan JPA untuk mengatur relasi antar tabel secara integritas (One-to-Many Transaksi ke Detail Transaksi).

Smart Stock Management: Sistem secara otomatis memvalidasi stok sebelum transaksi diproses dan melakukan pengurangan stok di database setelah transaksi berhasil disimpan.

## ⚙️ Panduan Penggunaan

### Menjalankan via Docker
Aplikasi telah dipaketkan dalam kontainer yang siap pakai. Jalankan perintah berikut di terminal atau Git Bash Anda:

```bash
# 1. Build image dari Dockerfile
docker build -t transaksi-app .

# 2. Jalankan kontainer pada port 8080
docker run -p 8080:8080 transaksi-app
```
Akses Swagger UI
Gunakan alamat berikut di browser untuk menguji fungsionalitas API: http://localhost:8080/swagger-ui/index.html

Dikembangkan oleh Fathi Khairan Pratama sebagai bagian dari penyelesaian Tugas Besar.
