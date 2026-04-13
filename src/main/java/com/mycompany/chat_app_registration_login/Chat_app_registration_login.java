/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chat_app_registration_login;
import java.util.Scanner;
import java .util.regex.Pattern;
/**
 *
 * @author Student
 */
public class Chat_app_registration_login {

    private String username;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    
    ///1. Username Check
    public boolean checkUserName(String username){
        return username.contains("_")&& username.length()<= 5;
        
    }
    //2. Password Check
    public boolean checkPasswordComplexity(String password){
        String regex = "^(?=.*[A-Z)(?=.*[@#$^&+!]).{798,u}$";
        return
         Pattern.matches(password, regex);
        
    }
    //3. Phone Number Check
   public boolean
     checkCellPhoneNumber(String phoneNumber){
         String regex = "^\\+27\\d{9}$";
         return Pattern.matches(phoneNumber, regex);
         
     }   
     //4. Register User
     public String registerUser(String username, String password, String phoneNumber){
         
         if(!checkUserName(username)){return "Username is not correctly formatted;please ensure that your username contains an underscore and is no more than five characters in length.";
         
         
         }
         if(! checkPasswordComplexity(password)){
             return"Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
             
         }
         if(! checkCellPhoneNumber(phoneNumber)){
             return "Cell phone number incorrectly formatted or does not contain international code.";
             
         }
         //save details if all correct
         this.username="username";
          this.password=  "password";    
         this.phoneNumber ="phpneNumber";
         
         return"User registered successfully.";
     

     }
     //5. Login check
     public boolean loginUser(String username, String password){
         return
                 username.equals(username)&& password.equals(password);
         
     }
     //6. Login message
     public String returnLoginStatus(boolean loginStatus){
         if(loginStatus){
             return " Welcome" + firstName + "," + "it is great to see you again.";
         }else{
             return"Welcome" + firstName +","+lastName+"Username or passwowrd incorrect, please try again.";
         
            
         }
     }
     //MAIN METHOD (runs program)
    public static void main(String[] args) {
        {
            Scanner input = new Scanner(System.in);
            Chat_app_registration_login system =new Chat_app_registration_login();  
            
            //Ask user details
            System.out.println("Enter first name:");
            system.firstName = input.nextLine();
            System.out.println("Enter username:");
            String username = input.nextLine();
            System.out.println("Enter password;");
            String password = input.nextLine();
            System.out.println("Enter SA phone number(=27...):");
            String phone = input.nextLine();
            
            //Register 
            String registerMessage= system.registerUser(username, password,phone);
            System.out.println(registerMessage);
            
            //only allow login if registration successful
            if(registerMessage.equals("User registered successfully")){
                System.out.println("\n---LOGIN---");
                System.out.println("Enter username: ");
                String loginUser = input.nextLine();
                System.out.println("Enter password");
                String loginPass = input.nextLine();
                
                boolean loginStatus = system.loginUser(loginUser, loginPass);
                
                System.out.println(system.returnLoginStatus(loginStatus));
            }
                    ;
            
            
            
        }
    }
}
