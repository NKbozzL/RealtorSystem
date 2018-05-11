/**
Name: Nicholas Boesel
Date: 4/13/2016
Course/Section: IT 206.001
Assignment: Programming Assignment 8

Subclass of Residence, adds limits to the number of bathrooms, bedrooms, the insurance,whether or not there's a parking space, and the rent.
It also allows the user to change all of these valuse and give outputs based around mothly cost and reports on the individual details
on each Apartment listing.*/
public class Apt extends Residence
{
   private static final int MIN_BEDS=1;
   private static final int MAX_BEDS=2;
   private static final int MIN_BATHS=1;
   private static final int MAX_BATHS=2;
   private static final double MIN_RENT=400.0;
   private static final double MAX_RENT=1000.0;
   private static final double MIN_INS=50.0;
   private double rent;
   private double insurance;
   private boolean hasParking;
   //Constructor -uses Residence
   public Apt()
   {
      super();
   }
   
   //Returns the minimum allowed number of bedrooms
   public static int getMIN_BEDS()
   {
      return MIN_BEDS;
   }
   //Returns the maximum allowed number of bedrooms
   public static int getMAX_BEDS()
   {
      return MAX_BEDS;
   }
   //Returns the number of bedrooms
   public int getBeds()
   {
   return super.getBeds();
   }
   //Sets the number of bedrooms to myBeds
   public boolean setBeds(int myBeds)
   {
      if(myBeds>=MIN_BEDS && myBeds<=MAX_BEDS)
      {
      boolean good=super.setBeds(myBeds);
      return good;
      }
      else
      {return false;}
   }
   
   //Sets the number of bathrooms to myBaths
   public boolean setBaths(int myBaths)
   {
      if(myBaths>=MIN_BATHS && myBaths<=MAX_BATHS)
      {
      boolean good=super.setBaths(myBaths);
      return good;
      }
      else
      {return false;}
   }
   //Returns the minimum allowed number of bathrooms
   public static int getMIN_BATHS()
   {
      return MIN_BATHS;
   }
   //Returns the maximum allowed number of bathrooms
   public static int getMAX_BATHS()
   {
      return MAX_BATHS;
   }
   //Returns the number of bedrooms
   public int getBaths()
   {
   return super.getBaths();
   }
   
   //Returns the minimum allowed rent
   public static double getMIN_RENT()
   {
      return MIN_RENT;
   }
   //Returns the maximum allowed rent
   public static double getMAX_RENT()
   {
      return MAX_RENT;
   }
   //Returns the rent
   public double getRent()
   {return this.rent;}
   //Sets the rent to myRent
   public boolean setRent(double myRent)
   {
      if(myRent>=MIN_RENT && myRent<=MAX_RENT)
      {
      this.rent=myRent;
      return true;
      }
      else
      {return false;}
   }
   
   //Returns the minimum allowed insurance
   public static double getMIN_INS()
   {
      return MIN_INS;
   }
   //Returns the insurance
   public double getIns()
   {return this.insurance;}
   //Sets the insurance to myIns
   public boolean setIns(double myIns)
   {
      if(myIns>=MIN_INS)
      {
      this.insurance=myIns;
      return true;
      }
      else
      {return false;}
   }
   
   //Returns whether the apartment has parking or not
   public boolean getHasParking()
   {
      return this.hasParking;
   }
   //Sets parking
   public void setHasParking(boolean myHasParking)
   {
      this.hasParking=myHasParking;
   }
   //Returns the total monthly cost
   public double monthlyCost()
   {return (this.rent+this.insurance);}
   //Creates a report listing all of the properties of this Apartment
   public String toString()
   {
   return "Address: "+super.getAddress()+"\nRent: $"+this.rent+"\nInsurance: $"+this.insurance+"\nHas Parking: "+this.hasParking+"\nMonthly Cost: $"+String.format("%.2f",monthlyCost());
   }
}