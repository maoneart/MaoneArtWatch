# MaoneArt Watch Studio

Studio Editor & Pemasang *Watch Face* Kustom Android untuk **Samsung Galaxy Fit 3 (SM-R390)** — memungkinkan modifikasi penuh tampilan jam, widget detak jantung, langkah kaki, baterai, *arc gauge*, font kustom, background GIF/video, hingga *Always-On Display (AOD)* secara visual di HP lalu mengirimkannya langsung via Bluetooth.

## Fitur Utama
- **Editor Kanvas Penuh**: Geser, ubah ukuran, putar, duplikasi, hapus, dan ganti warna widget (jam digital/analog, detak jantung, langkah kaki, baterai, *arc gauge*, teks, dan gambar).
- **Kustomisasi Font & Angka Jam**: Gambar ulang sprite angka jam dan label bawaan dengan font kustom dari perangkat Anda.
- **Buat dari Panel Kosong atau Edit Katalog**: Mulai dari panel kosong (dipasang ke slot terpisah `201–250` di samping watch face bawaan) atau modifikasi paket resmi.
- **Background Bergerak & AOD**: Mendukung gambar statis, GIF animasi, video pendek, dan pengaturan Always-On Display terpisah di bawah batas 4 MiB.
- **Validasi & Pengiriman Bluetooth Langsung**: Validasi CRC-16 ketat sebelum transfer RFCOMM/SPP ke Galaxy Fit 3 yang sudah terpasang di **Galaxy Wearable**.

## Cara Pemasangan ke Galaxy Fit 3
1. Pastikan Galaxy Fit 3 sudah terhubung melalui aplikasi **Galaxy Wearable** dan plugin bawaan terpasang.
2. Buka **MaoneArt Watch Studio**, pilih atau buat proyek *watch face*, lalu masuk ke halaman **Install**.
3. Berikan izin **Nearby devices** untuk MaoneArt Watch saat diminta.
4. Lakukan *discover* saat plugin masih aktif, lalu matikan izin **Nearby devices** milik plugin Fit 3 sebentar saat menekan **Send**, dan nyalakan kembali setelah selesai.

## Lisensi & Atribusi
Kode sumber proyek ini berbasis karya open-source berlisensi MIT [`satvikgosai/fitface-studio`](https://github.com/satvikgosai/fitface-studio). Lihat [`LICENSE`](LICENSE) dan [`NOTICE.md`](NOTICE.md) untuk rincian lisensi MIT dan ketentuan komponen pihak ketiga (`libs/` Accessory SDK JARs yang diunduh saat build).
