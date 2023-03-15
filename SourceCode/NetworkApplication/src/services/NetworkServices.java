/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @author Ankit Kumar
 * Note: When User is change the name of there Network Services then may be this program not work
 */
public class NetworkServices {

    public void disableNetwork() {
        String locationOfBatFile = System.getProperty("user.dir") + "\\src\\resources\\NetworkDisable.lnk";
        String[] commandForNetworkDisable = {"cmd", "/c", locationOfBatFile};

        String result = processBuilder(commandForNetworkDisable);
        if (result.isEmpty() || result.equals(" ")) {
            System.out.println("Success");
        } else if (result.equalsIgnoreCase("Failed")) {
            disableNetwork();
            System.out.print("call again disable");
        } else {
            System.out.println(result);
        }
    }

    public void enableNetwork() {
        String locationOfBatFile = System.getProperty("user.dir") + "\\src\\resources\\NetworkEnable.lnk";
        String[] commandForNetworkEnable = {"cmd", "/c", locationOfBatFile};

        String result = processBuilder(commandForNetworkEnable);
        if (result.isEmpty() || result.equals(" ")) {
            System.out.println("Success");
        } else if (result.equalsIgnoreCase("Failed")) {
            enableNetwork();
            System.out.print("call again enable");
        } else {
            System.out.println(result);
        }
    }

    private static String processBuilder(String[] commands) {
        ProcessBuilder processBuilder = new ProcessBuilder(commands);
        try {
            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            int exitVal = process.waitFor();
            System.out.println("======>" + output);
            if (exitVal == 0) {
                System.out.println("---->" + output);
                System.out.println("command executed success");
                return output.toString();
            } else {
                //abnormal...
                System.out.println("command executed failed");
                if (output.length() == 0) {
                    System.out.println("Clicked NO Button");
                    return "Failed";
                }
                return output.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        return "Failed";
    }

    public void closeCommandPrompt()throws Exception{
         System.out.println("closing cmd....");
        Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
         System.out.println("closed");
    }
}

