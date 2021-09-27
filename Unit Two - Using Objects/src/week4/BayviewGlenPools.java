package week4;

public class BayviewGlenPools {
    public static void main(String[] args) {
        final int length = 20;
        final int shallowLength = 5;
        final int transition = 7;
        final int shallowHeight = 3;
        final int deepHeight = 8;
        final int width = 8;

        final int linerCost = 2;

        double surfaceArea = getSurfaceArea(length, width, shallowHeight, shallowLength, transition, deepHeight);
        double volume = getVolume(length, width, shallowHeight, shallowLength, transition, deepHeight);

        double cost = linerCost * surfaceArea;
        double volume90 = volume * 0.9;
    }

    private static double getVolume(int length, int width, int shallowHeight, int shallowLength, int transition, int deepHeight) {
        double shallowArea = shallowHeight * shallowLength;
        double transitionHeight = deepHeight - shallowHeight;
        double transitionLength = Math.sqrt(Math.pow(transition, 2) - Math.pow(transitionHeight, 2));
        double deepArea = deepHeight * (length - (shallowLength + transitionLength));
        double transitionArea = shallowHeight * transitionLength + (transitionLength * transitionHeight / 2);
        double volume = (deepArea + transitionArea + shallowArea) * width;
        return volume;
    }

    private static double getSurfaceArea(int length, int width, int shallowHeight, int shallowLength, int transition, int deepHeight) {
        double transitionHeight = deepHeight - shallowHeight;
        double transitionLength = Math.sqrt(Math.pow(transition, 2) - Math.pow(transitionHeight, 2));
        double deepArea = deepHeight * (length - (shallowLength + transitionLength));
        double transitionArea = shallowHeight * transitionLength + (transitionLength * transitionHeight / 2);
        double shallowArea = shallowHeight * shallowLength;
        double lengthWallArea = transitionArea + deepArea + shallowArea;
        double floorArea = (shallowLength + transition + shallowHeight + deepHeight + (length - (shallowLength + transitionLength))) * width;

        double surfaceArea = (floorArea + (lengthWallArea * 2));


        return surfaceArea;
    }


}
