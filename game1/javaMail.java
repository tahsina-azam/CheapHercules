/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

/**
 *
 * @author USER
 */
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author AMEYA DEBNATH
 */
public class javaMail {
    
    public static String code;
    
     private static boolean validate_email(String email)
       {
           boolean status ;
           String email_Pattern="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$*";
           Pattern pattern =Pattern.compile(email_Pattern);
           Matcher matcher=pattern.matcher(email);
           status = matcher.matches();
           return status;
       }
    
     public static boolean check(String email) throws MessagingException {
         
    JFrame frame=new JFrame();
     String userCode;
        if(validate_email(email))
        {
            
             sendMail(email);
            JOptionPane.showMessageDialog(frame,"This Email is valid\n We sent a verification code to this Email","",JOptionPane.INFORMATION_MESSAGE);
//            System.out.println("ok this email is correct,we send a code to this email,enter that code");
           userCode=JOptionPane.showInputDialog(frame,"GIVE CODE");
            System.out.println(code + userCode);
           if(!(userCode==code))
           {
                
//                System.out.println("correct code");
                return true;
           }
              
           else {
                JOptionPane.showMessageDialog(frame,"Wrong verification Code","",JOptionPane.ERROR_MESSAGE);
                return false;
           }
        }
        
        else
        {
            
            JOptionPane.showMessageDialog(frame,"Wrong Email Address","",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
     
    public static String sendMail(String recepient) throws MessagingException
    {
        
        Properties properties =new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail="atahsinam@gmail.com";
        String password="ameyamotu2020";
        
        Session session=Session.getInstance(properties,new Authenticator() {
                
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(myAccountEmail,password);
                    }
                    });
        Message message=prepareMessage(session,myAccountEmail,recepient);
        Transport.send(message);
        System.out.println("Message sent successfully");
        
        return code;
        
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) throws AddressException {
     
        
        try {
            Random random=new Random();
            code=Integer.toString(random.nextInt(10000));
            Message message =new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("confirmation of this email from Cheap Hercules\n");
            message.setText("Use this code for confirming this mail\n"+"Verification Code : "+code);
            System.out.println("Verification Code : "+code);
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(javaMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public static void main(String[] args) throws MessagingException {
        javaMail.check("ameyadebnath@gmail.com");
    }
}

