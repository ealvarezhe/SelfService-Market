import java.io.*;
import java.util.Scanner;

    public class Comprehensive_Lab_AlvarezHernandez{
        public static void main(String[] args) throws IOException{
            
            File fruitsdatabase = new File("fruitsdatabase.txt");
            Scanner fileScanner = new Scanner(fruitsdatabase);

            Scanner scnr = new Scanner(System.in);

            int OptionNum = 0;
     
            System.out.println("Welcome to Mejia");

            double Weight = 0.0;
            double FinalWeight = 0.0;
            double TotalPrice = 0.0;
            double FinalPrice = 0.0;
            String UserInput = "";
            int Bags = 0;
            double BagsCost = 0.15;
            double FinalBill = 0.0;

            do{
                System.out.println("Please select an option!");

                System.out.println("1. Add Item");
                System.out.println("2. View Cart");
                System.out.println("3. Clear Cart");
                System.out.println("4. Check out");
                System.out.println("5. Exit");

                OptionNum = scnr.nextInt();

                if(OptionNum == 1){
                    fileScanner = new Scanner(fruitsdatabase);
                    while(fileScanner.hasNextLine()){
                        
                        String Output = fileScanner.nextLine();
                        System.out.println(Output);
                    }
                    fileScanner = new Scanner(fruitsdatabase);

                    scnr.nextLine();
                    System.out.println("Enter the name of a fruit you'd like to add");
                    UserInput = scnr.nextLine();

                    System.out.println("How many pounds of this fruit are you adding?");
                    Weight = scnr.nextDouble();

                    String Fruit = "";
                    double FruitPrice = 0.0;
                    boolean found = false;

                    while(fileScanner.hasNextLine()){

                        Fruit = fileScanner.next();
                        FruitPrice = fileScanner.nextDouble();
                    
                        if(UserInput.equalsIgnoreCase(Fruit)){
                            TotalPrice = (Weight * FruitPrice);
                            FinalWeight = (FinalWeight + Weight);
                            FinalPrice = (FinalPrice + TotalPrice);
                            System.out.println("Your current total weight is " + FinalWeight + " and your current price is " + FinalPrice);
                            found = true;
                            break;
                        }
                    }
                    if(found == false){
                            System.out.println("Error. Enter a valid input for a fruit on the list");
                        
                    }
                }
                

                if(OptionNum == 2){
                    if(FinalPrice == 0 || FinalWeight == 0){
                        System.out.println("No items in the cart, select 1 to add items");
                    }
                    else{
                        System.out.println("Your current total weight is " + FinalWeight + " and your current total price is " + FinalPrice);
                    }
                }

                else if(OptionNum == 3){
                    System.out.println("Cart Cleared");
                    FinalPrice = 0;
                    FinalWeight = 0;
                }
                
                else if(OptionNum == 4){
                    int TotalBags = 0;
                    double GiftCard = 0;

                    if(FinalPrice > 0 && FinalWeight > 0){

                        TotalBags = (int) Math.ceil(FinalWeight / 5);
                        System.out.println("Your current total weight is " + FinalWeight + " and your current total price is " + FinalPrice);
                        System.out.println("Time to checkout! How many bags did you bring?");
                        Bags = scnr.nextInt();

                        if(Bags < TotalBags){
                            TotalBags = (TotalBags - Bags);
                            System.out.println("Your total weight is " + FinalWeight + " pounds so you need to purchase " + TotalBags + " additional bags which cost $" + BagsCost);

                            double FinalBagsPrice = (TotalBags * BagsCost);
                            FinalBill = (FinalBagsPrice + FinalPrice);
                        
                            System.out.println("Your total is $" + FinalBill);
                         System.out.println("Enter gift card amount");
                            GiftCard = scnr.nextDouble();

                            if(GiftCard < FinalBill){
                                System.out.println("Insufficient funds");
                            }
                            else{
                                GiftCard = (GiftCard - FinalBill);
                                System.out.println("Thank you for shopping at MejiaMart, come back soon!");
                                System.out.println("Remaining gift card balance: $" + GiftCard);
                            }
                        }
                        else if(Bags >= TotalBags){
                            System.out.println("Your total is $" + FinalPrice);
                            System.out.println("Enter gift card amount");
                            GiftCard = scnr.nextDouble();

                            if(GiftCard < FinalPrice){
                                System.out.println("Insufficient funds");
                            }
                            else{
                                GiftCard = (GiftCard - FinalPrice);
                                System.out.println("Thank you for shopping at MejiaMart, come back soon!");
                                System.out.println("Remaining gift card balance: $" + GiftCard);
                            }
                        }
                    }
                    else{
                        System.out.println("No items for checkout");
                    }
                }

                else if(OptionNum == 5){
                    System.out.println("Goodbye");
                    System.out.print("");
                }

                else if(OptionNum > 5){
                    System.out.println("Please select a valid option");
                }
            

                System.out.println("");

            }while(OptionNum != 5);
        
            

        }
    }