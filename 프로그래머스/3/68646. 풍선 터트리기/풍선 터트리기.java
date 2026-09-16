class Solution {
    public int solution(int[] a) {
        int answer = 0;
		
		//배열마다 최소값 저장
		int[] left_arr = new int[a.length];
		int[] right_arr = new int[a.length];
		
		
		left_arr[0] = a[0];
		right_arr[a.length-1] = a[a.length-1];
		for(int i=1; i<a.length; i++) {
			left_arr[i] = Math.min(left_arr[i-1], a[i]);
			
		}
		
		for(int i=a.length-2; i>=0; i--) {
			right_arr[i] = Math.min(right_arr[i+1], a[i]);
		}
		
		for(int i=0; i<a.length; i++) {
			
			if(a[i] == left_arr[i] || a[i] == right_arr[i]) answer++;
			
		}
		
			
			
		
        
        return answer;
    }
}