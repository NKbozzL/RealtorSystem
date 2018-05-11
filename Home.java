/**
Name: Nicholas Boesel
Date: 4/13/2016
Course/Section: IT 206.001
Assignment: Programming Assignment 8

Subclass of Townhouse, adds limits to the annual homeowner's fee, and allows users to enter a lot size.
It also allows the user to change all of these valuse and give outputs based around mothly cost and reports on the individual details
on each Apartment listing.*/
public class Home extends TownHouse
{
   private static final double MIN_ANNFEE=0.0;
   private double lotSize;
   private double annFee;
   //Constructor -uses TownHouse
   public Home()
   {super();}
   //Returns the minimum allowed annual fee
   public static double getMIN_ANNFEE()
   {
      return MIN_ANNFEE;
   }
   //Returns the annual fee
   public double getFee()
   {return this.annFee;}
   //Sets the annual fee to myFee
   public boolean setFee(double myFee)
   {
      if(myFee>=MIN_ANNFEE)
      {
      this.annFee=myFee;
      return true;
      }
      else
      {return false;}
   }
   
   //Retruns the size of the lot
   public double getLotSize()
   {return this.lotSize;}
   //Sets the size of the lot to myLotSize
   public boolean setLotSize(double myLotSize)
   {
      if(myLotSize>=0)
      {
      this.lotSize=myLotSize;
      return true;
      }
      else
      {return false;}
   }
   //Returns the total monthly cost
   public double monthlyCost()
   {return (super.getMort()+(super.getIns()/12)+(super.getTax()/12)+(this.annFee/12));}
   //Creates a report listing all of the properties of this Apartment
   public String toString()
   {
   return "Address: "+super.getAddress()+"\nMortgage: $"+super.getMort()+"\nInsurance: $"+super.getIns()+"\nAnnual Tax: "+super.getTax()+"\nAnnual Fee:"+this.annFee+"\nMonthly Cost: $"+String.format("%.2f",monthlyCost()+"\nLot Size(m): "+this.lotSize);
   }
}