# APPSTRO: Aplikasi Rehabilitasi Pasien Pasca Stroke

**APPSTRO** adalah aplikasi berbasis teknologi kecerdasan buatan dan pengolahan citra yang dirancang untuk membantu pasien pasca stroke dalam menjalani proses rehabilitasi. Aplikasi ini memungkinkan pasien untuk melakukan rehabilitasi di rumah dengan kualitas yang sebanding dengan fasilitas kesehatan umum. Dikembangkan menggunakan **MediaPipe Pose Detection**, APPSTRO mampu mendeteksi gerakan rehabilitasi dan menilai kualitas gerakan yang dilakukan oleh pasien.  

## 🎯 Fitur Utama
- **Deteksi Gerakan Rehabilitasi**: Menggunakan teknologi MediaPipe untuk mendeteksi gerakan pasien secara real-time.  
- **Penilaian Kualitas Gerakan**: Sistem pakar berbasis rule-based mengelompokkan gerakan menjadi:
  - **Gerakan Sempurna**: Gerakan yang dilakukan sesuai dengan standar rehabilitasi.
  - **Gerakan Tidak Sempurna**: Gerakan yang mendekati standar namun masih memerlukan perbaikan.
  - **Gerakan Tidak Bergerak**: Tidak ada aktivitas gerakan yang terdeteksi.
- **Antarmuka Ramah Pengguna**: Mempermudah pasien dalam mengakses dan menggunakan aplikasi tanpa memerlukan pelatihan khusus.
- **Rehabilitasi Mandiri di Rumah**: Meningkatkan aksesibilitas dan kenyamanan pasien dalam menjalani terapi.

## 🛠️ Teknologi yang Digunakan
- **MediaPipe Pose Detection**: Untuk mendeteksi pose dan gerakan pasien.
- **Kotlin**: Bahasa pemrograman utama untuk pengembangan aplikasi.
- **Sistem Pakar Rule-Based**: Untuk memberikan penilaian gerakan rehabilitasi berdasarkan aturan yang telah ditentukan.
