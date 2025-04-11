import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageCompressor {
    // Parameter input
    private String inputPath;
<<<<<<< HEAD
    private int errorMethod;
=======
>>>>>>> 1e23e536fc450e2acb747684f39abceead347018
    private double threshold;
    private int minBlockSize;
    private String outputImagePath;

    // Variabel untuk nyimpan gambar
    private BufferedImage originalImage;
    private BufferedImage compressedImage;
    private QuadTreeNode root;
    
    // Statistik output
    private long executionTime;
    private long originalSize;
    private long compressedSize;
    private int treeDepth;
    private int totalNodes;
    private double compressionPercentage;
    
    /**
     * Konstruktor ImageCompressor.
     * I.S.: Parameter input terdefinisi
     * F.S.: Objek ImageCompressor terbentuk
     */
    public ImageCompressor(String inputPath, int errorMethod, double threshold, int minBlockSize, double targetCompression, String outputImagePath) {
        this.inputPath = inputPath;
        this.threshold = threshold;
        this.minBlockSize = minBlockSize;
        this.outputImagePath = outputImagePath;
    }
    
    /**
     * Proses utama kompresi gambar dengan Quadtree.
     * I.S.: Gambar yang akan dikompresi tersedia
     * F.S.: Gambar hasil kompresi disimpan beserta statistik output
     */
    public void compress() {
        try {
            // baca gambar dan ukuran
            originalImage = ImageIO.read(new File(inputPath));
            originalSize = new File(inputPath).length();
            
            long startTime = System.currentTimeMillis();
            // bangun quadtree
            root = buildQuadTree(0, 0, originalImage.getWidth(), originalImage.getHeight());
            
            // image reconstruction from quadtree
            compressedImage = reconstructImage(root, originalImage.getWidth(), originalImage.getHeight());
            ImageIO.write(compressedImage, "png", new File(outputImagePath));
            compressedSize = new File(outputImagePath).length();
            
            // hitung stats kompresi
            compressionPercentage = (1 - ((double)compressedSize / originalSize)) * 100;
            executionTime = System.currentTimeMillis() - startTime;
            treeDepth = calculateTreeDepth(root);
            totalNodes = countNodes(root);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Membangun Quadtree dari blok gambar secara rekursif.
     * I.S.: Gambar original telah dibaca
     * F.S.: Return node Quadtree yang merepresentasikan blok gambar
     */
    private QuadTreeNode buildQuadTree(int x, int y, int width, int height) {
        double error = calculateError(x, y, width, height);
        
        // cek kondisi penghentian:
        if (error <= threshold || width <= minBlockSize || height <= minBlockSize) {
            Color avgColor = calculateAverageColor(x, y, width, height);
            return new QuadTreeNode(x, y, width, height, avgColor);
        } else {
            int halfWidth = width / 2;
            int halfHeight = height / 2;
            
            if (halfWidth == 0 || halfHeight == 0) {
                Color avgColor = calculateAverageColor(x, y, width, height);
                return new QuadTreeNode(x, y, width, height, avgColor);
            }
            
            QuadTreeNode child1 = buildQuadTree(x, y, halfWidth, halfHeight);
            QuadTreeNode child2 = buildQuadTree(x + halfWidth, y, width - halfWidth, halfHeight);
            QuadTreeNode child3 = buildQuadTree(x, y + halfHeight, halfWidth, height - halfHeight);
            QuadTreeNode child4 = buildQuadTree(x + halfWidth, y + halfHeight, width - halfWidth, height - halfHeight);
            
            QuadTreeNode[] children = new QuadTreeNode[]{child1, child2, child3, child4};
            return new QuadTreeNode(x, y, width, height, children);
        }
    }
    
    /**
     * Menghitung error pada blok gambar berdasarkan metode yang dipilih.
     * I.S.: Blok gambar terdefinisi oleh (x, y, width, height)
     * F.S.: Mengembalikan nilai error 
     *  Metode :
     *  1. Variance (default)
     *  2. Mean Absolute Deviation (MAD)
     *  3. MaxDiff (selisih nilai max min)
     *  4. Entropy
     *  5. Structural Similarity Index (SSIM) – bonus (error = 1 - SSIM)
     */
    private double calculateError(int x, int y, int width, int height) {
<<<<<<< HEAD
        int count = width * height;
        
        switch (errorMethod) {
            case 1:
                // Variance
                double sum = 0, sumSq = 0;
                for (int i = x; i < x + width; i++) {
                    for (int j = y; j < y + height; j++) {
                        Color c = new Color(originalImage.getRGB(i, j));
                        int pixel = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                        sum += pixel;
                        sumSq += pixel * pixel;
                    }
                }
                double mean = sum / count;
                return (sumSq / count) - (mean * mean);
=======
        double sum = 0, sumSq = 0;
        int count = width * height;
        
        for (int i = x; i < x + width; i++) {
            for (int j = y; j < y + height; j++) {
                Color c = new Color(originalImage.getRGB(i, j));

                int pixelValue = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                sum += pixelValue;
                sumSq += pixelValue * pixelValue;
            }
        }
        double mean = sum / count;
        return (sumSq / count) - (mean * mean);
    }
>>>>>>> 1e23e536fc450e2acb747684f39abceead347018
    
            case 2:
                // Mean Absolute Deviation 
                double sumVal = 0;
                for (int i = x; i < x + width; i++) {
                    for (int j = y; j < y + height; j++) {
                        Color c = new Color(originalImage.getRGB(i, j));
                        int pixel = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                        sumVal += pixel;
                    }
                }
                double meanVal = sumVal / count;
                            double madSum = 0;
                            for (int i = x; i < x + width; i++) {
                                for (int j = y; j < y + height; j++) {
                                    Color c = new Color(originalImage.getRGB(i, j));
                                    int pixel = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                                    madSum += Math.abs(pixel - meanVal);
                                }
                            }
                            return madSum / count;

            case 3:
                // MaxDiff
                int minVal = 255, maxVal = 0;
                for (int i = x; i < x + width; i++) {
                    for (int j = y; j < y + height; j++) {
                        Color c = new Color(originalImage.getRGB(i, j));
                        int pixel = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                        if (pixel < minVal) minVal = pixel;
                        if (pixel > maxVal) maxVal = pixel;
                    }
                }
                return maxVal - minVal;
                
            case 4:
                // Entropy: H = - Σ [p(i) * log2(p(i))]
                int[] histogram = new int[256];
                for (int i = x; i < x + width; i++) {
                    for (int j = y; j < y + height; j++) {
                        Color c = new Color(originalImage.getRGB(i, j));
                        int pixel = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                        histogram[pixel]++;
                    }
                }
                double entropy = 0;
                for (int i = 0; i < 256; i++) {
                    if (histogram[i] > 0) {
                        double p = (double) histogram[i] / count;
                        entropy += p * (Math.log(p) / Math.log(2));  // log base 2
                    }
                }
                return -entropy;
                
            case 5:
                // Structural Similarity Index (SSIM)
                double sumR = 0, sumG = 0, sumB = 0;
                for (int i = x; i < x + width; i++) {
                    for (int j = y; j < y + height; j++) {
                        Color c = new Color(originalImage.getRGB(i, j));
                        sumR += c.getRed();
                        sumG += c.getGreen();
                        sumB += c.getBlue();
                    }
                }
                double avgR = sumR / count;
                double avgG = sumG / count;
                double avgB = sumB / count;
                
                double varR = 0, varG = 0, varB = 0;
                for (int i = x; i < x + width; i++) {
                    for (int j = y; j < y + height; j++) {
                        Color c = new Color(originalImage.getRGB(i, j));
                        varR += Math.pow(c.getRed() - avgR, 2);
                        varG += Math.pow(c.getGreen() - avgG, 2);
                        varB += Math.pow(c.getBlue() - avgB, 2);
                    }
                }
                varR /= count;
                varG /= count;
                varB /= count;
                
                double C2 = Math.pow(0.03 * 255, 2);
                double ssimR = C2 / (varR + C2);
                double ssimG = C2 / (varG + C2);
                double ssimB = C2 / (varB + C2);
                double avgSSIM = (ssimR + ssimG + ssimB) / 3.0;
                return 1.0 - avgSSIM;
                
            default:
                double defSum = 0, defSumSq = 0;
                for (int i = x; i < x + width; i++) {
                    for (int j = y; j < y + height; j++) {
                        Color c = new Color(originalImage.getRGB(i, j));
                        int pixel = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                        defSum += pixel;
                        defSumSq += pixel * pixel;
                    }
                }
                double defMean = defSum / count;
                return (defSumSq / count) - (defMean * defMean);
        }
    }

    /**
     * Menghitung rata-rata warna pada blok.
     * I.S.: Blok gambar terdefinisi oleh (x, y, width, height)
     * F.S.: Mengembalikan nilai Color rata-rata untuk blok
     */
    private Color calculateAverageColor(int x, int y, int width, int height) {
        long sumR = 0, sumG = 0, sumB = 0;
        int count = width * height;
        
        for (int i = x; i < x + width; i++) {
            for (int j = y; j < y + height; j++) {
                Color c = new Color(originalImage.getRGB(i, j));
                sumR += c.getRed();
                sumG += c.getGreen();
                sumB += c.getBlue();
            }
        }
        
        int avgR = (int)(sumR / count);
        int avgG = (int)(sumG / count);
        int avgB = (int)(sumB / count);
        return new Color(avgR, avgG, avgB);
    }
    
    /**
     * Rekonstruksi gambar terkompresi dari struktur Quadtree.
     * I.S.: Quadtree telah terbentuk
     * F.S.: Mengembalikan BufferedImage hasil rekonstruksi
     */
    private BufferedImage reconstructImage(QuadTreeNode node, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        reconstructHelper(node, image);
        return image;
    }
    
    // Fungsi rekursif untuk mewarnai gambar 
    private void reconstructHelper(QuadTreeNode node, BufferedImage image) {
        if (node.isLeaf()) {
            for (int i = node.x; i < node.x + node.width; i++) {
                for (int j = node.y; j < node.y + node.height; j++) {
                    image.setRGB(i, j, node.averageColor.getRGB());
                }
            }
        } else {
            for (QuadTreeNode child : node.children) {
                reconstructHelper(child, image);
            }
        }
    }
    
    /**
     * Menghitung kedalaman pohon Quadtree.
     * I.S.: Quadtree telah terbentuk
     * F.S.: Return maxDepth pohon
     */
    private int calculateTreeDepth(QuadTreeNode node) {
        if (node.isLeaf()) {
            return 1;
        } else {
            int maxDepth = 0;
            for (QuadTreeNode child : node.children) {
                int childDepth = calculateTreeDepth(child);
                if (childDepth > maxDepth) {
                    maxDepth = childDepth;
                }
            }
            return maxDepth + 1;
        }
    }
    
    /**
     * Menghitung jumlah total simpul pada Quadtree.
     * I.S.: Quadtree telah terbentuk
     * F.S.: Return jumlah node pada pohon
     */
    private int countNodes(QuadTreeNode node) {
        if (node.isLeaf()) {
            return 1;
        } else {
            int count = 1;
            for (QuadTreeNode child : node.children) {
                count += countNodes(child);
            }
            return count;
        }
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
}
