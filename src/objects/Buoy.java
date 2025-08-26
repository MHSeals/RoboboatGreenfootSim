package objects;

import greenfoot.Actor;
import model.Color;
import model.Vec2;

public class Buoy extends Actor implements CourseObject {
    private model.Color color;

    public Buoy(Color color) {
        this.color = color;

        // Set image based on color
        switch (color) {
            case RED:
                setImage("red_buoy.png");
                break;
            case GREEN:
                setImage("green_buoy.png");
                break;
            case BLUE:
                setImage("blue_buoy.png");
                break;
            case YELLOW:
                setImage("yellow_buoy.png");
                break;
            case BLACK:
                setImage("black_buoy.png");
                break;
        }

        this.getImage().scale((int) (0.1 * this.getImage().getWidth()), (int) (0.1 * this.getImage().getHeight()));
    }

    @Override
    public Vec2 getPosition() {
        return new Vec2(getX(), getY());
    }

    @Override
    public void setPosition(Vec2 position) {
        setLocation((int)position.getX(), (int)position.getY());
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
