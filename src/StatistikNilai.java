import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;
import java.util.Collections;

public class StatistikNilai {

    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Masukkan nilai (0-100)");
        System.out.println("Ketik -1 kalau sudah selesai.");
        System.out.println("---------------------------------");

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

        System.out.println("---------------------------------");
        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());

        double total = 0;
        for (int nilai : daftar) {
            total += nilai;
        }
        double rataRata = total / daftar.size();
        System.out.println("Rata-rata       : " + String.format(Locale.forLanguageTag("id-ID"), "%.2f", rataRata));

        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);
        for (int nilai : daftar) {
            if (nilai > tertinggi) tertinggi = nilai;
            if (nilai < terendah) terendah = nilai;
        }
        System.out.println("Tertinggi       : " + tertinggi);
        System.out.println("Terendah        : " + terendah);

        int jumlahDiAtasRataRata = 0;
        for (int nilai : daftar) {
            if (nilai > rataRata) jumlahDiAtasRataRata++;
        }
        System.out.println("Di atas rata2   : " + jumlahDiAtasRataRata + " orang");

        int[] jumlahGrade = new int[5];
        for (int nilai : daftar) {
            if (nilai >= 80)      jumlahGrade[0]++;
            else if (nilai >= 70) jumlahGrade[1]++;
            else if (nilai >= 60) jumlahGrade[2]++;
            else if (nilai >= 50) jumlahGrade[3]++;
            else                  jumlahGrade[4]++;
        }

        ArrayList<Integer> terurut = new ArrayList<>(daftar);
        Collections.sort(terurut);

        String[] namaGrade = {"A", "B", "C", "D", "E"};
        System.out.print("Distribusi      : ");
        for (int i = 0; i < jumlahGrade.length; i++) {
            System.out.print(namaGrade[i] + "=" + jumlahGrade[i]);
            if (i < jumlahGrade.length - 1) System.out.print(" ");
        }
        System.out.println();

        System.out.println("Terurut         : " + terurut);
        System.out.println("Urutan asli     : " + daftar);
        System.out.println("---------------------------------");

        scanner.close();
    }
}
