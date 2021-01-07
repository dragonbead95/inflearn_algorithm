package section02_Recursion_05;

public class Blob {
	private static int N=8;
	private static int[][] image = {
			{1,0,0,0,0,0,0,1},
			{0,1,1,0,0,1,0,0},
			{1,1,0,0,1,0,1,0},
			{0,0,0,0,0,1,0,0},
			{0,1,0,1,0,1,0,0},
			{0,1,0,1,0,1,0,0},
			{1,0,0,0,1,0,0,1},
			{0,1,1,0,0,1,1,1},
			
	};
	private static final int BACKGROUND_PIXCEL = 0; // πË∞Ê «»ºø
	private static final int IMAGE_PIXCEL = 1;	 	// ¿ÃπÃ¡ˆ «»ºø
	private static final int VISITED_PIXCEL = 2;	// πÊπÆ«— «»ºø
	
	public static int countingCell(int x, int y)
	{
		if(x<0 || y<0 || x>=N || y>=N)
		{
			return 0;
		}
		else if(image[x][y]!=IMAGE_PIXCEL || image[x][y]==VISITED_PIXCEL)
		{
			return 0;
		}
		else 
		{
			image[x][y] = VISITED_PIXCEL;
			return 1 +
			countingCell(x-1, y) +
			countingCell(x-1, y+1) +
			countingCell(x, y+1) +
			countingCell(x+1, y+1) +
			countingCell(x+1, y) +
			countingCell(x+1, y-1) +
			countingCell(x, y-1) +
			countingCell(x-1, y-1);
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countingCell(5, 3));
	}

}
