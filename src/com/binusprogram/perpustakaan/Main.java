package com.binusprogram.perpustakaan;

import java.util.Scanner;

class Buku {
    private String jenisBuku;
    private int dendaPerHari;

    public Buku(String jenisBuku, int dendaPerHari) {
        this.jenisBuku = jenisBuku;
        this.dendaPerHari = dendaPerHari;
    }

    public String getJenisBuku() {
        return jenisBuku;
    }

    public int getDendaPerHari() {
        return dendaPerHari;
    }
}

class Peminjaman {
    private Buku buku;
    private int jumlahHariPinjam;

    public Peminjaman(Buku buku, int jumlahHariPinjam) {
        this.buku = buku;
        this.jumlahHariPinjam = jumlahHariPinjam;
    }

    public String getJenisBuku() {
        return buku.getJenisBuku();
    }

    public int getJumlahHariPinjam() {
        return jumlahHariPinjam;
    }

    public int getJumlahHariTerlambat() {
        return jumlahHariPinjam - 10;
    }

    public int hitungDenda() {
        int jumlahHariTerlambat = jumlahHariPinjam - 10;
        return jumlahHariTerlambat * buku.getDendaPerHari();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Perpustakaan David!");

        // Daftar jenis buku yang tersedia
        Buku pelajaran = new Buku("Pelajaran", 2000);
        Buku novel = new Buku("Novel", 5000);
        Buku skripsi = new Buku("Skripsi", 10000);

        // Pilihan jenis buku untuk pengguna
        System.out.println("Silakan pilih jenis buku yang ingin dipinjam: ");
        System.out.println("1. Pelajaran");
        System.out.println("2. Novel");
        System.out.println("3. Skripsi");
        System.out.print("Pilihan Anda: ");
        int pilihanBuku = scanner.nextInt();

        // Masukkan dari pengguna untuk jumlah hari peminjaman
        System.out.print("Masukkan jumlah hari peminjaman: ");
        int jumlahHariPinjam = scanner.nextInt();

        // Pilihan peminjaman berdasarkan jenis buku dan jumlah hari peminjaman
        Peminjaman peminjaman = switch (pilihanBuku) {
            case 1 -> new Peminjaman(pelajaran, jumlahHariPinjam);
            case 2 -> new Peminjaman(novel, jumlahHariPinjam);
            case 3 -> new Peminjaman(skripsi, jumlahHariPinjam);
            default -> null;
        };

        // Menampilkan hasil perhitungan denda
        if (peminjaman != null) {
            int denda = peminjaman.hitungDenda();
            if (denda > 0) {
                System.out.println("Anda meminjam buku jenis " + peminjaman.getJenisBuku() + " selama " + peminjaman.getJumlahHariPinjam() + " hari.");
                System.out.println("Anda terlambat mengembalikan selama " + peminjaman.getJumlahHariTerlambat() + " hari.");
                System.out.println("Denda yang harus dibayar sebesar Rp" + denda + ".");
            } else {
                System.out.println("Anda meminjam buku jenis " + peminjaman.getJenisBuku() + " selama " + peminjaman.getJumlahHariPinjam() + " hari. Tidak ada denda yang dikenakan.");
            }
        } else {
            System.out.println("Maaf, pilihan buku yang Anda masukkan tidak valid.");
        }
        scanner.close();
    }
}