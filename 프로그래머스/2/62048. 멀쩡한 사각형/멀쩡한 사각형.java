class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        // long k = gcd(w,h);
        // long wr = (long)((long)w/(long)k);
        // long hr = (long)((long)h/(long)k);
        long count = 0;
        // for(long i=0 ; i<wr; i++){
        //     long cy = (long)((double)hr/(double)wr*(double)i);
        //     long ny = (long)(Math.ceil((double)hr/(double)wr*((double)i+1.0)));
        //     count+=ny-cy;
        // }
        for(long i=0 ; i<w; i++){
            long cy = (long)((double)i*(double)h/(double)w);
            long ny = (long)(Math.ceil((double)h/(double)w*((double)i+1.0)));
            count+=ny-cy;
        }
        return ((long)w*(long)h)-count;
    }
    
    public long gcd(long x, long y){
        if(x==0){
            return y;
        }
        return gcd(y%x,x);
    }
}

// y=-H/W*x
// y=-12/8*x
// y=-3/2*x