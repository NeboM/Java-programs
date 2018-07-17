package submarine;
import java.util.Random;
class Map{
	private char map[][];
	private int size;
	
	public Map(int size) {
		this.size = size;
		this.map = new char[size][size];
		for(int i=0; i<size; i++) 
			for(int j=0; j<size; j++)
				this.map[i][j] = '.';
	}
	public void addEnemy() {
		for(int i=3; i>=0; i--) {
			Random rand = new Random();
			boolean flag = false;
			do {
				// we get random indexes for the enemy submarine position
				int x = rand.nextInt(size);
				int y = rand.nextInt(size);
				if(map[x][y] == '.') {
					flag = true;
					map[x][y] = (char)(i+1+'0');
					int j = 0;
					while(j < i) {
						int extendSubmarine = rand.nextInt(4);
						switch(extendSubmarine) {
							case 0: // left
								if(y > 0 && map[x][y-1] == '.') { map[x][--y] = (char)(i+1+'0'); j++;  } 
								break;
							case 1: // right
								if(size-1-y > 0 && map[x][y+1] == '.') {map[x][++y] = (char)(i+1+'0'); j++;  }
								break;
							case 2: // top 
								if(x > 0 && map[x-1][y] == '.') { map[--x][y] = (char)(i+1+'0'); j++;  }
								break;
							case 3: // bottom
								if(size-1-x > 0 && map[x+1][y] == '.') { map[++x][y] = (char)(i+1+'0'); j++; }
								break;
						}
					}
				}
			}while(flag == false);
		}		
	}
	public void print() {
		for(int i=0; i<size; i++) { 
			for(int j=0; j<size; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
public class Submarine {
	public static void main(String[] args) {
		Map map1 = new Map(10);
		map1.addEnemy();
		map1.print();
	}
}
