# Roboboat Greenfoot Sim
this sim is intended for new members to have an easy way to begin creating path planning/navigation algorithms

## Boat
the boat is a physics-based boat that behaves roughly similar to the real boat on water. it is controlled by 2 independent thrusters on the left and right side of the boat

example world for testing:

```java
import model.PoleBuoyColor;
import model.Vec2;
import objects.PoleBuoy;

public class TestWorld extends SimWorld {
    public TestWorld() {
        super(new Vec2(150, 500));

        // Add some pole buoys for testing
        addCourseObject(new PoleBuoy(PoleBuoyColor.RED), 100, 150);
        addCourseObject(new PoleBuoy(PoleBuoyColor.GREEN), 200, 150);
        addCourseObject(new PoleBuoy(PoleBuoyColor.RED), 100, 350);
        addCourseObject(new PoleBuoy(PoleBuoyColor.GREEN), 200, 350);
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

```