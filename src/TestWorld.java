import model.Color;
import model.PoleBuoyColor;
import model.Vec2;
import objects.Buoy;
import objects.PoleBuoy;

public class TestWorld extends SimWorld {
    public TestWorld() {
        super(new Vec2(150, 500));

        // Add some pole buoys for testing
        addCourseObject(new PoleBuoy(PoleBuoyColor.RED), 100, 150);
        addCourseObject(new PoleBuoy(PoleBuoyColor.GREEN), 200, 150);
        addCourseObject(new PoleBuoy(PoleBuoyColor.RED), 100, 350);
        addCourseObject(new PoleBuoy(PoleBuoyColor.GREEN), 200, 350);

        addCourseObject(new Buoy(Color.RED), 400, 400);
    }

    public void act() {
        Boat boat = this.getBoat();
        if (boat != null) {
            if (greenfoot.Greenfoot.isKeyDown("q")) {
                boat.setLeftThruster(1.0);
            } else if (greenfoot.Greenfoot.isKeyDown("a")) {
                boat.setLeftThruster(-1.0);
            } else {
                boat.setLeftThruster(0.0);
            }

            if (greenfoot.Greenfoot.isKeyDown("e")) {
                boat.setRightThruster(1.0);
            } else if (greenfoot.Greenfoot.isKeyDown("d")) {
                boat.setRightThruster(-1.0);
            } else {
                boat.setRightThruster(0.0);
            }

            if (greenfoot.Greenfoot.isKeyDown("w")) {
                boat.setLeftThruster(1.0);
                boat.setRightThruster(1.0);
            } else if (greenfoot.Greenfoot.isKeyDown("s")) {
                boat.setLeftThruster(-1.0);
                boat.setRightThruster(-1.0);
            }
        }
    }
}
