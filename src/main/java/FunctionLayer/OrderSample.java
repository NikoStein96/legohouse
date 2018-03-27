package FunctionLayer;

public class OrderSample {
    
    
    private int height;
    private int width;
    private int length;
    private int id;
    
    public OrderSample(int heigh, int width, int length) {
        this.height = heigh;
        this.width = width;
        this.length = length;
    }

    public int getHeigh() {
        return height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeigh(int heigh) {
        this.height = heigh;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "OrderSample" + " height =" + height + " width =" + width + " length =" + length + " id =" + id + "\n";
    }
    
    
    
    
    
}