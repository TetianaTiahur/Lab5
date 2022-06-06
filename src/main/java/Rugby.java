import com.example.lab5.Kulka;

public class Rugby extends Kulka {

//    private double rx;
//    private double ry;

    protected double rx;
    protected double ry;
    protected double omega;
    protected double rot;

    public Rugby(double xPos, double yPos, double xSpeed, double ySpeed, double omega, double rx, double ry) {
        super(xPos,yPos,xSpeed,ySpeed);
        this.rx = rx;
        this.ry = ry;
        this.omega=omega;
    }
}
