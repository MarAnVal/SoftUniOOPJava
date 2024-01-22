package JediGalaxy;

public class Galaxy {
    int[][] galaxyMatrix;
    final int numRows;
    final int numCols;

    public Galaxy(int[][] galaxyMatrix) {
        this.galaxyMatrix = galaxyMatrix;
        this.numRows = galaxyMatrix.length;
        this.numCols = galaxyMatrix[0].length;
    }
    public boolean isInside(Coordinates coords) {
        return coords.row >= 0 && coords.row < this.numRows && coords.col >= 0 && coords.col < this.numCols;
    }

    public int starValue(Coordinates coordinates){
        return this.galaxyMatrix[coordinates.row][coordinates.col];
    }
    public void destroyStar(Coordinates coordinates){
        this.galaxyMatrix[coordinates.row][coordinates.col] = 0;
    }

}
