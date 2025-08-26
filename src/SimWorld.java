import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;
import greenfoot.World;
import model.Vec2;
import objects.CourseObject;

import java.util.ArrayList;

public class SimWorld extends World {
    private ArrayList<CourseObject> objects;
    private Boat boat;

    public SimWorld(Vec2 boatStartPosition) {
        super(800, 600, 1);

        GreenfootImage background = this.getBackground();
        background.setColor(new Color(91, 125, 235));
        background.fill();

        this.objects = new ArrayList<>();

        this.boat = new Boat((int)boatStartPosition.getX(), (int)boatStartPosition.getY());
        this.addObject(boat, (int)boatStartPosition.getX(), (int)boatStartPosition.getY());
    }

    public SimWorld() {
        this(new Vec2(0, 0));
    }

    public Boat getBoat() {
        return this.boat;
    }

    public void addCourseObject(CourseObject object, int x, int y) {
        this.objects.add(object);
        if (object instanceof Actor actor) {
            super.addObject(actor, x, y);
        }
    }
}
