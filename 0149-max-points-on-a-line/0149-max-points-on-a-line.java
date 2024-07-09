class Solution {
    public int maxPoints(int[][] points)//BrruteForceSolution 
    {
        int i,j,k;
        int secondp=0;
        int dy,dx,dy_,dx_;
        int npoints=0;
        int maxpoints=0;
        if(points.length==1)
            return 1;
        for(i=0;i<points.length;i++)
        {
            for(j=i+1;j<points.length;j++)
            {
                npoints=2;
                dy = points[j][1]-points[i][1];
                dx = points[j][0]-points[i][0];
                for(k=j+1;k<points.length;k++)
                {
                    dy_ = points[k][1]-points[i][1];   
                    dx_ = points[k][0]-points[i][0];    
                    if( (dy * dx_) == (dy_ * dx) )//If dx or dx_=0 divide by zero error
                        npoints++;   
                }
                if(npoints>maxpoints)
                    maxpoints=npoints;
            }
        }    
        return maxpoints;
    }
}