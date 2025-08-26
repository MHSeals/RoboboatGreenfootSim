package model;

public enum PoleBuoyColor {
    RED, GREEN;

    public Color toColor() {
        return this == RED ? Color.RED : Color.GREEN;
    }
}
