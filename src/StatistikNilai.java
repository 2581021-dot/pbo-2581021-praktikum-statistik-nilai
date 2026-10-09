import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class StatistikNilai {

    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            int input = scanner.nextInt();

            if (input == SELESAI) {
                break;
            }

            if (input < 0 || input > 100) {
                System.out.println("   Ditolak, harus 0-100");
                continue;
            }

            daftar.add(input);

        } while (true);

        if (daftar.isEmpty()) {
            System.out.println("Tidak ada data nilai yang dimasukkan.");
            scanner.close();
            return;
        }

        System.out.println();
        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());

        double total = 0;
        for (int nilai : daftar) {
            total += nilai;
        }
        double rataRata = total / daftar.size();

        System.out.println("Rata-rata       : " + String.format(Locale.forLanguageTag("id-ID"), "%.2f", rataRata));

        // Tertinggi & terendah: keduanya dimulai dari daftar.get(0).
        // Kenapa? Kalau terendah dimulai dari 0, hasilnya salah saat semua nilai > 0
        // (misal 80, 90 -> terendah tetap 0). Kalau tertinggi dimulai dari angka tetap
        // seperti 0 atau 100, hasilnya bisa salah juga. Elemen pertama pasti bagian
        // dari data, jadi titik awal paling aman untuk dibandingkan.
        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);
        for (int nilai : daftar) {
            if (nilai > tertinggi) tertinggi = nilai;
            if (nilai < terendah) terendah = nilai;
        }
        System.out.println("Tertinggi       : " + tertinggi);
        System.out.println("Terendah        : " + terendah);
        scanner.close();
    }
}
