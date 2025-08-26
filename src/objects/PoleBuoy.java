package objects;

import model.PoleBuoyColor;
import model.Vec2;

public class PoleBuoy extends Buoy {
    public PoleBuoy(PoleBuoyColor color) {
        super(color.toColor());

        // Set image based on color
        switch (color) {
            case RED:
                setImage("red_pole_buoy.png");
                break;
            case GREEN:
                setImage("green_pole_buoy.png");
                break;
        }

        this.getImage().scale((int) (0.15 * this.getImage().getWidth()), (int) (0.15 * this.getImage().getHeight()));
    }
}
