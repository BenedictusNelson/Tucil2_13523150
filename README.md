# Kompresi Gambar Menggunakan Quadtree
## Bahasa: Java

## Deskripsi Singkat
Program ini adalah implementasi algoritma Divide and Conquer menggunakan struktur data Quadtree untuk melakukan kompresi gambar berbasis analisis keseragaman blok piksel. Program ini mendukung berbagai metode perhitungan error seperti Variance, Mean Absolute Deviation (MAD), MaxDiff, Entropy, dan Structural Similarity Index (SSIM) untuk menentukan pembagian blok dalam proses kompresi.

## 📁 Struktur Direktori
```bash
├── src/
│   ├── Main.java
│   ├── ImageCompressor.java
│   ├── QuadTreeNode.java
│   └── compile.bat
├── bin/
│   ├── Main.class
│   ├── ImageCompressor.class
│   ├── QuadTreeNode.class
│   └── run.bat
├── test/
│   ├── Compressed Images/
│   |   ├── compressed_images1--7.jpg
│   ├── Test Case/
│   |   ├── Test1--7.jpg
│   |   └── images.jpg
├── doc/
│   ├── Tucil2_13523150_Laporan.pdf
├── README.md
```

## ⚙ Requirement dan Instalasi

### Prasyarat
Pastikan sudah terinstall:
* Java Development Kit (JDK) minimal versi 8  
  Download: https://jdk.java.net/  
* Git  
  Download: https://git-scm.com/downloads

## 🚀 Cara Menjalankan Program
### 1. Clone Repositori:
```bash
git clone https://github.com/username/Tucil2_13523150.git
cd Tucil2_13523150
```
### 2. Compile Program:
```bash
cd src
.\compile.bat
```
### 3. Jalankan Program:
```bash
cd ../bin
.\run.bat
```
### 4. Input Program:
```bash

Alamat gambar input (absolut path)

Metode error (1-5)

Threshold

Minimum Block Size

Target Compression

Output File Path hasil kompresi
```

## 🏆 Author
👤 Benedictus Nelson (13523150)

📧 Email: 13523150@std.stei.itb.ac.id

