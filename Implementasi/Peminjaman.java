public class Peminjaman {
    int idPeminjaman;
    Mahasiswa mahasiswa;
    RuangDiskusi ruang;
    String tanggal;
    String waktuMulai;
    String waktuSelesai;

    public Peminjaman(int idPeminjaman, Mahasiswa mahasiswa, RuangDiskusi ruang,
                      String tanggal, String waktuMulai, String waktuSelesai) {
        this.idPeminjaman = idPeminjaman;
        this.mahasiswa = mahasiswa;
        this.ruang = ruang;
        this.tanggal = tanggal;
        this.waktuMulai = waktuMulai;
        this.waktuSelesai = waktuSelesai;
    }

    public void tampilkanPeminjaman() {
        System.out.println("Nama: " + mahasiswa.nama +
                           " | Ruang: " + ruang.namaRuang +
                           " | Waktu: " + waktuMulai + "-" + waktuSelesai);
    }
}
