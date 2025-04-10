import java.awt.Color;

public class QuadTreeNode {
    public int x, y, width, height;
    public Color averageColor;
    public QuadTreeNode[] children; 

    // Konstruktor node daun dgn rata2 warna
    public QuadTreeNode(int x, int y, int width, int height, Color averageColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.averageColor = averageColor;
        this.children = null;
    }
    
    // Konstruktor node internal dengan anak2
    public QuadTreeNode(int x, int y, int width, int height, QuadTreeNode[] children) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.children = children;
        this.averageColor = null;
    }
    
    // Fungsi untuk cek apakah node leaf
    public boolean isLeaf() {
        return (children == null);
    }
}
