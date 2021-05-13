/*
 * @lc app=leetcode id=1603 lang=java
 *
 * [1603] Design Parking System
 */

// @lc code=start
class ParkingSystem {
    private int big;
    private int medium;
    private int small;
    public ParkingSystem(int big, int medium, int small) {
        this.big=big;
        this.medium=medium;
        this.small=small;
    }
    
    public boolean addCar(int carType) {
        switch(carType){
            case 1:
                if(this.big>=1){
                    this.big--;
                    return true;
                }
                return false;
            case 2:
                if (this.medium >= 1) {
                    this.medium--;
                    return true;
                }
                return false;
            default:
                if (this.small >= 1) {
                    this.small--;
                    return true;
                }
                return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
// @lc code=end

