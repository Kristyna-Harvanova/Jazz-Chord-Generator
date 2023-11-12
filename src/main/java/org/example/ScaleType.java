package org.example;

public enum ScaleType {
    IONIAN(0),
    DORIAN(1),
    PHRYGIAN(2),
    LYDIAN(3),
    MIXOLYDIAN(4),
    AEOLIAN(5),
    LOCRIAN(6);
    
    private final Interval[] intervals;

    ScaleType(int rotation) {
        Interval[] MAJOR_SCALE = {
                Interval.MAJOR_SECOND,
                Interval.MAJOR_SECOND,
                Interval.MINOR_SECOND,
                Interval.MAJOR_SECOND,
                Interval.MAJOR_SECOND,
                Interval.MAJOR_SECOND,
                Interval.MINOR_SECOND
        };
        this.intervals = rotateIntervals(MAJOR_SCALE, rotation);
    }

    private static Interval[] rotateIntervals(Interval[] intervals, int rotation) {
        Interval[] rotated = new Interval[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            rotated[i] = intervals[(i + rotation) % intervals.length];
        }
        return rotated;
    }

    /*public Interval[] getIntervals() {
        return intervals;
    }*/

    /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.name()).append(": ");
        for (Interval interval : intervals) {
            sb.append(interval.name()).append(", ");
        }
        sb.setLength(sb.length() - 2); // Remove trailing comma and space
        return sb.toString();
    }*/
}

