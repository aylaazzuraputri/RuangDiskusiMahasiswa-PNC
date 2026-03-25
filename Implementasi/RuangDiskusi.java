public class RuangDiskusi {
    private String idRuang;
    private int kapasitas;
    private boolean status; // true = tersedia, false = dipinjam

    public RuangDiskusi(String idRuang, int kapasitas) {
        this.idRuang = idRuang;
        this.kapasitas = kapasitas;
        this.status = true;
    }

    public void tampilkanRuang() {
        System.out.println("Ruang: " + idRuang + ", Kapasitas: " + kapasitas + ", Status: " + (status ? "Tersedia" : "Dipinjam"));
    }

    public boolean isTersedia() {
        return status;
    }

    public void pinjam() {
        if (status) {
            status = false;
            System.out.println("Ruang " + idRuang + " berhasil dipinjam.");
        } else {
            System.out.println("Ruang " + idRuang + " sudah dipinjam.");
        }
    }
}