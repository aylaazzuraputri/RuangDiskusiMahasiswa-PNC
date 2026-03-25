public class Mahasiswa {
    private String nim;
    private String nama;
    private String jurusan;

    public Mahasiswa(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    public void tampilkanData() {
        System.out.println("NIM: " + nim + ", Nama: " + nama + ", Jurusan: " + jurusan);
    }
}