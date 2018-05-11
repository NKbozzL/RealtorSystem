/**
Name: Nicholas Boesel
Date: 4/13/2016
Course/Section: IT 206.001
Assignment: Programming Assignment 8

Subclass of Residence, adds limits to the number of bathrooms, bedrooms, the insurance, the mortgage, and the annual tax.
It also allows the user to change all of these valuse and give outputs based around mothly cost and reports on the individual details
on each Townhouse listing.*/
public class TownHouse extends Residence
{
   private static final int MIN_BEDS=2;
   private static final int MAX_BEDS=5;
   private static final int MIN_BATHS=2;
   private static final int MAX_BATHS=4;
   private static final double MIN_MORT=800.0;
   private static final double MAX_MORT=3000.0;
   private static final double MIN_INS=200.0;
   private static final double MAX_INS=1500.0;
   private static final double MIN_ANNTAX=0.0;
   private static final double MAX_ANNTAX=1800.0;
   private double mortgage;
   private double annTax;
   private double insurance;
   //Constructor -uses Residence
   public TownHouse()
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
   //Returns the number of bathrooms
   public int getBaths()
   {
   return super.getBaths();
   }
   
   //Returns the minimum allowed mortgage payment
    public static double getMIN_MORT()
   {
      return MIN_MORT;
   }
   //Returns the maximum allowed mortgage payment
   public static double getMAX_MORT()
   {
      return MAX_MORT;
   }
   //Returns the mortgage payment
   public double getMort()
   {return this.mortgage;}
   //Sets the mortgage payment to myMort
   public boolean setMort(double myMort)
   {
      if(myMort>=MIN_MORT && myMort<=MAX_MORT)
      {
      this.mortgage=myMort;
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
   //Returns the maximum allowed insurance
   public static double getMAX_INS()
   {
      return MAX_INS;
   }
   //Returns the insurance
   public double getIns()
   {return this.insurance;}
   //Sets the insurance to myIns
   public boolean setIns(double myIns)
   {
      if(myIns>=MIN_INS && myIns<=MAX_INS)
      {
      this.insurance=myIns;
      return true;
      }
      else
      {return false;}
   }
   
   //Returns the minimum allowed annual tax
   public static double getMIN_ANNTAX()
   {
      return MIN_ANNTAX;
   }
   //Returns the maximum allowed annual tax
   public static double getMAX_ANNTAX()
   {
      return MAX_ANNTAX;
   }
   //Returns the annual tax
   public double getTax()
   {return this.annTax;}
   //Sets the annual tax to myTax
   public boolean setTax(double myTax)
   {
      if(myTax>=MIN_ANNTAX && myTax<=MAX_ANNTAX)
      {
      this.annTax=myTax;
      return true;
      }
      else
      {return false;}
   }
   //Returns the address
   public String getAddress()
   {return super.getAddress();}
   //Creates a report listing all of the properties of this Apartment
   public String toString()
   {
   return "Address: "+getAddress()+"\nMortgage: $"+this.mortgage+"\nInsurance: $"+this.insurance+"\nAnnual Tax: "+this.annTax+"\nMonthly Cost: $"+String.format("%.2f",monthlyCost());
   }
   //Returns the total monthly cost
   public double monthlyCost()
   {return (this.mortgage+(this.insurance/12)+(this.annTax/12));}
}