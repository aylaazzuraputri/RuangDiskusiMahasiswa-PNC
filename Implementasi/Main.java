import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

class Mahasiswa {
    String nim, nama, jurusan, email;

    Mahasiswa(String nim, String nama, String jurusan, String email) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.email = email;
    }
}

class RuangDiskusi {
    int idRuang;
    String namaRuang;
    int kapasitas;
    boolean status;

    RuangDiskusi(int idRuang, String namaRuang, int kapasitas) {
        this.idRuang = idRuang;
        this.namaRuang = namaRuang;
        this.kapasitas = kapasitas;
        this.status = true;
    }

    void tampilkanRuang() {
        System.out.println("ID: " + idRuang + " | " + namaRuang + 
                           " | Kapasitas: " + kapasitas + 
                           " | Status: " + (status ? "Tersedia" : "DIPINJAM"));
    }

    void ubahStatus(boolean statusBaru) {
        this.status = statusBaru;
    }
}

class Peminjaman {
    int idPeminjaman;
    Mahasiswa mahasiswa;
    RuangDiskusi ruang;
    String tanggal, mulai, selesai;

    Peminjaman(int id, Mahasiswa m, RuangDiskusi r, String tgl, String mli, String sls) {
        this.idPeminjaman = id;
        this.mahasiswa = m;
        this.ruang = r;
        this.tanggal = tgl;
        this.waktuMulai = mli;
        this.waktuSelesai = sls;
    }

    void tampilkanPeminjaman() {
        System.out.println("Nama: " + mahasiswa.nama + 
                           " | Ruang: " + ruang.namaRuang + 
                           " | Waktu: " + waktuMulai + "-" + waktuSelesai);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<RuangDiskusi> daftarRuang = new ArrayList<>();
        ArrayList<Peminjaman> daftarPinjam = new ArrayList<>();

        // Data Awal
        daftarRuang.add(new RuangDiskusi(1, "Ruang A - Diskusi Umum", 10));
        daftarRuang.add(new RuangDiskusi(2, "Ruang B - Presentasi Kelompok", 20));
        daftarRuang.add(new RuangDiskusi(3, "Ruang C - Riset & Referensi", 15));

        int pilihan = -1;
        int counterPinjam = 1;

        while (pilihan != 0) {
            System.out.println("\n======= SISTEM PEMINJAMAN RUANG =======");
            System.out.println("1. Lihat Daftar Ruang");
            System.out.println("2. Pinjam Ruang");
            System.out.println("3. Lihat Daftar Peminjam");
            System.out.println("4. Selesaikan Pinjaman");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            
            try {
                pilihan = Integer.parseInt(sc.nextLine()); // Cara lebih aman mengambil angka
            } catch (Exception e) {
                System.out.println("Masukkan angka yang valid!");
                continue;
            }

            switch (pilihan) {
                case 1:
                    for (RuangDiskusi r : daftarRuang) r.tampilkanRuang();
                    break;

                case 2:
                    System.out.print("NIM: "); String nim = sc.nextLine();
                    System.out.print("Nama: "); String nama = sc.nextLine();
                    System.out.print("Jurusan: "); String jur = sc.nextLine();
                    System.out.print("Email: "); String mail = sc.nextLine();
                    Mahasiswa mhs = new Mahasiswa(nim, nama, jur, mail);

                    System.out.print("Pilih ID Ruang: ");
                    int id = Integer.parseInt(sc.nextLine());
                    
                    boolean ditemukan = false;
                    for (RuangDiskusi r : daftarRuang) {
                        if (r.idRuang == id) {
                            if (r.status) {
                                System.out.print("Waktu Mulai (HH:mm): "); String mli = sc.nextLine();
                                System.out.print("Waktu Selesai (HH:mm): "); String sls = sc.nextLine();
                                
                                r.ubahStatus(false);
                                daftarPinjam.add(new Peminjaman(counterPinjam++, mhs, r, "Today", mli, sls));
                                System.out.println("Sukses meminjam " + r.namaRuang);
                            } else {
                                System.out.println("Maaf, ruang sedang digunakan.");
                            }
                            ditemukan = true;
                            break;
                        }
                    }
                    if (!ditemukan) System.out.println("ID Ruang tidak ada.");
                    break;

                case 3:
                    if (daftarPinjam.isEmpty()) System.out.println("Kosong.");
                    for (Peminjaman p : daftarPinjam) p.tampilkanPeminjaman();
                    break;

                case 4:
                    System.out.print("Masukkan Nama Peminjam: ");
                    String cari = sc.nextLine();
                    Iterator<Peminjaman> it = daftarPinjam.iterator();
                    boolean hapus = false;
                    while (it.hasNext()) {
                        Peminjaman p = it.next();
                        if (p.mahasiswa.nama.equalsIgnoreCase(cari)) {
                            p.ruang.ubahStatus(true);
                            it.remove();
                            System.out.println("Peminjaman selesai.");
                            hapus = true;
                            break;
                        }
                    }
                    if(!hapus) System.out.println("Data tidak ditemukan.");
                    break;
            }
        }
        sc.close();
    }
}