class Solution {
    //If you sort the positions array. The last element would be the one that would be the closest to the target. Just compare iteratively the last two cars time to reach. If the second last car reaches early despite it being behind the last car then that mean both the cards would meet somewhere and then they both would travel at the speed of the last car because the speed of that car would be less. 
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Cars[] cars = new Cars[n];

        for(int i = 0; i < n; i++){
            cars[i] = new Cars(position[i], (double) (target - position[i]) / speed[i]);
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(a.position, b.position));

        int t = n;
        int ans = 0;

        while(--t > 0){
            //If the time take by last vehicle is less then the prev vehicle then there would be no intersection for the cars so ans++;
            if(cars[t].time < cars[t - 1].time) ans++;            
            //If there is overlap then update. 
            else cars[t - 1] = cars[t];
        }

        //We add the last fleet at this point    
        return ans + 1;
    }
}

public class Cars{
    int position;
    double time;

    Cars(int position, double time){
        this.position = position;
        this.time = time;
    }
}