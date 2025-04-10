// import java.awt.image.BufferedImage;
// import java.awt.Color;
// import java.io.File;
// import javax.imageio.ImageIO;

// public class ImageCompressor {
//     // Parameter input
//     private String inputPath;
//     private int errorMethod;
//     private double threshold;
//     private int minBlockSize;
//     private double targetCompression;
//     private String outputImagePath;
    
//     // Variabel untuk nyimpan gambar
//     private BufferedImage originalImage;
//     private BufferedImage compressedImage;
//     private QuadTreeNode root;
    
//     // Statistik output
//     private long executionTime;
//     private long originalSize;
//     private long compressedSize;
//     private int treeDepth;
//     private int totalNodes;
//     private double compressionPercentage;
    
    /**
     * Konstruktor ImageCompressor.
     * I.S.: Parameter input terdefinisi
     * F.S.: Objek ImageCompressor terbentuk
     */
    public ImageCompressor(String inputPath, int errorMethod, double threshold, int minBlockSize, double targetCompression, String outputImagePath) {
        this.inputPath = inputPath;
        this.errorMethod = errorMethod;
        this.threshold = threshold;
        this.minBlockSize = minBlockSize;
        this.targetCompression = targetCompression;
        this.outputImagePath = outputImagePath;
    }
    
    /**
     * Proses utama kompresi gambar dengan Quadtree.
     * I.S.: Gambar yang akan dikompresi tersedia
     * F.S.: Gambar hasil kompresi disimpan beserta statistik output
     */
    public void compress() {
      
    }
    
    /**
     * Membangun Quadtree dari blok gambar secara rekursif.
     * I.S.: Gambar original telah dibaca
     * F.S.: Return node Quadtree yang merepresentasikan blok gambar
     */
    private QuadTreeNode buildQuadTree(int x, int y, int width, int height) {
       
            return new QuadTreeNode(x, y, width, height, children);
        }
    
    /**
     * Menghitung error pada blok gambar berdasarkan metode yang dipilih.
     * I.S.: Blok gambar terdefinisi oleh (x, y, width, height)
     * F.S.: Mengembalikan nilai error 
     */
    private double calculateError(int x, int y, int width, int height) {

        return (sumSq / count) - (mean * mean);
    }
    
    /**
     * Menghitung rata-rata warna pada blok.
     * I.S.: Blok gambar terdefinisi oleh (x, y, width, height)
     * F.S.: Mengembalikan nilai Color rata-rata untuk blok
     */
    private Color calculateAverageColor(int x, int y, int width, int height) {
       
        return new Color(avgR, avgG, avgB);
    }
    
    /**
     * Rekonstruksi gambar terkompresi dari struktur Quadtree.
     * I.S.: Quadtree telah terbentuk
     * F.S.: Mengembalikan BufferedImage hasil rekonstruksi
     */
    private BufferedImage reconstructImage(QuadTreeNode node, int width, int height) {
       
        return image;
    }
    
    // Fungsi rekursif untuk mewarnai gambar 
    private void reconstructHelper(QuadTreeNode node, BufferedImage image) {
       
    }
    
    /**
     * Menghitung kedalaman pohon Quadtree.
     * I.S.: Quadtree telah terbentuk
     * F.S.: Return maxDepth pohon
     */
    private int calculateTreeDepth(QuadTreeNode node) {
      
            return maxDepth + 1;
        }
    
    
    /**
     * Menghitung jumlah total simpul pada Quadtree.
     * I.S.: Quadtree telah terbentuk
     * F.S.: Return jumlah node pada pohon
     */
    private int countNodes(QuadTreeNode node) {
     
            return count;
        }
    
    
    // Getter untuk output stats
    public long getExecutionTime() {
        return executionTime;
    }
    
    public long getOriginalSize() {
        return originalSize;
    }
    
    public long getCompressedSize() {
        return compressedSize;
    }
    
    public double getCompressionPercentage() {
        return compressionPercentage;
    }
    
    public int getTreeDepth() {
        return treeDepth;
    }
    
    public int getTotalNodes() {
        return totalNodes;
    }

