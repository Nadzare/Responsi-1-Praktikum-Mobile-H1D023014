# 📱 Responsi 1 Praktikum Mobile - Aplikasi Android - Stade Rennais F.C.

<div align="center">
  
<img src="app/src/main/res/drawable/ic_logo_stade.png" alt="Logo Stade Rennais" width="200"/>

# **Stade Rennais F.C. Mobile App**

Aplikasi Android native berbasis **Kotlin** yang berfungsi sebagai pusat informasi seputar **Stade Rennais Football Club**.

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-blue.svg)](https://kotlinlang.org)
[![Android](https://img.shields.io/badge/Android-API_24+-green.svg)](https://developer.android.com)
[![Arsitektur](https://img.shields.io/badge/Arsitektur-MVVM-orange.svg)](https://developer.android.com/jetpack/guide)
[![API](https://img.shields.io/badge/API-football--data.org-success.svg)](https://www.football-data.org/)

---

👤 **Nama:** Nadzare Kafah Alfatiha  
🎓 **NIM:** H1D023014  
🕒 **Shift:** F  
📘 **Shift Asal:** A  

</div>

---

## 🎥 Demo Aplikasi

Lihat video demo aplikasi di sini:  

<img src="https://github.com/Nadzare/Responsi-1-Praktikum-Mobile-H1D023014/blob/main/app/src/main/res/drawable/staderennais.gif" alt="output Tugas 3 Pertemuan 4" width="300"/>

---

## ✨ Fitur Utama

### ⚽ Fungsi Inti
- **Data Real-time**: Menampilkan data terkini dari API *football-data.org*  
- **Informasi Klub**: Menampilkan profil lengkap klub Stade Rennais FC  
- **Manajemen Tim**: Menampilkan daftar pelatih dan pemain klub  

### 🖌️ Antarmuka Pengguna
- **Splash Screen Modern**: Menggunakan *SplashScreen API* untuk tampilan awal yang elegan  
- **Material Design**: Desain menggunakan *CardView* dan komponen modern  
- **Kode Warna Posisi Pemain**: Posisi pemain ditandai dengan warna berbeda  
- **Bottom Sheet Detail**: Menampilkan detail pemain dalam tampilan *bottom sheet* interaktif  

### ⚙️ Fitur Teknis
- **Arsitektur MVVM**: Pemisahan tanggung jawab antara View, ViewModel, dan Model  
- **LiveData**: Untuk manajemen status data secara reaktif  
- **Integrasi API**: Menggunakan Retrofit + OkHttp untuk komunikasi jaringan  
- **Parcelable Object**: Untuk mengirim data antar-komponen dengan efisien  

---


---

## 📸 Tampilan Aplikasi

### Menu Utama

| Fitur | Deskripsi |
|-------|------------|
| 🏆 **Sejarah Klub** | Informasi sejarah dan prestasi klub |
| 👨‍🏫 **Pelatih Utama** | Informasi pelatih saat ini |
| 👥 **Skuad Tim** | Daftar lengkap pemain klub |

---

### Warna Posisi Pemain

| Posisi | Warna | Ikon |
|--------|-------|------|
| Penjaga Gawang | 🟡 Kuning | 🧤 |
| Bek | 🔵 Biru | 🛡️ |
| Gelandang | 🟢 Hijau | ⚽ |
| Penyerang | 🔴 Merah | 🎯 |

---

## 🔄 Alur Arsitektur Data

Pengguna membuka aplikasi → Splash Screen → Menu Utama  
↓  
Sejarah Klub | Pelatih | Daftar Pemain  
↓  
ViewModel → Panggilan API → football-data.org  
↓  
Response JSON → Parsing GSON → Update LiveData  
↓  
RecyclerView → Klik Pemain → Detail Player (Bottom Sheet)

---

## 🧩 Implementasi Teknis

### Alur Integrasi API
1. **Request**: Retrofit melakukan permintaan ke endpoint `v4/teams/529` (ID klub Stade Rennais)  
2. **Autentikasi**: Menggunakan header `X-Auth-Token` untuk akses API  
3. **Response**: Data JSON diterima dari *football-data.org*  
4. **Parsing**: GSON mengonversi JSON menjadi *data class* Kotlin  
5. **Penyimpanan**: Data disimpan ke `MutableLiveData<Team>`  
6. **Observasi**: Aktivitas dan fragment mengamati perubahan LiveData  
7. **Tampilan**: Data diperbarui secara otomatis di UI  

### Komponen Penting
- 🧠 **TeamViewModel** → Mengatur pemanggilan API dan status data  
- 🧾 **PlayerAdapter** → Menampilkan daftar pemain dengan pewarnaan posisi  
- 📋 **PlayerDetailFragment** → Menampilkan detail pemain di *BottomSheetDialog*  
- 🎨 **PositionColor.kt** → Utility untuk menentukan warna posisi pemain  

---

