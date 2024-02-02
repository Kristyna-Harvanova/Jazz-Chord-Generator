package org.example;

public enum ScaleType {
    IONIAN(0),
    DORIAN(1),
    PHRYGIAN(2),
    LYDIAN(3),
    MIXOLYDIAN(4),
    AEOLIAN(5),
    LOCRIAN(6);
    
    private final Interval[] intervalsInBetween;

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
        this.intervalsInBetween = rotateIntervals(MAJOR_SCALE, rotation);
    }

    private static Interval[] rotateIntervals(Interval[] intervals, int rotation) {
        Interval[] rotated = new Interval[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            rotated[i] = intervals[(i + rotation) % intervals.length];
        }
        return rotated;
    }

    public Interval[] getIntervalsFromRoot() {
        Interval[] result = new Interval[7];
        int semitonesFromRoot = 0;
        int i = 0;
        for (Interval interval : intervalsInBetween) {
            semitonesFromRoot += interval.getSemitones();

            if (semitonesFromRoot == Interval.TRITONE_AUG4.getSemitones() && i == 2) {
                result[i++] = Interval.TRITONE_AUG4;
                continue;
            } else if (semitonesFromRoot == Interval.TRITONE_DIM5.getSemitones() && i == 3) {
                result[i++] = Interval.TRITONE_DIM5;
                continue;
            }
            result[i++] = Interval.fromSemitones(semitonesFromRoot);
        }
        return result;
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

