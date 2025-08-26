import greenfoot.Actor;

public class Boat extends Actor {
    // Physics state
    private double x, y; // position
    private double angle; // orientation in degrees
    private double vx, vy; // velocity
    private double angularVelocity; // angular velocity (deg/frame)

    // Thruster speeds
    private double leftThruster;
    private double rightThruster;

    // Physics constants
    private static final double THRUSTER_FORCE = 40.0; // force per thruster unit (tuned for responsiveness)
    private static final double THRUSTER_TORQUE = 10.0; // torque per thruster unit difference (tuned for responsiveness)
    private static final double FRICTION = 0.995; // velocity damping (less friction)
    private static final double ANGULAR_FRICTION = 0.99; // angular velocity damping (less friction)

    // For delta time calculation
    private long lastTime = -1;

    public Boat(int x, int y) {
        this.x = x;
        this.y = y;
        this.angle = 270; // 270 degrees is up in Greenfoot
        this.vx = 0;
        this.vy = 0;
        this.angularVelocity = 0;
        this.leftThruster = 0;
        this.rightThruster = 0;
        setLocation((int)x, (int)y);
        setRotation((int)angle);

        setImage("boat.png");
        this.getImage().scale((int)(0.1 * this.getImage().getWidth()), (int)(0.1 * this.getImage().getHeight()));
    }

    public void setLeftThruster(double speed) {
        this.leftThruster = speed;
    }

    public void setRightThruster(double speed) {
        this.rightThruster = speed;
    }

    @Override
    public void act() {
        // Calculate delta time in seconds
        long now = System.nanoTime();
        double deltaTime;
        if (lastTime < 0) {
            deltaTime = 0.016; // Assume ~60 FPS for first frame
        } else {
            deltaTime = (now - lastTime) / 1_000_000_000.0;
        }
        lastTime = now;

        // Calculate forward force
        double avgThruster = (leftThruster + rightThruster) / 2.0;
        double force = avgThruster * THRUSTER_FORCE;
        double rad = Math.toRadians(angle);
        vx += Math.cos(rad) * force * deltaTime;
        vy += Math.sin(rad) * force * deltaTime;

        // Calculate torque (rotation)
        double torque = (rightThruster - leftThruster) * THRUSTER_TORQUE;
        angularVelocity += torque * deltaTime;

        // Apply friction
        vx *= Math.pow(FRICTION, deltaTime * 60); // scale friction for deltaTime
        vy *= Math.pow(FRICTION, deltaTime * 60);
        angularVelocity *= Math.pow(ANGULAR_FRICTION, deltaTime * 60);

        // Update position and angle
        x += vx * deltaTime;
        y += vy * deltaTime;
        angle += angularVelocity * deltaTime;

        // Keep angle in [0, 360)
        angle = (angle + 360) % 360;

        // Update Greenfoot actor
        setLocation((int)x, (int)y);
        setRotation((int)angle);
    }
}
