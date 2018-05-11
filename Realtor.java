/**
Name: Nicholas Boesel
Date: 4/13/2016
Course/Section: IT 206.001
Assignment: Programming Assignment 8

The code here is meant to help people looking for a home find what they need as far as what they enter.
Realtor allows the user to select and entert the details for up to 18 places that they could possibly live.
The program then processes the input data into a list of properties and processes them based on the type of property
(Apartment, TownHouse, Single Family Home), the monthly rent, and(with single family dwellings) average lot size.
It also inlcudes the cheapest porpery's address and other data at the end in the summary.*/

import javax.swing.JOptionPane;
public class Realtor
{  
   /*
   Method: fillList
Purpose: fills a list of houses up to the limit or until someone is done entering listings of residencies.
Input: HouseList[]: array-The array of homes to be edited
Return: HouseList[]: array-The array of homes, now edited
   */
   public static void main(String[] args)
   {
      final int HOUSE_LIMIT=initHouseLimit();
      Residence[] houseList=initHouseList(HOUSE_LIMIT);
      houseList=fillList(houseList,HOUSE_LIMIT);
      summary(houseList);
   }
   /*
   Method: fillList
Purpose: fills a list of houses up to the limit or until someone is done entering listings of residencies.
Input: HouseList[]: array-The array of homes to be edited
Return: HouseList[]: array-The array of homes, now edited
   */
   public static Residence[] fillList (Residence[] houseList,int HOUSE_LIMIT)
   {
      int residencyListings=0;
      boolean goAgain=true;
      for(int i=0;i<houseList.length && goAgain==true;i++)
      {
         int choice=pickResidence();
         if(choice==0)
         {houseList[i]=listApt();}
         if(choice==1)
         {houseList[i]=listTownHouse();}
         if(choice==2)
         {houseList[i]=listHome();}
         residencyListings++;
         goAgain=wannaContinue(goAgain);
         overLimit(residencyListings,HOUSE_LIMIT);
      }
      return houseList;
   }
   /*
   Method: initHouseLimit
Purpose: creates the size limit to the housing list
Input: none
Return: HOUSE_LIMIT: int
   */
   public static int initHouseLimit()
   {return 18;}
   /*
   Method: initHouseList
Purpose: Initializes an array of 18 spaces for housing
Input: HOUSE_LIMIT: int
Return: HouseList[]: array- an array for residence objects
   */
   public static Residence[] initHouseList(int HOUSE_LIMIT)
   {
      Residence[] houseList;
      houseList=new Residence[HOUSE_LIMIT];
      return houseList;
   }
   /*
   Method: pickResidence
Purpose: shows three buttons with each of the options to choose from Apartment, TownHouse, and, Home
Input: none
Return: iPick: int the choice of housing tpye
   */
   public static int pickResidence()
   {  
      String[] options ={"Apartment","Townhouse","Single Family House"};
      int iPick=JOptionPane.showOptionDialog(null, "Which kind of home do you want?","",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,"");
      return iPick;
   }
   /*
   Method: wannaContinue
Purpose: asks if the user still wants to continue entering Residency listings
Input: myChoice: boolean
Return: myChoice: Boolean
   */
   public static boolean wannaContinue(boolean myChoice)
   {
      int option=JOptionPane.showConfirmDialog(null, "Would you like to continue entering home listings?","",JOptionPane.YES_NO_OPTION);
      if(option==0)
      {myChoice=true;}
      else
      {myChoice=false;}
      return myChoice;
   }
   /*
   Method: listApt
Purpose: creates an Apartment based on user input ran through this method
Input: none
Return: newApt: Apt
   */
   public static Apt listApt()
   {
      Apt newApt=new Apt();
      boolean goodAddress=false;
      do
      {
         try{
            String myAddress=JOptionPane.showInputDialog("Enter the Address");
            goodAddress=newApt.setAddress(myAddress);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving address");}
      }while(!goodAddress);
      boolean goodBeds=false;
      do
      {
         try{
            int myBeds=Integer.parseInt(JOptionPane.showInputDialog("Enter the number of bedrooms"));
            goodBeds=newApt.setBeds(myBeds);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodBeds);
      boolean goodBaths=false;
      do
      {
         try{
            int myBaths=Integer.parseInt(JOptionPane.showInputDialog("Enter the number of bathrooms"));
            goodBaths=newApt.setBaths(myBaths);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodBaths);
      boolean goodRent=false;
      do
      {
         try{
            double myRent=Double.parseDouble(JOptionPane.showInputDialog("Enter the monthly rent"));
            goodRent=newApt.setRent(myRent);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodRent);
      boolean goodIns=false;
      do
      {
         try{
            double myIns=Double.parseDouble(JOptionPane.showInputDialog("Enter the monthly Insurance"));
            goodIns=newApt.setIns(myIns);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodIns);
      boolean myHasParking=false;
      int choice=JOptionPane.showConfirmDialog(null, "Does the Apartment have Parking?","",JOptionPane.YES_NO_OPTION);
      if(choice==0)
      {myHasParking=true;}
      else
      {myHasParking=false;}
      newApt.setHasParking(myHasParking);
      JOptionPane.showMessageDialog(null,newApt.toString());
      return newApt;
   }
   /*
   Method: listTownHouse
Purpose: creates a TownHouse based on user input ran through this method
Input: none
Return: newTownHouse: TownHouse
   */
   public static TownHouse listTownHouse()
   {
      TownHouse newTownHouse=new TownHouse();
      boolean goodAddress=false;
      do
      {
         try{
            String myAddress=JOptionPane.showInputDialog("Enter the Address");
            goodAddress=newTownHouse.setAddress(myAddress);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving address");}
      }while(!goodAddress);
      boolean goodBeds=false;
      do
      {
         try{
            int myBeds=Integer.parseInt(JOptionPane.showInputDialog("Enter the number of bedrooms"));
            goodBeds=newTownHouse.setBeds(myBeds);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodBeds);
      boolean goodBaths=false;
      do
      {
         try{
            int myBaths=Integer.parseInt(JOptionPane.showInputDialog("Enter the number of bathrooms"));
            goodBaths=newTownHouse.setBaths(myBaths);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodBaths);
      boolean goodMort=false;
      do
      {
         try{
            double myMort=Double.parseDouble(JOptionPane.showInputDialog("Enter the monthly rent"));
            goodMort=newTownHouse.setMort(myMort);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodMort);
      boolean goodIns=false;
      do
      {
         try{
            double myIns=Double.parseDouble(JOptionPane.showInputDialog("Enter the monthly Insurance"));
            goodIns=newTownHouse.setIns(myIns);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodIns);
      boolean goodTax=false;
      do
      {
         try{
            double myTax=Double.parseDouble(JOptionPane.showInputDialog("Enter the annual tax"));
            goodTax=newTownHouse.setTax(myTax);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodTax);
      JOptionPane.showMessageDialog(null,newTownHouse.toString());
      return newTownHouse;
   }
   /*
   Method: listHome
Purpose: creates a Single Family Home based on user input ran through this method
Input: none
Return: newHome: Home
   */
   public static Home listHome()
   {
      Home newHome=new Home();
      boolean goodAddress=false;
      do
      {
         try{
            String myAddress=JOptionPane.showInputDialog("Enter the Address");
            goodAddress=newHome.setAddress(myAddress);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving address");}
      }while(!goodAddress);
      boolean goodBeds=false;
      do
      {
         try{
            int myBeds=Integer.parseInt(JOptionPane.showInputDialog("Enter the number of bedrooms"));
            goodBeds=newHome.setBeds(myBeds);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodBeds);
      boolean goodBaths=false;
      do
      {
         try{
            int myBaths=Integer.parseInt(JOptionPane.showInputDialog("Enter the number of bathrooms"));
            goodBaths=newHome.setBaths(myBaths);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodBaths);
      boolean goodMort=false;
      do
      {
         try{
            double myMort=Double.parseDouble(JOptionPane.showInputDialog("Enter the monthly rent"));
            goodMort=newHome.setMort(myMort);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodMort);
      boolean goodIns=false;
      do
      {
         try{
            double myIns=Double.parseDouble(JOptionPane.showInputDialog("Enter the monthly Insurance"));
            goodIns=newHome.setIns(myIns);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodIns);
      boolean goodTax=false;
      do
      {
         try{
            double myTax=Double.parseDouble(JOptionPane.showInputDialog("Enter the annual tax"));
            goodTax=newHome.setTax(myTax);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodTax);
      boolean goodFee=false;
      do
      {
         try{
            double myFee=Double.parseDouble(JOptionPane.showInputDialog("Enter the anual fee"));
            goodTax=newHome.setFee(myFee);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodFee);
      boolean goodLotSize=false;
      do
      {
         try{
            double myLotSize=Double.parseDouble(JOptionPane.showInputDialog("Enter the Lot Size"));
            goodTax=newHome.setLotSize(myLotSize);
            }
            catch(NumberFormatException e)
            {JOptionPane.showMessageDialog(null,"Error receiving number");}
      }while(!goodLotSize);
      JOptionPane.showMessageDialog(null,newHome.toString());
      return newHome;
   }
   /*
   Method: overLimit
Purpose: displays an error if the number of Residency listings exceed 18
Input: residencyListings: int, HOUSE_LIMIT: int
Return: none   
   */
   public static void overLimit(int residencyListings, int HOUSE_LIMIT)
   {
      if(residencyListings>HOUSE_LIMIT)
      {JOptionPane.showMessageDialog(null,"You are trying to enter more residencies than allowed!");}
   }
   /*
   Method: avgLotSize
Purpose: calculates the average lot size based on the total number of single family homes versus each of their sizes
Input: HouseList[]: array
Return: lotAvg: double
   */
   public static double avgLotSize(Residence[] houseList)
   {
      double average=0.0;
      int houses=0;
      for(int i=0;i<houseList.length;i++)
      {
         if(houseList[i]!=null && houseList[i] instanceof Home)
         {
            average+=((Home)houseList[i]).getLotSize();
            houses++;
         }
      }
      average=average/houses;
      return average;
   }
   /*
   Method: cheapestPlace
Purpose: finds the cheapest property amongst all of the ones listed and outputs the address of it.
Input: HouseList[]: array
Return: cheapestPlace: String
   */
   public static String cheapestPlace(Residence[] houseList)
   {
      double cheapest=1000000.0;
      String cheapestPlace="";
      for(int i=0;i<houseList.length;i++)
      {
         if(houseList[i]!=null)
         {
            if(houseList[i] instanceof Apt)
            {if(((Apt)houseList[i]).monthlyCost()<cheapest)
               cheapest=((Apt)houseList[i]).monthlyCost();
               cheapestPlace=((Apt)houseList[i]).toString();
            }
            if(houseList[i] instanceof Home)
            {if(((Home)houseList[i]).monthlyCost()<cheapest)
               cheapest=((Home)houseList[i]).monthlyCost();
               cheapestPlace=((Home)houseList[i]).toString();
            }
            if(houseList[i] instanceof TownHouse && !(houseList[i] instanceof Home))
            {if(((TownHouse)houseList[i]).monthlyCost()<cheapest)
               cheapest=((TownHouse)houseList[i]).monthlyCost();
               cheapestPlace=((TownHouse)houseList[i]).toString();
            }
         }
      }
      return cheapestPlace;
   }
   /*
   Method: summary
Purpose: displays a summary of the given list of Houses selected by the user. It shows how many homes the user has viewed, the average lot size for the single family houses, and the place with the cheapest price. Runs avgLotSize and cheapestPlace inside of it to get the calculations
Input: HouseList[]: array
Return: none
   */
   public static void summary(Residence[] houseList)
   {
      int totalHomes=0;
      for(int i=0;i<houseList.length;i++)
      {
         if(houseList[i]!=null)
         {
            totalHomes++;
         }
      }
      String cheapest=cheapestPlace(houseList);
      double avgLot=avgLotSize(houseList);
      JOptionPane.showMessageDialog(null,"Total Homes: "+totalHomes+"\n\nCheapest Property Details :\n"+cheapest+"\n\nAverage Lot Size: "+avgLot);
   }
}