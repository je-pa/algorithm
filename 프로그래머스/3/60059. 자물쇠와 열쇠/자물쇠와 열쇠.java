class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        for(int t=0 ; t<4 ; t++){
            // so(key);
            for(int pi = -key.length ; pi < lock.length ; pi++){
                for(int pj= -key[0].length ; pj < lock[0].length ; pj++){
                    if(check(lock, key, pi, pj)) return true;
                }
            }
            if(t!=3)key = turn(key);
        }
        return false;
    }
    void so(int[][] key){
        for(int i=0 ; i<key.length ; i++){
            for(int j=0 ; j<key[0].length ; j++){
                System.out.print(key[i][j]+" ");
            }
            System.out.println();
        }
    }
    boolean isOut(int i, int j, int N, int M){
        return i < 0 || j < 0 || i>=N || j >=M;
    }
    boolean check(int[][] lock, int[][] key, int ki, int kj){
        for(int i=0 ; i<lock.length ; i++){
            for(int j=0 ; j<lock[0].length ; j++){
                int nki = - ki + i;
                int nkj = -kj + j;
                if(lock[i][j] == 0){
                    if(isOut(nki, nkj, key.length , key[0].length)) return false;
                    if(key[nki][nkj] == 0) return false;
                }else if(lock[i][j] == 1){
                    if(isOut(nki, nkj, key.length , key[0].length)) continue;
                    if(key[nki][nkj] == 1) return false;
                }
            }
        }
        return true;
    }
    int[][] turn(int[][] key){
        int[][] na = new int[key[0].length][key.length];
        for(int i = 0 ; i<na.length ; i++){
            for(int j=0 ; j<na[0].length ; j++){
                na[i][j] = key[key.length-j-1][i];
            } 
        }
        return na;
    }
}