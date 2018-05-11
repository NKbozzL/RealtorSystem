/**
Name: Nicholas Boesel
Date: 4/13/2016
Course/Section: IT 206.001
Assignment: Programming Assignment 8

This class contains the DDC for Residence, a superclass that is used to define the other classes presented in this assignment,
giving each class an address, a number of bedrooms, a number of bathrooms, and a total number of homes*/
public abstract class Residence
{
   private int bedrooms;
   private int bathrooms;
   private static int totalHomes;
   private String address;
   //Constructor
   public Residence()
   {
      this.bedrooms=0;
      this.bathrooms=0;
      totalHomes++;
   }
   //returns the number of bedrooms
   public int getBeds()
   {
      return this.bedrooms;
   }
   //changes the number of bedrooms to myBeds
   public boolean setBeds(int myBeds)
   {this.bedrooms=myBeds;
   return true;}
   //changes the number of bathrooms to myBaths
   public boolean setBaths(int myBaths)
   {this.bathrooms=myBaths;
   return true;}
   //returns the number of bathrooms
   public int getBaths()
   {
      return this.bathrooms;
   }
   //returns the total number of residences listed
   public static int getTotal()
   {
      return totalHomes;
   }
   //returns the text address
   public String getAddress()
   {
      return this.address;
   }
   //sets the address to myAddress
   public boolean setAddress(String myAddress)
   {
      if(!myAddress.equals(""))
      {this.address=myAddress;
      return true;}
      else
      {return false;}
   }
}