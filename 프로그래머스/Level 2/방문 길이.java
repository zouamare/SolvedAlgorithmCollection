import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 5;
        int y = 5;
        boolean[][][][] visited = new boolean[11][11][11][11];
        for(char c : dirs.toCharArray()){
            int nx = x, ny = y;
            switch(c){
                case 'U':
                    nx = x;
                    ny = y - 1;
                    break;
                case 'D':
                    nx = x;
                    ny = y + 1;
                    break;
                case 'L':
                    nx = x - 1;
                    ny = y;
                    break;
                case 'R':
                    nx = x + 1;
                    ny = y;
                    break;
            }
            if(nx < 0 || nx > 10 || ny < 0 || ny > 10)
                continue;
            if(!visited[x][y][nx][ny] && !visited[nx][ny][x][y]){
                answer++;
                visited[x][y][nx][ny] = true;
                visited[nx][ny][x][y] = true;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
}