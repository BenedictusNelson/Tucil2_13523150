import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // tampilan input
        System.out.print("Input alamat absolut gambar asli: ");
        String inputPath = sc.nextLine();
        
        System.out.print("Input metode perhitungan error (1=Variance, 2=MAD, 3=MaxDiff, 4=Entropy, 5=SSIM): ");
        int errorMethod = sc.nextInt();
        
        System.out.print("Input threshold: ");
        double threshold = sc.nextDouble();
        
        System.out.print("Input ukuran blok minimum: ");
        int minBlockSize = sc.nextInt();
        
        System.out.print("Input target persentase kompresi (0.0 jika nonaktif): ");
        double targetCompression = sc.nextDouble();
        sc.nextLine(); 
        
        System.out.print("Input alamat absolut untuk output gambar: ");
        String outputImagePath = sc.nextLine();
        
        // instansiasi objek kompresi
        ImageCompressor compressor = new ImageCompressor(inputPath, errorMethod, threshold, minBlockSize, targetCompression, outputImagePath);
        compressor.compress();
        
        // tampilan statistik kompresi
        System.out.println("Waktu eksekusi        : " + compressor.getExecutionTime() + " ms");
        System.out.println("Ukuran gambar awal    : " + compressor.getOriginalSize() + " bytes");
        System.out.println("Ukuran gambar kompres : " + compressor.getCompressedSize() + " bytes");
        System.out.println("Persentase kompresi   : " + compressor.getCompressionPercentage() + " %");
        System.out.println("Kedalaman pohon       : " + compressor.getTreeDepth());
        System.out.println("Banyak simpul pohon   : " + compressor.getTotalNodes());
        
        sc.close();
    }
}
